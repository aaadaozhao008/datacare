package fangcha;

public enum ValueEvaEnum {
	BEST("非常好",74,Integer.MAX_VALUE),
	BETTER("较好",57,74),
	NORMAL("一般",32,57),
	WORSE("较差",16,32),
	BAD("非常差",Integer.MIN_VALUE,16);
	private String desc;
	private int low;
	private int high;
	private ValueEvaEnum(String  desc, int low, int high){
		this.desc = desc;
		this.low = low;
		this.high = high;
	}
	public String getDesc() {
		return desc;
	}
	public ValueEvaEnum getShowByValue(int value) {
		if(value > BEST.low) return BEST;
		else if(value > BETTER.low) return BEST;
		else if(value > NORMAL.low) return BEST;
		else if(value > WORSE.low) return BEST;
		else return BAD;
	}
}
