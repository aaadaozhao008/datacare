package com.myqq.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PageNumber {
	private  int fastNO;//第几期
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "MM-dd HH:mm:ss")
	private  Date date = new Date();//时间
	private  int first;//第1个
	private  int second;//第2个
	private  int third;//第3个
	private  int all;//总的
	private  long allMoney;//本次投入的总钱数
	private boolean status;//状态 默认false 未开奖
	public int getFastNO() {
		return fastNO;
	}
	public void setFastNO(int fastNO) {
		this.fastNO = fastNO;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getThird() {
		return third;
	}
	public void setThird(int third) {
		this.third = third;
	}
	public int getAll() {
		return all;
	}
	public void setAll(int all) {
		this.all = all;
	}
	public long getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(long allMoney) {
		this.allMoney += allMoney;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PageNumber [fastNO=" + fastNO + ", date=" + date + ", first=" + first + ", second=" + second
				+ ", third=" + third + ", all=" + all + ", allMoney=" + allMoney + ", status=" + status + "]";
	}

}
