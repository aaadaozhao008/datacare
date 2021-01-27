package poi;

public class Data {
	private String pro ;
	private String bool ;
	private String flag ;
	private String pktSize ;
	private Integer payloadLength ;
	private int windowSize ;
	private String httpFirst ;
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getBool() {
		return bool;
	}
	public void setBool(String bool) {
		this.bool = bool;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getPktSize() {
		return pktSize;
	}
	public void setPktSize(String pktSize) {
		this.pktSize = pktSize;
	}
	public Integer getPayloadLength() {
		return payloadLength;
	}
	public void setPayloadLength(Integer payloadLength) {
		this.payloadLength = payloadLength;
	}
	public int getWindowSize() {
		return windowSize;
	}
	public void setWindowSize(int windowSize) {
		this.windowSize = windowSize;
	}
	public String getHttpFirst() {
		return httpFirst;
	}
	public void setHttpFirst(String httpFirst) {
		this.httpFirst = httpFirst;
	}
	@Override
	public String toString() {
		return "Data [pro=" + pro + ", bool=" + bool + ", flag=" + flag + ", pktSize=" + pktSize + ", payloadLength="
				+ payloadLength + ", windowSize=" + windowSize + ", httpFirst=" + httpFirst + "]";
	}
}
