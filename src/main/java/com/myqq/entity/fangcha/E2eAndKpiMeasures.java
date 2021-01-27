package com.myqq.entity.fangcha;

import com.myqq.entity.enums.TimeUnitEnum;

public class E2eAndKpiMeasures {
	/**
	 * 哪个月
	 */	
	private Integer timeMonth;
	/**
	 * 哪周
	 */
	private Integer timeWeek;
	/**
	 * 哪个小时
	 */
	private Integer timeHour;

	/**
	 * 时间单位
	 *

	 */
	private Enum<TimeUnitEnum> timeUnit;

	private String timeUnitTransfer;
	private Integer kpiId;

	private Integer e2eId;
	/**
	 * 数组元素个数
	 *

	 */
	private Integer sumCount;

	/**
	 * 数组中各元素之和
	 *

	 */
	private Double sumValue;

	/**
	 * 数组方差
	 *

	 */
	private Double variance;

	/**
	 * 数组标准差
	 *

	 */
	private Double standardDeviation;

	/**
	 * 数组的平均值
	 *

	 */
	private Double avg;

	/**
	 * 数组的变异系数
	 *

	 */
	private Double cv;
	/**
	 * 正常范围
	 */
	private double[] normalValueScope = new double[2];//0:是low,1:是high;
	/**
	 * 较好范围
	 */
	private double[] betterValueScope = new double[2];//0:是low,1:是high;
	/**
	 * 较差范围
	 */
	private double[] worseValueScope = new double[2];//0:是low,1:是high;
	/**
	 * 低于此值都为差
	 */
	private double badValueScope ;//high
	/**
	 * 高于此值都是优秀
	 */
	private double bestValueScope ;//low
	public E2eAndKpiMeasures() {};
	//有参构造器
	public E2eAndKpiMeasures(Integer sumCount, Double sumValue, Double variance) {
		this.sumCount = sumCount;
		this.sumValue = sumValue;
		this.variance = variance;
		this.standardDeviation = Math.sqrt(variance);
		this.avg = sumCount == 0 ?0d:sumValue/sumCount;
		this.cv = this.avg == 0?0d:this.standardDeviation/this.avg;
	}
	private void updateE2eAndKpiMeasures(Integer sumCount, Double sumValue, Double variance) {
		this.sumCount = sumCount;
		this.sumValue = sumValue;
		this.variance = variance;
		this.standardDeviation = Math.sqrt(variance);
		this.avg = sumCount == 0 ?0d:sumValue/sumCount;
		this.cv = this.avg == 0?0d:this.standardDeviation/this.avg;
		long best = Math.round(this.avg + 2*this.standardDeviation);
		long good = Math.round(this.avg + this.standardDeviation);
		long worse = Math.round(this.avg - this.standardDeviation);
		long bad = Math.round(this.avg - 2*this.standardDeviation);
		this.bestValueScope = best;
		this.betterValueScope[1] = best;
		this.betterValueScope[0] = good;
		this.normalValueScope[1] = good;
		this.normalValueScope[0] = worse;
		this.worseValueScope[1] = worse;
		this.worseValueScope[0] = bad;
		this.badValueScope = bad;
	}
	/**
	 * 数组增量方法,传参当前数据,更新历史数据
	 * @param delta
	 * @return false:失败;true:成功
	 */
	public boolean updateValue(E2eAndKpiMeasures delta){
		Integer newN = this.sumCount + delta.getSumCount();//数组长度之和
		Double newSum = this.sumValue + delta.getSumValue();//数组元素总和
		Double newAvg = newSum / newN;
		//将    [(组合的avg-老的avg然后2的平方再+老的方差)*老的样本个数 + (组合的avg-新的avg然后2的平方再+新的方差)*新的样本个数]/组合的样本个数
		try {
			Double variance = (this.partial(newAvg,this.avg,this.variance,this.sumCount) + this.partial(newAvg,delta.getAvg(),delta.getVariance(),delta.getSumCount()))/newN;//方差增量算法公式
			updateE2eAndKpiMeasures(newN,newSum,variance);//更新自己;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	// 封装表达式 n*(variance + (newAvg - avg)*(newAvg - avg))
	private Double partial(Double newAvg ,Double avg ,Double variance,Integer n){
		Double deltaAvg =newAvg - avg;
		return n * ( variance + deltaAvg * deltaAvg );
	}
	/**
	 * 正常范围
	 */
	public double[] getNormalValueScope() {
		return normalValueScope;
	}
	/**
	 * 较好范围
	 */
	public double[] getBetterValueScope() {
		return betterValueScope;
	}
	/**
	 * 较差范围
	 */
	public double[] getWorseValueScope() {
		return worseValueScope;
	}
	/**
	 * 低于此值都为差
	 */
	public double getBadValueScope() {
		return badValueScope;
	}
	/**
	 * 高于此值都是优秀
	 */
	public double getBestValueScope() {
		return bestValueScope;
	}
	/**
	 * 水平评估随机变量
	 * @param value
	 * @return
	 */
	public String getShowByValue(double value) {
		if(value > bestValueScope) return "非常好";
		else if(value > betterValueScope[0]) return "较好";
		else if(value > normalValueScope[0]) return "一般";
		else if(value > worseValueScope[0]) return "较差";
		return "非常差";
	}
	public Integer getTimeMonth() {
		return timeMonth;
	}
	public void setTimeMonth(Integer timeMonth) {
		this.timeMonth = timeMonth;
	}
	public Integer getTimeWeek() {
		return timeWeek;
	}
	public void setTimeWeek(Integer timeWeek) {
		this.timeWeek = timeWeek;
	}
	public Integer getTimeHour() {
		return timeHour;
	}
	public void setTimeHour(Integer timeHour) {
		this.timeHour = timeHour;
	}
	public String getTimeUnitTransfer() {
		return timeUnitTransfer;
	}
	public void setTimeUnitTransfer(String timeUnitTransfer) {
		this.timeUnitTransfer = timeUnitTransfer;
		this.timeUnit = TimeUnitEnum.valueOf(timeUnitTransfer);
	}
	/**
	 *
	 * 时间单位
	 * @return  
	 *

	 */
	public Enum<TimeUnitEnum> getTimeUnit() {
		return timeUnit;
	}

	/**
	 *
	 * 时间单位
	 * @param 
	 *

	 */
	public void setTimeUnit(Enum<TimeUnitEnum> timeUnit) {
		this.timeUnit = timeUnit;
	}

	/**
	 *
	 *

	 */
	public Integer getKpiId() {
		return kpiId;
	}

	/**
	 *
	 *

	 */
	public void setKpiId(Integer kpiId) {
		this.kpiId = kpiId;
	}

	/**
	 *
	 *

	 */
	public Integer getE2eId() {
		return e2eId;
	}

	/**
	 *
	 *

	 */
	public void setE2eId(Integer e2eId) {
		this.e2eId = e2eId;
	}

	/**
	 *
	 * 数组元素个数
	 * @return  
	 *

	 */
	public Integer getSumCount() {
		return sumCount;
	}

	/**
	 *
	 * 数组元素个数
	 * @param 
	 *

	 */
	public void setSumCount(Integer sumCount) {
		this.sumCount = sumCount;
	}

	/**
	 *
	 * 数组中各元素之和
	 * @return  
	 *

	 */
	public Double getSumValue() {
		return sumValue;
	}

	/**
	 *
	 * 数组中各元素之和
	 * @param 
	 *

	 */
	public void setSumValue(Double sumValue) {
		this.sumValue = sumValue;
	}

	/**
	 *
	 * 数组方差
	 * @return  
	 *

	 */
	public Double getVariance() {
		return variance;
	}

	/**
	 *
	 * 数组方差
	 * @param 
	 *

	 */
	public void setVariance(Double variance) {
		this.variance = variance;
	}

	/**
	 *
	 * 数组标准差
	 * @return  
	 *

	 */
	public Double getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 *
	 * 数组标准差
	 * @param 
	 *

	 */
	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	/**
	 *
	 * 数组的平均值
	 * @return  
	 *

	 */
	public Double getAvg() {
		return avg;
	}

	/**
	 *
	 * 数组的平均值
	 * @param 
	 *

	 */
	public void setAvg(Double avg) {
		this.avg = avg;
	}

	/**
	 *
	 * 数组的变异系数
	 * @return  
	 *

	 */
	public Double getCv() {
		return cv;
	}

	/**
	 *
	 * 数组的变异系数
	 * @param 
	 *

	 */
	public void setCv(Double cv) {
		this.cv = cv;
	}
}