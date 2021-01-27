package com.myqq.entity.numbergame;

import java.util.HashMap;
import java.util.Map;

public class Person{
	private Map<String,PersonHistroy> map = new HashMap<>();
	private long money = 1000000L;//该用户总钱数
	private long userTodayMoney;//该用户今日盈亏
	private int userId;//用户编号
	private String userName;//用户编号
	public Map<String, PersonHistroy> getMap() {
		return map;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public long getUserTodayMoney() {
		return userTodayMoney;
	}
	public void setUserTodayMoney(long userTodayMoney) {
		this.userTodayMoney = userTodayMoney;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Person [map=" + map + ", money=" + money + ", userTodayMoney=" + userTodayMoney + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}
}