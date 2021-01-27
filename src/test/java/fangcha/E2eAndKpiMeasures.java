package fangcha;

import java.util.Date;

public class E2eAndKpiMeasures {
	private Date startTime;//统计开始时间
	private Enum<TimeUnitEnum> timeUnit;//时间单位
	private Integer kpiId; //指标id
	private Integer e2eId; //端到端id
	
	private Integer sumCount;//数组元素个数
	private Double sumValue;//数组中各元素之和
	private Double variance;//数组方差
	private Double standardDeviation;//数组标准差
	private Double avg;//数组的平均值
	private Double cv;//数组的变异系数;
	//有参构造器
	public E2eAndKpiMeasures(Integer sumCount, Double sumValue, Double variance) {
		this.sumCount = sumCount;
		this.sumValue = sumValue;
		this.variance = variance;
		this.standardDeviation = Math.sqrt(variance);
		this.avg =sumValue/sumCount;
		this.cv = this.standardDeviation/this.avg;
	}
	private void updateE2eAndKpiMeasures(Integer sumCount, Double sumValue, Double variance) {
		this.sumCount = sumCount;
		this.sumValue = sumValue;
		this.variance = variance;
		this.standardDeviation = Math.sqrt(variance);
		this.avg =sumValue/sumCount;
		this.cv = this.standardDeviation/this.avg;
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
	/**
	 * @return 获取数值定义范围
	 */
	public ValueEvaEnum[] getValueScopeList() {
		return ValueEvaEnum.values();
	}
	// 封装表达式 n*(variance + (newAvg - avg)*(newAvg - avg))
	private Double partial(Double newAvg ,Double avg ,Double variance,Integer n){
		Double deltaAvg =newAvg - avg;
		return n * ( variance + deltaAvg * deltaAvg );
	}
	/**
	 * 获取变异系数
	 * @return
	 */
	public Double getCv() {
		return cv;
	}
	/**
	 * 获取方差
	 * @return
	 */
	public Double getVariance() {
		return variance;
	}
	/**
	 * 获取平均值
	 * @return
	 */
	public Double getAvg() {
		return avg;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Enum<TimeUnitEnum> getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(Enum<TimeUnitEnum> timeUnit) {
		this.timeUnit = timeUnit;
	}
	public Integer getKpiId() {
		return kpiId;
	}
	public void setKpiId(Integer kpiId) {
		this.kpiId = kpiId;
	}
	public Integer getE2eId() {
		return e2eId;
	}
	public void setE2eId(Integer e2eId) {
		this.e2eId = e2eId;
	}
	public Integer getSumCount() {
		return sumCount;
	}
	public void setSumCount(Integer sumCount) {
		this.sumCount = sumCount;
	}
	public Double getSumValue() {
		return sumValue;
	}
	public void setSumValue(Double sumValue) {
		this.sumValue = sumValue;
	}
	public void setCv(Double cv) {
		this.cv = cv;
	}
	public Double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public void setVariance(Double variance) {
		this.variance = variance;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
}
