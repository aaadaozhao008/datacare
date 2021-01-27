package fangcha;

public class FangCha {
	public static void main(String[] args) {
		Double[] d1 = {1.0,2.0,11.0,3.0,12.9,8.3,3.6,12.0,13.0};//三年二班成绩
		Double[] d2 = {3.0,12.9,8.3,3.6};
		//第一种：合并数组计算方差，不按增量算法
		Double[] d3 = hebing(d1,d2);
		Measures m1 = createMs(d3);
		System.out.println("标准差传统计算结果："+m1.getStandardDeviation());
		//第二种：方差增量算法
		Measures m2 = createMs(d1);
		Measures m3 = createMs(d2);
		Measures m4 = m2.appendDelta(m3);
		System.out.println("标准差增量算法结果："+m4.getStandardDeviation());
//		Double[] d3 = {1.0,3.2,5.9,9.3,14.6,30.0};//三年一班 个别学员成绩
//		for (Double double1 : d3) {
//			System.out.println(double1+" 在 三年二班中成绩表现 ："+m2.isGood(double1));
//		}
//		
	}

	/**
	 * 单个数组方差的计算
	 * @return
	 */
	public static Measures createMs(Double[] values){
		Measures ms = null;
		if (values != null && values.length > 0){
			Integer n = values.length;
			//求和
			Double sum =0.00;
			//avg
			Double avg = 0.00;
			//方差计算
			Double variance = 0.00;
			Double sumSq = 0.00;
			for (int i = 0;i<values.length;i++){
				sum +=values[i];
			}
			avg = sum/n;
			for (int i = 0;i<values.length;i++){
				sumSq += Math.pow((values[i] - avg),2);
			}
			variance = sumSq / n;
			ms = new Measures(n,sum,variance);
		}else{
			ms = new Measures(0,0.00,0.00);
		}

		return ms;
	}


	public static  Double[] hebing(Double[] d1,Double[] d2){
		if(d1 == null){
			d1 = new Double[0];
		}
		if(d2 == null){
			d2 = new Double[0];
		}
		Double[] d3 = new Double[d1.length+d2.length];
		for (int i =0;i <d1.length; i++){
			d3[i] = d1[i];
		}
		for(int i =0;i <d2.length; i++){
			d3[i+d1.length] = d2[i];
		}
		return d3;

	}
}
class Measures {
	private Integer n;//数组元素个数
	private Double sum;//数组中各元素之和
	private Double variance;//数组方差
	private Double standardDeviation;//数组标准差
	private Double avg;//数组的平均值
	private final static String BEST = "非常好";
	private final static String GOOD = "较好";
	private final static String NORMAL = "一般";
	private final static String BAD = "较差";
	private final static String VERY_BAD = "非常差";
	//有参构造器
	public Measures(Integer n, Double sum, Double variance) {
		this.n = n;
		this.sum = sum;
		this.variance = variance;
		this.standardDeviation = Math.sqrt(variance);
		this.avg =sum/n;
	}
	//数组增量方法
	public Measures appendDelta(Measures delta){
		Integer newN = this.n + delta.getN();//数组长度之和
		Double newSum = this.sum + delta.getSum();//数组元素总和
		Double newAvg = newSum / newN;
		//将    [(组合的avg-老的avg然后2的平方再+老的方差)*老的样本个数 + (组合的avg-新的avg然后2的平方再+新的方差)*新的样本个数]/组合的样本个数
		Double variance = (this.partial(newAvg,this.avg,this.variance,this.n) + this.partial(newAvg,delta.getAvg(),delta.getVariance(),delta.getN()))/newN;//方差增量算法公式
		return new Measures(newN,newSum,variance);
	}
	// 封装表达式 n*(variance + (newAvg - avg)*(newAvg - avg))
	public Double partial(Double newAvg ,Double avg ,Double variance,Integer n){
		Double deltaAvg =newAvg - avg;
		return n * ( variance + deltaAvg * deltaAvg );
	}
	//判断一个随机变量的好坏
	public String isGood(Double value ){
		Double best = avg + 2*standardDeviation;
		if(value > best ) return BEST;
		Double good = avg + standardDeviation;
		if(value > good ) return GOOD;
		Double bad = avg - standardDeviation;
		if(value > bad ) return NORMAL;
		Double veryBad = avg - 2*standardDeviation;
		if(value > veryBad ) return BAD;
		return VERY_BAD;
	}

	public Double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(Double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	public Integer getN() {
		return n;
	}
	public void setN(Integer n) {
		this.n = n;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Double getVariance() {
		return variance;
	}
	public void setVariance(Double variance) {
		this.variance = variance;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
}