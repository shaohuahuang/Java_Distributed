import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by AirShaos on 19/8/17.
 */
public class EchoServer {
  public static final int SERVICE_PORT = 5000;
  public static final int BUFSIZE = 4096;
  
  private DatagramSocket socket;
  public EchoServer(){
    try{
      socket = new DatagramSocket(SERVICE_PORT);
      System.out.println ("Server active on port " + socket.getLocalPort() );
    }catch (Exception e){
      System.err.println("Unable to bind port");
    }
  }
  
  public void serviceClients(){
    byte[] buffer = new byte[BUFSIZE];
    for(;;){
      try{
        DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);
        socket.receive(packet);
        System.out.println ("Packet received from " + packet.getAddress() + ":" +
          packet.getPort() +
          " of length " + packet.getLength() );
        socket.send(packet);
      }catch (IOException ioe){
        System.err.println ("Error : " + ioe);
      }
    }
  }
  
  public static void main(String args[]){
    EchoServer server = new EchoServer();
    server.serviceClients();
  }
}
