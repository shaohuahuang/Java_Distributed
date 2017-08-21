/**
 * Created by airshaos on 17/8/17.
 */
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PacketReceiveDemo {
    public static void main(String args[]){
        try{
            System.out.println ("Binding to local port 2000");
            DatagramSocket socket = new DatagramSocket(2000);
            System.out.println ("Bound to local port "
                    + socket.getLocalPort());
            DatagramPacket packet = new DatagramPacket(new byte[256], 256);

            socket.receive(packet);
            System.out.println ("Packet received!");

            InetAddress remote_addr = packet.getAddress();
            System.out.println ("Sent by : " +
                    remote_addr.getHostAddress() );
            System.out.println ("Sent from: " +
                    packet.getPort());

            ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
            for(int i=0; i< packet.getLength(); i++){
                int data = bin.read();
                if (data == -1)
                    break; else
                    System.out.print ( (char) data) ;
            }
            socket.close();
        }catch (IOException ioe){
            System.err.println ("Error - " + ioe);
        }
    }
}
