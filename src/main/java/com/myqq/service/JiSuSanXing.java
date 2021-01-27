package com.myqq.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

import com.myqq.entity.PageNumber;
import com.myqq.entity.numbergame.MoBan;
import com.myqq.entity.numbergame.Odds;
import com.myqq.entity.numbergame.Person;
import com.myqq.entity.numbergame.PersonHistroy;

public class JiSuSanXing {
//	public static final int[] A = {0,1,2,3,4,5,6,7,8,9};
	private static final Random r = new Random();
	private static  int number = 1;
	private static  int time = 85;
	private static  final int CIRCLE = 85;
	private static final Map<Integer,Person> dugous = new HashMap<>();//用户们
	private static final Map<String,PageNumber> numbers = new TreeMap<>();//key是期号
	private static final ScheduledExecutorService TIMERFATHER = Executors.newScheduledThreadPool(3);
	static {
		TIMERFATHER.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {
					PageNumber openResult = openResult(number);
					Collection<Person> persons = dugous.values();
					for (Person person : persons) {
						Map<String, PersonHistroy> map = person.getMap();
						PersonHistroy history = map.get(String.valueOf(number));
						if(history == null)continue;
						else {
							Odds.getWin(history, openResult);
						}
					}
					time = CIRCLE;
					number++;
					if(number > 1200) numbers.remove(String.valueOf(number - 1200));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, CIRCLE, CIRCLE, TimeUnit.SECONDS);
		TIMERFATHER.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				time--;
			}
		}, 1, 1, TimeUnit.SECONDS);
	}
	public static Map<String, PageNumber> getNumbers() {
		return numbers;
	}
	/**
	 *  获得离开奖剩余的时间
	 * @return
	 */
	public static int getTime() {
		return time;
	}
	public static PageNumber openResult(int fastNO) {
		PageNumber number = numbers.get(String.valueOf(fastNO));
		if(number == null) {
			number = new PageNumber();
			numbers.put(String.valueOf(fastNO), number);
		}
		number.setFastNO(fastNO);
		number.setDate(new Date());
		number.setFirst(getNumber());
		number.setSecond(getNumber());
		number.setThird(getNumber());
		number.setStatus(Boolean.TRUE);
		number.setAll(number.getFirst()+number.getSecond()+number.getThird());
		return number;
	}
	public static synchronized void setMoney(long money,int fastNO) {
		PageNumber number = numbers.get(String.valueOf(fastNO));
		if(number != null) {
			number.setAllMoney(money);
		}else {
			number = new PageNumber();
			number.setFastNO(fastNO);
			number.setAllMoney(money);
			numbers.put(String.valueOf(fastNO), number);
		}
	}
	
	public static Map<Integer, Person> getDugous() {
		return dugous;
	}
	private static int getNumber() {
		return r.nextInt(10);
	}
	public static void main(String[] args) {
		Person pp = new Person();
		pp.setUserId(1);
		dugous.put(1, pp);
		
		MoBan pen = new MoBan();
		PersonHistroy ph = new PersonHistroy();
		ph.setFastNO(1);
		ph.setMoban(pen);
		ph.setUserId(pp.getUserId());
		

		
//		pen.setZero(100);
//		pen.setOne(10000);
//		pen.setTwo(11300);
//		pen.setThree(2000);
//		pen.setFour(1850);
//		pen.setFive(20000);
		pen.setSix(5534);
		pen.setSeven(5186);
		pen.setNight(10372);
		pen.setNine(12677);
		
		pen.setTen(15085);
		pen.setTenOne(15905);
		pen.setTenTwo(16827);
		pen.setTenThree(17288);
		pen.setTenFour(17288);
		pen.setTenFive(16827);
		pen.setTenSix(15905);
		pen.setTenSeven(9322);
		
		pen.setTenNight(12677);
		pen.setTenNine(10372);
		pen.setTwtenty(8297);
		pen.setTwtentyOne(5574);
		pen.setTwtentyTwo(3956);
//		pen.setTwtentyThree(1900);
//		pen.setTwtentyFour(2000);	
//		pen.setTwtentyFive(11300);
//		pen.setTwtentySix(10000);
//		pen.setTwtentySeven(100);
		int count = CIRCLE*24;
		Map<Integer,Integer> map = new HashMap<>();
		int n = 0;
		for (int i = 0; i < count; i++) {
			Odds.pour(ph);
			PageNumber number = new PageNumber();
			number.setFastNO(1);
			number.setDate(new Date());
			number.setFirst(getNumber());
			number.setSecond(getNumber());
			number.setThird(getNumber());
			number.setAll(number.getFirst()+number.getSecond()+number.getThird());
//			ph.setPn(pageNumber); 略了
			Odds.getWin(ph, number);
			n = number.getAll();
			Integer integer = map.get(n);
			if(integer !=null) {
				map.put(n, ++integer);
			}else {
				map.put(n, 1);
			}
		}
		if(map.get(0)==null)map.put(0, 0);
		if(map.get(1)==null)map.put(1, 0);
		if(map.get(27)==null)map.put(27, 0);
		if(map.get(26)==null)map.put(26, 0);
		map.forEach(new BiConsumer<Integer,Integer>(){
			@Override
			public void accept(Integer t, Integer u) {
				if(t == 10) {
					System.out.println("10-17 出现次数"+ (u+map.get(11)+map.get(12)+map.get(13)+map.get(14)+map.get(15)+map.get(16)+map.get(17)));
					return;
				}
				if (t > 10) return;
//				System.out.println(t+"=="+(27-t)+"出现次数:"+ (u+map.get(27-t)));
			}
		});
		System.out.println("赌狗 本次 获利 :"+(pp.getUserTodayMoney())/10000 + "w");
	}
}
