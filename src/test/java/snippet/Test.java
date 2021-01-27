package snippet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;



public class Test {
	public static final double time_space = 2.5;
	public static void main(String[] args) throws IOException {
		Reader r = new InputStreamReader(new FileInputStream("E:\\pcap\\xiaoshengchu.txt"),"UTF-8");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\pcap\\data.ico"));
		BufferedReader reader = new BufferedReader(r);
		String readLine = null;
		boolean isData = false;
		boolean isHTTP = false;
		HTTPInfo hi = null;
		while((readLine = reader.readLine())!=null) {
			if(readLine.startsWith("No")) {
				isData = true;
				continue;
			}else if(isData) {
				String [] arr = readLine.split("\\s+");
				String prol = arr[7];
				if("HTTP".equals(prol)) {
					String dip = arr[5];
					int dport = Integer.parseInt(arr[6]);
					if("58.129.247.143".equals(dip)&&80 == dport) {//并且目的ip+port是属于教委服务器的.这里xian简单判断
						hi = new HTTPInfo();
						hi.setDip(arr[5]);
						hi.setDport(Integer.parseInt(arr[6]));
						hi.setSip(arr[3]);
						hi.setTimestamp(Double.parseDouble(arr[2]));
	//					arr[2];//time
	//					arr[3];//time sip
	//					arr[4];//time sport
	//					arr[5];//time dip
	//					arr[6];//time dport
	//					arr[7];//time HTTP or TCP(协议)
						isHTTP = true;
					}
				}
				isData = false;
			}else if(isHTTP) {
				if(readLine.endsWith("Protocol")) {
					/*
					 GET /images/guanbi.png HTTP/1.1\r\n
				    Host: hdxscgl.yjrx.bjedu.cn\r\n
				    Connection: keep-alive\r\n
				    User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36\r\n
				 */
					readLine = reader.readLine();
					String [] arr = readLine.trim().split("\\s+");
					hi.setRequstType(arr[0]);
					hi.setRequstPath(arr[1]);
					readLine = reader.readLine();
					arr = readLine.trim().split("\\s+");
					String all = arr[1].substring(0, arr[1].length()-4);
					hi.setHost(all);
					readLine = reader.readLine();
					all = arr[1].substring(0, arr[1].length()-4);
					hi.setConnection(all);
					do{
						readLine = reader.readLine();
						arr = readLine.trim().split(":");
					}while(!"User-Agent".equals(arr[0]));
					hi.setUserAgent(arr[1].trim().substring(0, arr[1].length()-5));
					isHTTP = false;
					System.out.println(hi);
				}
			}else {
				continue;
			}
		}
		reader.close();
	}
}
class HTTPInfo{
	private double timestamp;
	private String sip;
	private String dip;
	private int dport;
	//Hypertext Transfer Protocol
	private String requstType;//GET
	private String requstPath;//  /images/guanbi.png
	private String host;//hdxscgl.yjrx.bjedu.cn
	private String connection;//keep-alive
	private String userAgent;//Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36
	public double getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(double timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getRequstPath() {
		return requstPath;
	}
	public void setRequstPath(String requstPath) {
		this.requstPath = requstPath;
	}
	public String getSip() {
		return sip;
	}
	public void setSip(String sip) {
		this.sip = sip;
	}
	public String getDip() {
		return dip;
	}
	public void setDip(String dip) {
		this.dip = dip;
	}
	public int getDport() {
		return dport;
	}
	public void setDport(int dport) {
		this.dport = dport;
	}
	public String getRequstType() {
		return requstType;
	}
	public void setRequstType(String requstType) {
		this.requstType = requstType;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	@Override
	public String toString() {
		return "HTTPInfo [timestamp=" + timestamp + ", sip=" + sip + ", dip=" + dip + ", dport=" + dport
				+ ", requstType=" + requstType + ", requstPath=" + requstPath + ", host=" + host + ", connection="
				+ connection + ", userAgent=" + userAgent + "]";
	}
	
}
class HttpUrlAndChild{
	private String appName;//那个应用下的
	private String urlPath;
	private String dip;
	private int dport;
	private List<String> childPaths;//不包括自己
	public String getUrlPath() {
		return urlPath;
	}
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getDip() {
		return dip;
	}
	public void setDip(String dip) {
		this.dip = dip;
	}
	public int getDport() {
		return dport;
	}
	public void setDport(int dport) {
		this.dport = dport;
	}
	public List<String> getChildPaths() {
		return childPaths;
	}
	public void setChildPaths(List<String> childPaths) {
		this.childPaths = childPaths;
	}
	@Override
	public String toString() {
		return "HttpUrlAndChild [appName=" + appName + ", urlPath=" + urlPath + ", dip=" + dip + ", dport=" + dport
				+ ", childPaths=" + childPaths + "]";
	}
	
}