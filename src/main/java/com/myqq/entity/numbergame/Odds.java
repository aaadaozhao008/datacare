package com.myqq.entity.numbergame;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.myqq.entity.PageNumber;
import com.myqq.service.JiSuSanXing;

public class Odds{
	private static double number_0 = 1017.79 ;
	private static double number_1 = 338.87  ;
	private static double number_2 = 168.82  ;
	private static double number_3 = 101.36  ;
	private static double number_4 = 67.43   ;
	private static double number_5 = 48.13   ;
	private static double number_6 = 35.99   ;
	private static double number_7 = 28.1    ;
	private static double number_8 = 22.17   ;
	private static double number_9 = 18.32   ;
	private static double number_10 = 15.78   ;
	private static double number_11 = 14.43   ;
	private static double number_12 = 13.64   ;
	private static double number_13 = 13.31   ;
	private static double number_14 = 13.28   ;
	private static double number_15 = 13.59   ;
	private static double number_16 = 14.61   ;
	private static double number_17 = 15.77   ;
	private static double number_18 = 18.09   ;
	private static double number_19 = 22.36   ;
	private static double number_20 = 27.15   ;
	private static double number_21 = 36.03   ;
	private static double number_22 = 48.14   ;
	private static double number_23 = 67.28   ;
	private static double number_24 = 101.25  ;
	private static double number_25 = 168.76  ;
	private static double number_26 = 337.64  ;
	private static double number_27 = 1014.77 ;
	private static int fastNO;//第几期
	static Map<Integer,Double> map = new HashMap<>();
	static{
		Field[] fields = Odds.class.getDeclaredFields();
		for (int i = 0; i < 28; i++) {
			Odds odds = new Odds();
			Double object = 0d;
			try {
				object = (Double)fields[i].get(odds);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			map.put(i,object);
		}
	}
	
	public static int getFastNO() {
		return fastNO;
	}
	public static void setFastNO(int fastNO) {
		Odds.fastNO = fastNO;
	}
	public static double getNumber_0() {
		return number_0;
	}
	public static void setNumber_0(double number_0) {
		Odds.number_0 = number_0;
	}
	public static double getNumber_1() {
		return number_1;
	}
	public static void setNumber_1(double number_1) {
		Odds.number_1 = number_1;
	}
	public static double getNumber_2() {
		return number_2;
	}
	public static void setNumber_2(double number_2) {
		Odds.number_2 = number_2;
	}
	public static double getNumber_3() {
		return number_3;
	}
	public static void setNumber_3(double number_3) {
		Odds.number_3 = number_3;
	}
	public static double getNumber_4() {
		return number_4;
	}
	public static void setNumber_4(double number_4) {
		Odds.number_4 = number_4;
	}
	public static double getNumber_5() {
		return number_5;
	}
	public static void setNumber_5(double number_5) {
		Odds.number_5 = number_5;
	}
	public static double getNumber_6() {
		return number_6;
	}
	public static void setNumber_6(double number_6) {
		Odds.number_6 = number_6;
	}
	public static double getNumber_7() {
		return number_7;
	}
	public static void setNumber_7(double number_7) {
		Odds.number_7 = number_7;
	}
	public static double getNumber_8() {
		return number_8;
	}
	public static void setNumber_8(double number_8) {
		Odds.number_8 = number_8;
	}
	public static double getNumber_9() {
		return number_9;
	}
	public static void setNumber_9(double number_9) {
		Odds.number_9 = number_9;
	}
	public static double getNumber_10() {
		return number_10;
	}
	public static void setNumber_10(double number_10) {
		Odds.number_10 = number_10;
	}
	public static double getNumber_11() {
		return number_11;
	}
	public static void setNumber_11(double number_11) {
		Odds.number_11 = number_11;
	}
	public static double getNumber_12() {
		return number_12;
	}
	public static void setNumber_12(double number_12) {
		Odds.number_12 = number_12;
	}
	public static double getNumber_13() {
		return number_13;
	}
	public static void setNumber_13(double number_13) {
		Odds.number_13 = number_13;
	}
	public static double getNumber_14() {
		return number_14;
	}
	public static void setNumber_14(double number_14) {
		Odds.number_14 = number_14;
	}
	public static double getNumber_15() {
		return number_15;
	}
	public static void setNumber_15(double number_15) {
		Odds.number_15 = number_15;
	}
	public static double getNumber_16() {
		return number_16;
	}
	public static void setNumber_16(double number_16) {
		Odds.number_16 = number_16;
	}
	public static double getNumber_17() {
		return number_17;
	}
	public static void setNumber_17(double number_17) {
		Odds.number_17 = number_17;
	}
	public static double getNumber_18() {
		return number_18;
	}
	public static void setNumber_18(double number_18) {
		Odds.number_18 = number_18;
	}
	public static double getNumber_19() {
		return number_19;
	}
	public static void setNumber_19(double number_19) {
		Odds.number_19 = number_19;
	}
	public static double getNumber_20() {
		return number_20;
	}
	public static void setNumber_20(double number_20) {
		Odds.number_20 = number_20;
	}
	public static double getNumber_21() {
		return number_21;
	}
	public static void setNumber_21(double number_21) {
		Odds.number_21 = number_21;
	}
	public static double getNumber_22() {
		return number_22;
	}
	public static void setNumber_22(double number_22) {
		Odds.number_22 = number_22;
	}
	public static double getNumber_23() {
		return number_23;
	}
	public static void setNumber_23(double number_23) {
		Odds.number_23 = number_23;
	}
	public static double getNumber_24() {
		return number_24;
	}
	public static void setNumber_24(double number_24) {
		Odds.number_24 = number_24;
	}
	public static double getNumber_25() {
		return number_25;
	}
	public static void setNumber_25(double number_25) {
		Odds.number_25 = number_25;
	}
	public static double getNumber_26() {
		return number_26;
	}
	public static void setNumber_26(double number_26) {
		Odds.number_26 = number_26;
	}
	public static double getNumber_27() {
		return number_27;
	}
	public static void setNumber_27(double number_27) {
		Odds.number_27 = number_27;
	}
	public static Map<Integer, Double> getMap() {
		return map;
	}
	public static void setMap(Map<Integer, Double> map) {
		Odds.map = map;
	}
	/**
	 * @param pen
	 * @param number 开机号码
	 * @return  获利多少
	 */
	public static long getWin(PersonHistroy ph,PageNumber number) {
		long sum = 0;
		Double double1 = map.get(number.getAll());
		Field[] fileds = MoBan.class.getDeclaredFields();
		MoBan moban = ph.getMoban();
		try {
			fileds[number.getAll()].setAccessible(true);
			Integer object = (Integer)fileds[number.getAll()].get(moban);
			sum = (long)(double1 * object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		Person pen = JiSuSanXing.getDugous().get(ph.getUserId());
		pen.setMoney(sum+pen.getMoney());
		pen.setUserTodayMoney(pen.getUserTodayMoney()+sum);
		ph.setWinMoney(sum);
		ph.setStatus(Boolean.TRUE);
		ph.setPn(number);
		return sum;
	}
	/**
	 * 下注
	 * @param pen
	 * @return false 下注不成功, true 下注成功
	 */
	public static boolean pour(PersonHistroy ph) {
		Field[] fileds = MoBan.class.getDeclaredFields();
		MoBan moban = ph.getMoban();
		long sum = 0;
		try {
			int length = 28;
			for (int i = 0; i < length; i++) {
				fileds[i].setAccessible(true);
				Integer object = (Integer)fileds[i].get(moban);
				sum += object;
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		Person pen = JiSuSanXing.getDugous().get(ph.getUserId());
		PersonHistroy histroy = pen.getMap().get(String.valueOf(ph.getFastNO()));
		long b = pen.getMoney() - sum;
		if(b < 0) return false;
		if(histroy == null) {
			pen.getMap().put(String.valueOf(ph.getFastNO()), ph);
			ph.setPourMoney(sum); //个人本次的
		}else {
			histroy.setPourMoney(histroy.getPourMoney()+sum); //个人本次的  需要将本次的模板 和上次的模板数据组合一起
			histroy.addMobanMoney(moban);
		}
		pen.setMoney(b);//个人总的
		JiSuSanXing.setMoney(sum,ph.getFastNO());//奖池的
		pen.setUserTodayMoney(pen.getUserTodayMoney()-sum);
		return true;
	}
}
