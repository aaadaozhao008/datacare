package pcap.jiexi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TestPcap {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("E:\\pcap\\203_208_50_70.pcap");
		Pcap pcap = PcapParser.unpack(is);
		is.close();
		System.out.println("pcap==>"+pcap);
		byte[] t = pcap.getData().get(0).getContent();
		byte[] data = Arrays.copyOfRange(t, 42, t.length);
		System.out.println("data==>"+data);
	}
}
