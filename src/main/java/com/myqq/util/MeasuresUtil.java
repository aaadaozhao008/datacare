package com.myqq.util;
/**
 * 
 * @author 赵芝玉
 */
public class MeasuresUtil{
	/**
	 * 
	 * 前32位是e2eId;
	 * 33-52:是kpiId 20 bit
	 * 53-56:是0-12个月; 4bit
	 * 57-59:是0-7个周;3 bit
	 * 60-64:是0-24个小时;5bit
	 * @param month
	 * @param week
	 * @param hour
	 * @param e2eId
	 * @param kpiId
	 * @return
	 */
	public static long getKey(long month,long week,long hour,long e2eId,long kpiId) {
		long l = e2eId<<32|kpiId<<12|month<<8|week<<5|hour;
		return l;
	}
	/**
	 * 
	 * @param key
	 * @return  月
	 */
	public static int getMonthByKey(long key) {
		return (int)((key>>8)&15);
	}
	/**
	 * 
	 * @param key
	 * @return 小时
	 */
	public static int getHourByKey(long key) {
		return (int)(key&31);
	}
	/**
	 * 
	 * @param key
	 * @return 星期几
	 */
	public static int getWeekByKey(long key) {
		return (int)((key>>5)&7);
	}
	/**
	 * 
	 * @param key
	 * @return e2eId
	 */
	public static int getE2eIdByKey(long key) {
		return (int)(key>>32);
	}
	/**
	 * 
	 * @param key
	 * @return kpiId
	 */
	public static int getKpiIdByKey(long key) {
		return (int)((key>>12)&1048575);//0b11111111111111111111(20bit)
	}
}
