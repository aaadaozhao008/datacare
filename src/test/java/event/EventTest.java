package event;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
class Constant{
	public static final byte MIN = 60;
	public static final byte HOUR = 60;
	public static final byte DAY = 24;
	public static final byte MIN_SAVE = 10;
	public static final byte HOUR_SAVE = 6;
	public static final byte DAY_SAVE = 6;
}
public class EventTest {
	static boolean find1 = false;
	static boolean find2 = false;
	static Random r = new Random();
	static int[] hostIds = new int[500];//100个e2eid
	static int[] kpiIds = new int[100];//100个kpiid
	static final Map<Integer,Map<Integer,DataOfTime>> mapByHost = new HashMap<>();//key1=hostId,key2=apiId
	/**
	 * 获取是否是显著性,1:是,0:否;
	 * @return
	 */
	static byte getDiff() {
		return (byte)Math.round(r.nextDouble());
	}
	static PrintWriter pw = null;
	static {
		for (int i = 0; i < 100; i++) {
			kpiIds[i] = hostIds[i] = i+1;
		}
		for (int i = 100; i < 500; i++) {
			hostIds[i] = i+1;
		}
		try {
			pw = new PrintWriter("E:\\pcap\\test.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//生成数据启动;
		new Thread(new Runnable() {
			@Override
			public void run() {
				int min = 0;
				int second = 1;
				pw.println("模拟数据启动");
				while(true) {
					if(find1&&find2) {
						pw.println("监控都已结束,模拟数据停止制造");
						break;//监控都已结束,模拟数据停止制造
					}
					byte diff;
					for (int hostId = 1; hostId < 501; hostId++) {//模拟host
						for (int kpiId  = 1; kpiId < 101; kpiId++) {//模拟 kpi
							diff = getDiff();//是否显著 
							if(hostId == 2&&(kpiId == 10||kpiId == 11))diff = 1;//让服务器是2的指标10跟11显著性;
							addData(hostId, kpiId, diff);
						}
					}
					pw.println("==========="+min+" min:"+second+" s==========");
					second++;
					if(second == 60) {
						min++;
						second = 1;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	public static void main(String[] args) {
		/*
		 * 1.业务事件规则:监控kpiId,连续120s都是显著性的报警;
		 * 
		 *  缓存业务事件 :生成后暂时直接打印出来.没做缓存,因为测试中没人要用到;
		 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					Collection<Map<Integer, DataOfTime>> valuesFather = mapByHost.values();
					//业务事件监听线程-定时任务轮询时间队列;
					for (Map<Integer, DataOfTime> map : valuesFather) {
						Collection<DataOfTime> values = map.values();
						for (DataOfTime data : values) {
							int minCount = data.getMinCount();
							if (minCount < 2) {//不足2min的直接跳过
								continue;
							}
							byte[][] mins = data.getMins();
							boolean isWarning = true;
							outer:for (int i = 1; i <= 2; i++) {
								for (int j = 0; j < Constant.MIN; j++) {
									if(mins[i][j] == 0) {//说明不连续,直接结束循环
										isWarning = false;//不需要报警
										break outer;
									}
								}
							}
							if(isWarning) {
								pw.println("警报1:服务器id="+data.getHostId()+"的指标==>"+data.getKpiId()+";最近120s内连续出现显著现象;");
								find1 = true;
							}
						}
					}
					if(find1) {
						pw.println("警报1结束监控");
						break;//防止刷屏;监测到一批就结束
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		//2.监控hostId,连续30min都是显著性的报警;业务事件监听线程-定时任务轮询时间队列
		while(true) {
			Collection<Map<Integer, DataOfTime>> valuesFather = mapByHost.values();
			for (Map<Integer, DataOfTime> map : valuesFather) {
				Collection<DataOfTime> values = map.values();
				for (DataOfTime data : values) {
					int hourCount = data.getHourCount();
					int hourindex = data.getHourIndex();
					if (hourCount < 1 && hourindex < 30) {//不足30min的直接跳过
						continue;
					}
					byte[][] hours = data.getHours();
					boolean isWarning = true;
					if(hourindex < 30) {//说明还需要去上一分钟的最后拿数据;
						for (int j = 0; j < hourindex; j++) {
							if(hours[0][j] == 0) {//说明不连续,直接结束循环
								isWarning = false;//不需要报警
								break;
							}
						}
						if(!isWarning) {
							int najige = 30 - hourindex;
							for (int j = 0; j < najige; j++) {
								if(hours[1][Constant.HOUR - j] == 0) {//说明不连续,直接结束循环
									isWarning = false;//不需要报警
									break;
								}
							}
						}
					}else {
						for (int j = 0; j <= 30; j++) {
							if(hours[0][j] == 0) {//说明不连续,直接结束循环
								isWarning = false;//不需要报警
								break;
							}
						}
					}
					if(isWarning) {
						pw.println("警报2:服务器id="+data.getHostId()+"的指标==>"+data.getKpiId()+";最近30min内连续出现显著现象;");
						find2 = true;
					}
				}
			}
			
			if(find2) {
				pw.println("警报2结束监控");
				break;//防止刷屏;监测到一批就结束
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		pw.close();
	}
	/**
	 * 数据维护-入队，出队（淘汰），晋级
	 * @param hostId
	 * @param kpiId
	 * @param diff hostId当前秒 的 这个kpiId 是否显著
	 */
	static void addData(int hostId,int kpiId,byte diff) {
		 Map<Integer, DataOfTime> map = mapByHost.get(hostId);
		 if(map == null) {
			 map = new ConcurrentHashMap<>();
			 mapByHost.put(hostId, map);
		 }
		 DataOfTime dataOfTime = map.get(kpiId);
		if(dataOfTime == null) {//第一次来
			dataOfTime = new DataOfTime();
			dataOfTime.setKpiId(kpiId);
			dataOfTime.setHostId(hostId);
			byte[][] mins = dataOfTime.getMins();
			int minIndex = dataOfTime.getMinIndex();
			mins[0][minIndex] = diff;
			dataOfTime.setMinIndex(minIndex+1);//下标+1
			map.put(kpiId, dataOfTime);
		}else {
			int minIndex = dataOfTime.getMinIndex();
			byte[][] mins = dataOfTime.getMins();
			if(minIndex == Constant.MIN) {//说明0-59已经记录完毕,需要进位
				//先将分钟的安置好
				int minCount = dataOfTime.getMinCount();
				byte [][] newMin = new byte[Constant.MIN_SAVE][Constant.MIN];
				if(minCount == Constant.MIN_SAVE)minCount =  Constant.MIN_SAVE-1;//说明10个都满了,要移除最后一个;
				for (int i = 0; i < minCount; i++) {//所有集合往后移;
					newMin[i+1] = mins[i];
				}
				newMin[0][0] = diff;//新来的记录进去
				dataOfTime.setMinIndex(1);//下标1
				dataOfTime.setMins(newMin);//新的放进去;
				dataOfTime.setMinCount(dataOfTime.getMinCount()+1);//记录数+1,过10则不加
				byte[] nowMin = mins[0];
				diff = 0;//无显著性
				for (int i = 0; i < nowMin.length; i++) {
					if(nowMin[i] == 1) {
						diff = 1;//有1个为1就是1
						break; 
					}
				}
				//处理小时的
				int hourIndex = dataOfTime.getHourIndex();
				byte[][] hours = dataOfTime.getHours();
				if(hourIndex == Constant.HOUR) {//说明0-59已经记录完毕,需要进位
					int hourCount = dataOfTime.getHourCount();
					byte [][] newHour = new byte[Constant.HOUR_SAVE][Constant.HOUR];
					if(hourCount == Constant.HOUR_SAVE)hourCount = Constant.HOUR_SAVE-1;//说明6个都满了,要移除最后一个;
					for (int i = 0; i < hourCount; i++) {//所有集合往后移;
						newHour[i+1] = hours[i];
					}
					newHour[0][0] = diff;//新来的记录进去
					dataOfTime.setHourIndex(1);//下标1
					dataOfTime.setHours(newHour);//新的放进去;
					dataOfTime.setHourCount(dataOfTime.getHourCount()+1);//记录数+1,过6则不加
					byte[] nowHour = hours[0];
					diff = 0;//无显著性
					for (int i = 0; i < nowHour.length; i++) {
						if(nowHour[i] == 1) {
							diff = 1;//有1个为1就是1
							break; 
						}
					}
					//处理天的
					int dayIndex = dataOfTime.getDayIndex();
					byte[][] days = dataOfTime.getDays();
					if(dayIndex == Constant.DAY) {//说明0-24已经记录完毕,需要进位
						int dayCount = dataOfTime.getDayCount();
						byte [][] newDay = new byte[Constant.DAY_SAVE][Constant.DAY];
						if(dayCount == Constant.DAY_SAVE)dayCount = Constant.DAY_SAVE-1;//说明6个都满了,要移除最后一个;
						for (int i = 0; i < dayCount; i++) {//所有集合往后移;
							newDay[i+1] = days[i];
						}
						newDay[0][0] = diff;//新来的记录进去
						dataOfTime.setDayIndex(1);//下标1
						dataOfTime.setDays(newDay);//新的放进去;
						dataOfTime.setDayCount(dataOfTime.getDayCount()+1);//记录数+1,过6则不加
						//...后面暂时没了
					}else {
						days[0][dayIndex] = diff;
						dataOfTime.setDayIndex(dayIndex+1);
					}
				}else {
					hours[0][hourIndex] = diff;
					dataOfTime.setHourIndex(hourIndex+1);
				}
			}else {
				mins[0][minIndex] = diff;
				dataOfTime.setMinIndex(minIndex+1);//下标+1
			}
		}
	}
}
class DataOfTime{
	private int hostId;//服务器id
	private int kpiId;//指标id
	private byte[][] mins = new byte[Constant.MIN_SAVE][Constant.MIN];//秒的集合 记录最近10分钟的.下标0是当前的, 9 是 当前-9分钟 的
	private byte[][] hours = new byte[Constant.HOUR_SAVE][Constant.HOUR];//分钟的集合 记录 6小时的 
	private byte[][] days = new byte [Constant.DAY_SAVE][Constant.DAY];//小时的集合	记录6天的.
	private int minCount;//已记录了几分钟 0=当前无满集合.9表示已经记录了9个满分钟的集合.
	private int minIndex;//下次赋值的下标
	private int hourCount;
	private int hourIndex;
	private int dayCount;
	private int dayIndex;
	
	public int getMinCount() {
		return minCount;
	}
	public void setMinCount(int minCount) {
		if(this.minCount < Constant.MIN_SAVE)this.minCount = minCount;//如果=于10了,就不需要再加了
	}
	public int getMinIndex() {
		return minIndex;
	}
	public void setMinIndex(int minIndex) {
		this.minIndex = minIndex;
	}
	public int getHourCount() {
		return hourCount;
	}
	public void setHourCount(int hourCount) {
		if(this.hourCount < Constant.HOUR_SAVE)this.hourCount = hourCount;
	}
	public int getHourIndex() {
		return hourIndex;
	}
	public void setHourIndex(int hourIndex) {
		this.hourIndex = hourIndex;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		if(this.dayCount < Constant.DAY_SAVE)this.dayCount = dayCount;
	}
	public int getDayIndex() {
		return dayIndex;
	}
	public void setDayIndex(int dayIndex) {
		this.dayIndex = dayIndex;
	}
	public int getHostId() {
		return hostId;
	}
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	
	public int getKpiId() {
		return kpiId;
	}
	public void setKpiId(int kpiId) {
		this.kpiId = kpiId;
	}
	public byte[][] getMins() {
		return mins;
	}
	public void setMins(byte[][] mins) {
		this.mins = mins;
	}
	public byte[][] getHours() {
		return hours;
	}
	public void setHours(byte[][] hours) {
		this.hours = hours;
	}
	public byte[][] getDays() {
		return days;
	}
	public void setDays(byte[][] days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "DataOfTime [kpiId=" + kpiId + ", hostId=" + hostId + ", mins=" + toString(mins) + ", hours="
				+ toString(hours) + ", days=" + toString(days) + "]";
	}
	private String toString(byte[][] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuilder b = new StringBuilder();
		b.append('[');
		for (int i = 0; ; i++) {
			b.append(Arrays.toString(a[i]));
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}
}
