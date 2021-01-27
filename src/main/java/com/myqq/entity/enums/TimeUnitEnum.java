package com.myqq.entity.enums;

public enum TimeUnitEnum {
	SEC("秒"),MIN("分钟"),HOUR("小时"),DAY("年");
	private String desc;
	private TimeUnitEnum(String  desc) {this.desc=desc;}
	public String getDesc() {
		return desc;
	}
}
