package com.myqq.entity.numbergame;

import com.myqq.entity.PageNumber;

public class PersonHistroy {
	private MoBan moban;
	private long winMoney;//本次该用户赢的钱数
	private long pourMoney;//本次该用户投入的钱数
	private int fastNO;//第几期
	private int userId;//用户编号
	private boolean status;//状态 默认false 未开奖
	private PageNumber pn;
	public MoBan getMoban() {
		return moban;
	}
	public void setMoban(MoBan moban) {
		this.moban = moban;
	}
	public long getWinMoney() {
		return winMoney;
	}
	public void setWinMoney(long winMoney) {
		this.winMoney = winMoney;
	}
	public long getPourMoney() {
		return pourMoney;
	}
	public void setPourMoney(long pourMoney) {
		this.pourMoney = pourMoney;
	}
	public int getFastNO() {
		return fastNO;
	}
	public void setFastNO(int fastNO) {
		this.fastNO = fastNO;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public PageNumber getPn() {
		return pn;
	}
	public void setPn(PageNumber pn) {
		this.pn = pn;
	}
	@Override
	public String toString() {
		return "PersonHistroy [moban=" + moban + ", winMoney=" + winMoney + ", pourMoney=" + pourMoney + ", fastNO="
				+ fastNO + ", userId=" + userId + ", status=" + status + ", pn=" + pn + "]";
	}
	public void addMobanMoney(MoBan moban2) {
		this.moban.addMobanMoney(moban2);
	}
}
