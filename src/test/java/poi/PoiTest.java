package poi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;



public class PoiTest {
	public List<Object> importXLS(){

		ArrayList<Object> list = new ArrayList<>();
		try {
			//1、获取文件输入流
			InputStream inputStream = new FileInputStream("/Users/Shared/区域数据.xls");
			//2、获取Excel工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			//3、得到Excel工作表对象
			HSSFSheet sheetAt = workbook.getSheetAt(0);
			//4、循环读取表格数据
			for (Row row : sheetAt) {
				//首行（即表头）不读取
				if (row.getRowNum() == 0) {
					continue;
				}
				//读取当前行中单元格数据，索引从0开始
//				String areaNum = row.getCell(0).getStringCellValue(); 
//				String province = row.getCell(1).getStringCellValue();
//				String city = row.getCell(2).getStringCellValue();
//				String district = row.getCell(3).getStringCellValue();
//				String postcode = row.getCell(4).getStringCellValue();

				Object area = new Object();
//				area.setCity(city);
//				area.setDistrict(district);
//				area.setProvince(province);
//				area.setPostCode(postcode);
				list.add(area);
			}
			//5、关闭流
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) throws IOException {
//		exportExcel();//"E:\\pcap\\xiaoshengchu.txt"
		String appName = "E:\\pcap\\jiaowei\\应用支撑服务平台";
		List<Data> readPcap = readPcap(appName+".txt");
		exportExcel(readPcap, appName);
	}
	static String S2C = "S2C";
	static String tls = "TLSv1.2";
	public static List<Data> readPcap(String fileName) throws IOException{
		Reader r = new InputStreamReader(new FileInputStream(fileName),"UTF-8");
		BufferedReader reader = new BufferedReader(r);
		String readLine = null;
		boolean isData = false;
		boolean isHTTP = false;
		boolean isTCP = false;
		Data data = null;
		List<Data> list = new ArrayList<>();
		while((readLine = reader.readLine())!=null) {
			if(readLine.startsWith("No")) {
				isData = true;
				continue;
			}else if(isData) {
				String [] arr = readLine.split("\\s+");
				String prol = arr[2];
				if("TCP".equals(prol)||tls.equals(prol)) {
					data = new Data();
					String sip = arr[3];
					if(myIp.equals(sip)) {
						data.setBool("C2S");
					}else {
						data.setBool(S2C);
					}
					data.setPro(prol);
					int first,last = 0;
					String substring = "无";
					int length = Integer.parseInt(arr[7]);
					data.setPktSize(getSize(length));
					data.setHttpFirst("N/A");
					if("TCP".equals(prol)) {
						first = readLine.indexOf("[");
						last = readLine.indexOf("]");
						substring = readLine.substring(first+1, last);
						if(substring.length() > 10) {
							first = readLine.indexOf("[", first+1);
							last = readLine.indexOf("]", last+1);
							substring = readLine.substring(first+1, last);
						}
//						first = readLine.indexOf("Win=");
//						last = readLine.indexOf(" ", first);
//						String winSize = readLine.substring(first+4, last);
//						data.setWindowSize(Integer.parseInt(winSize));
						if(length < 80) {
							data.setPayloadLength(0);
						}
					}
					isTCP = true;
					data.setFlag(substring);
				}else if("HTTP".equals(prol)) {
					data = new Data();
					String sip = arr[3];
					if(myIp.equals(sip)) {
						data.setBool("C2S");
					}else {
						data.setBool("S2C");
					}
					data.setPro("HTTP");
					int length = Integer.parseInt(arr[7]);
					data.setPktSize(getSize(length));
					isHTTP = true;
				}
				isData = false;
			}else if(isTCP) {
				 if(readLine.contains("Window size value")){
					String[] split = readLine.trim().split(":");
					data.setWindowSize(Integer.parseInt(split[1].substring(1)));
					if(data.getPayloadLength() != null) {
						isTCP = false;
						list.add(data);
					}
				}else if(readLine.contains("TCP payload")) {
					int first = readLine.indexOf("(");
					int last = readLine.indexOf(" ", first);
					String payload = readLine.substring(first+1, last);
					data.setPayloadLength(Integer.parseInt(payload));
					isTCP = false;
					list.add(data);
				}
			}else if(isHTTP) {
				if(readLine.contains("Flags")){
					int first = readLine.indexOf("(");
					int last = readLine.indexOf(")");
					data.setFlag(readLine.substring(first+1,last));
				}else if(readLine.contains("Window size value")){
					String[] split = readLine.trim().split(":");
					data.setWindowSize(Integer.parseInt(split[1].substring(1)));
				}else if(readLine.contains("TCP payload")) {
					int first = readLine.indexOf("(");
					int last = readLine.indexOf(" ", first);
					String payload = readLine.substring(first+1, last);
					data.setPayloadLength(Integer.parseInt(payload));
				}else if(readLine.endsWith("Protocol")) {
					/*
					 GET /images/guanbi.png HTTP/1.1\r\n
				    Host: hdxscgl.yjrx.bjedu.cn\r\n
				    Connection: keep-alive\r\n
				    User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36\r\n
				 */
					readLine = reader.readLine().trim();
					System.out.println(readLine);
					if(readLine.startsWith("Data")) {//data下面什么都没了
						data.setHttpFirst(readLine);
						isHTTP = false;
						list.add(data);
					}else {
						data.setHttpFirst(readLine.substring(0, readLine.length()-4));
						String bool = data.getBool();
						if(!S2C.equals(bool)||!readLine.contains("200")) {//404也没有content-Type,302也没有, 其实应该是出了200 都没;
							isHTTP = false;
							list.add(data);
						}
					}
				}else if(readLine.contains("Content-Type")){
					String[] split = readLine.trim().split(":");
					String substring = split[1].substring(1,split[1].length()-4);
					data.setHttpFirst(data.getHttpFirst()+" "+ substring);
					isHTTP = false;
					list.add(data);
				}
			}else {
				continue;
			}
		}
		reader.close();
		return list;
	}
	static String myIp = "192.168.0.201";
	static int min = 80;
	static int mid = 1500;
	static String getSize(int a) {
		if(a <= min)return "small";
		if(a <= mid)return "middle";
		else return "big";
	}
	public static void exportExcel(List<Data> list,String outFileName) throws IOException {
		
		       //1.在内存中创建一个excel文件
		       HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		       //2.创建工作簿
		       HSSFSheet sheet = hssfWorkbook.createSheet();
		       //3.创建标题行
		       HSSFRow titlerRow = sheet.createRow(0);
		       titlerRow.createCell(0).setCellValue("报文顺序");
		       titlerRow.createCell(1).setCellValue("协议特征");
		       titlerRow.createCell(2).setCellValue("报文方向");
		       titlerRow.createCell(3).setCellValue("Flag标志位");
		       titlerRow.createCell(4).setCellValue("报文大小");
		       titlerRow.createCell(5).setCellValue("payload_length");
		       titlerRow.createCell(6).setCellValue("窗口大小");
		       titlerRow.createCell(7).setCellValue("HTTP特征判断");
		       titlerRow.createCell(8).setCellValue("备注");
		       titlerRow.createCell(9).setCellValue("网址");
		
		       //4.遍历数据,创建数据行
		       int size = list.size() + 1;
		       for (int i = 1; i < size;i++) {
		           //获取最后一行的行号
		           int lastRowNum = sheet.getLastRowNum();
		           HSSFRow dataRow = sheet.createRow(lastRowNum + 1);
		           Data data = list.get(i-1);
		           dataRow.createCell(0).setCellValue(i);
		           dataRow.createCell(1).setCellValue(data.getPro());
		           dataRow.createCell(2).setCellValue(data.getBool());
		           dataRow.createCell(3).setCellValue(data.getFlag());
		           dataRow.createCell(4).setCellValue(data.getPktSize());
		           dataRow.createCell(5).setCellValue(data.getPayloadLength());
		           dataRow.createCell(6).setCellValue(data.getWindowSize());
		           dataRow.createCell(7).setCellValue(data.getHttpFirst());
		           dataRow.createCell(8).setCellValue("暂无");
		       }
		       //5.创建文件名
		       String fileName = outFileName+".xls";
		       FileOutputStream out = new FileOutputStream(fileName);
		       //10.写出文件,关闭流
		       hssfWorkbook.createInformationProperties();
		       hssfWorkbook.write(out);
		       hssfWorkbook.close();
		       out.close();
		   }
}
