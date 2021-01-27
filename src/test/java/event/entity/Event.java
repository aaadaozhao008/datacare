package event.entity;

import java.util.Date;

public class Event {
	private int eventId;
	private String eventName;
	private int e2eId;
	private int kpiId;
	private Date startTime;
	private Date endTime;
	private Date lastStatusUpdateTime;
	private int status;//0:今日新增,1.历史未关闭.2:持续发生;3:事件已结束;
	public static String getStatus( int status) {
		switch(status){
			case 0:return "今日新增";
			case 1:return "历史未关闭";
			case 2:return "持续发生";
			default:return "事件已结束";
		}
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public int getE2eId() {
		return e2eId;
	}
	public void setE2eId(int e2eId) {
		this.e2eId = e2eId;
	}
	public int getKpiId() {
		return kpiId;
	}
	public void setKpiId(int kpiId) {
		this.kpiId = kpiId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getLastStatusUpdateTime() {
		return lastStatusUpdateTime;
	}
	public void setLastStatusUpdateTime(Date lastStatusUpdateTime) {
		this.lastStatusUpdateTime = lastStatusUpdateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", e2eId=" + e2eId + ", kpiId=" + kpiId
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", lastStatusUpdateTime=" + lastStatusUpdateTime
				+ ", status=" + status + "]";
	}
}
