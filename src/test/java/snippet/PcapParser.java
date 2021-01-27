package snippet;
import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.Packet;
import io.pkts.packet.PacketFactory;
import io.pkts.packet.TransportPacket;
import io.pkts.packet.TransportPacketFactory;
import io.pkts.packet.UDPPacket;
import io.pkts.protocol.IllegalProtocolException;
import io.pkts.protocol.Protocol;

import java.io.IOException;

/**
 * Created by wzj on 2017/10/26.
 */
public class PcapParser
{
    public static void main(String[] args) throws IOException
    {
        final Pcap pcap = Pcap.openStream("E:\\pcap\\203_208_50_70.pcap");

        pcap.loop(new PacketHandler()
        {
            @Override
            public boolean nextPacket(final Packet packet) throws IOException
            {
                if (packet.hasProtocol(Protocol.TCP))
                {
                    Buffer payload = packet.getPacket(Protocol.TCP).getPayload();
                    System.out.println(packet.getArrivalTime());//时间没问题
                    System.out.println(payload);//时间没问题
//                    System.out.println(payload.readUnsignedInt());//时间没问题
//                    System.out.println(payload.readUnsignedInt());//时间没问题
//                    System.out.println(payload.readUnsignedInt());//时间没问题
                }
                return true;
//                return false;
            }
        });
    }
}