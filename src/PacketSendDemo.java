import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by AirShaos on 19/8/17.
 */
public class PacketSendDemo {
  public static void main(String args[]){
    int argc = args.length;
    if (argc != 1)
    {
      System.out.println ("Syntax :"); System.out.println ("java PacketSendDemo hostname");
      return;
    }
    String hostname = args[0];
    try{
      System.out.println ("Binding to a local port");
      DatagramSocket socket = new DatagramSocket();
      System.out.println ("Bound to local port "+ socket.getLocalPort());
  
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      PrintStream pout = new PrintStream(bout);
      pout.print("Greetings!");
      
      byte[] barray = bout.toByteArray();
  
      DatagramPacket packet = new DatagramPacket(barray, barray.length);
      System.out.println ("Looking up hostname " + hostname );
      InetAddress remote_addr = InetAddress.getByName(hostname);
      System.out.println ("Hostname resolved as " + remote_addr.getHostAddress());
      packet.setAddress (remote_addr);
      packet.setPort    (2000);
      socket.send(packet);
      System.out.println ("Packet sent!");
  
    }catch (UnknownHostException uhe){
      System.err.println ("Can't find host " +
        hostname);
    }catch (IOException ioe){
      System.err.println ("Error - " + ioe);
    }
  }
}
