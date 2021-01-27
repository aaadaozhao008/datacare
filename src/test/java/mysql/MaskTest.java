package mysql;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myqq.dao.mappers.page.PageChildMapper;
import com.myqq.dao.mappers.page.PageMainMapper;
import com.myqq.entity.enums.TimeUnitEnum;
import com.myqq.entity.fangcha.E2eAndKpiMeasures;
import com.myqq.entity.page.PageMain;
import com.myqq.service.MeasuresService;
import com.myqq.util.MeasuresUtil;

import pachong.Spider;

@ContextConfiguration( "classpath:spring-context_dao.xml" )
@RunWith( SpringJUnit4ClassRunner.class)
public class MaskTest {
	@Autowired	
	private MeasuresService ms;
	@Autowired	
	private PageChildMapper child;
	@Autowired	
	private PageMainMapper main;
	@Test
	public void testPageInsert() throws FileNotFoundException {
		PageMain p2 = new PageMain();
		p2.setPageUrl("1234");
		int insert = main.insertId(p2);
		System.out.println(insert);
	}
	@Test
	public void testPage() throws FileNotFoundException, MalformedURLException, UnknownHostException {
		Spider.main = main;
		Spider.child = child;
		List<String> list = new ArrayList<>();
		List<String> listName = new ArrayList<>();
		List<String> listUrl = new ArrayList<>();
		String path = "https://www.baidu.com";
		String url = "www.baidu.com";
		String pageName = "百度";
		list.add(path);
		listName.add(pageName);
		listUrl.add(url);
		
		path = "https://www.yada.com.cn";
		url = "www.yada.com.cn";
		pageName = "雅达";
		list.add(path);
		listName.add(pageName);
		listUrl.add(url);
		
		path = "http://jw.beijing.gov.cn";
		url = "jw.beijing.gov.cn";
		pageName = "北京市教委";
		list.add(path);
		listName.add(pageName);
		listUrl.add(url);
		
		for (int i = 0; i < list.size(); i++) {
			path = list.get(i);
			pageName = listName.get(i);
			url = listUrl.get(i);
			InetAddress iAddress=InetAddress.getByName(url); 
			System.out.println(iAddress.getHostAddress());
//			URL create = new URL("http://jw.beijing.gov.cn");
			
			Spider sp = new Spider(path, pageName,getLongIPByString(iAddress.getHostAddress()),80);
			sp.catchAllpage(path);
		}
		
	}
	public static long getLongIPByString(String ip){
		String[] split = ip.split("[.]");
		if(split.length != 4)return -1;
		return Long.parseLong(split[0])<<24|Long.parseLong(split[1])<<16
				|Long.parseLong(split[2])<<8|Long.parseLong(split[3]);
	}
	Random r = new Random();
	private double randomDouble() {
		double nextDouble = r.nextDouble()*1000;
		BigDecimal  b  =  new  BigDecimal(nextDouble);  
		return b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
	}
	@Test
	public void testFangCha() {
		//1.加载数据
		ms.resetData();
		Map<Long, E2eAndKpiMeasures> map = MeasuresService.getMap();
		//2.定时更新数据库,测试环境为了看效果定为1分钟1次
//		TIMERFATHER.scheduleAtFixedRate(new TimerTask() {
//			@Override
//			public void run() {
//				ms.writeData();
//			}
//		},1, 1, TimeUnit.MINUTES);
		int year = 1;
		//3.循环1次等于1年.10年停止
		while (true) {
			//4.模拟发送5(e2e)*5(kpi)*12(月)*7(天)*24(小时) 的数据 
			for (int e2eId = 1; e2eId <= 5; e2eId++) {//5个e2e
				for (int kpiId = 1; kpiId <= 5; kpiId++) {//5个kpi
					for (int month = 1; month <= 12; month++) {//1-12月
						for (int week = 1; week <= 7; week++) {//1-7周
							for (int hour = 1; hour <= 24; hour++) {//1-24小时
								long key = MeasuresUtil.getKey(month, week, hour, e2eId, kpiId);
								E2eAndKpiMeasures kpiMeasures = map.get(key);
								if (kpiMeasures == null) {
									kpiMeasures = new E2eAndKpiMeasures(0, 0d, 0d);
									kpiMeasures.setE2eId(e2eId);
									kpiMeasures.setKpiId(kpiId);
									kpiMeasures.setTimeHour(hour);
									kpiMeasures.setTimeWeek(week);
									kpiMeasures.setTimeMonth(month);
									kpiMeasures.setTimeUnit(TimeUnitEnum.SEC);//
									map.put(key, kpiMeasures);
								}
								//5.更新内存数据
								E2eAndKpiMeasures newData = new E2eAndKpiMeasures(10, randomDouble(), randomDouble());//模拟当前数据
								kpiMeasures.updateValue(newData);
								//6.每年访问1次某个数据的一些指标;
								if(e2eId ==1&&kpiId==1 &&month==12&&week==7&&hour==12) {
									System.out.println("---------------第"+year+"年的12月,星期日,中午12点----------------");
									double badValueScope = kpiMeasures.getBadValueScope();
									System.out.println("非常差的范围是小于 "+badValueScope);
									double bestValueScope = kpiMeasures.getBestValueScope();
									System.out.println("非常好的范围是大于 "+bestValueScope);
									double[] betterValueScope = kpiMeasures.getBetterValueScope();
									System.out.println("较好的范围是大于 "+betterValueScope[0]+",小于 "+betterValueScope[1]);
									double[] normalValueScope = kpiMeasures.getNormalValueScope();
									System.out.println("一般的范围是大于 "+normalValueScope[0]+",小于 "+normalValueScope[1]);
									double[] worseValueScope = kpiMeasures.getWorseValueScope();
									System.out.println("较差的范围是大于 "+worseValueScope[0]+",小于 "+worseValueScope[1]);
									String showByValue = kpiMeasures.getShowByValue(randomDouble()/10);
									System.out.println("本次数据在历史表现中体现为:"+showByValue);
									System.out.println("...................end....................");
								}
							}
						}
					}
				}
			} 
			year++;
			//2:代码运行太快,定时更新没来得及启动就结束,测试这里结束直接更新数据库
			if(year == 11) {
				ms.writeData();
				break;
			}
		}
	}
}