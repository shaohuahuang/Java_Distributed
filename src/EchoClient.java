import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by AirShaos on 19/8/17.
 */
public class EchoClient {
  public static final int SERVICE_PORT = 5000;
  public static final int BUFSIZE = 256;
  public static void main(String args[]){
    if(args.length != 1){
      System.err.println ("Syntax - java EchoClient hostname");
      return;
    }
    
    String hostname = args[0];
    InetAddress addr = null;
    try {
      addr = InetAddress.getByName(hostname);
    }catch (UnknownHostException uhe){
      System.err.println ("Unable to resolve host");
      return;
    }
    
    try{
      DatagramSocket socket = new DatagramSocket();
      socket.setSoTimeout(2*1000);
      for(int i=1; i<=10; i++){
        String message = "Packet number " + i;
        char[] cArray = message.toCharArray();
        byte[] sendbuf = new byte[cArray.length];
        for( int offset = 0; offset < cArray.length; offset++){
          sendbuf[offset] = (byte) cArray[offset];
        }
        DatagramPacket sendPacket = new DatagramPacket(sendbuf, cArray.length, addr, SERVICE_PORT);
        System.out.println ("Sending packet to " + hostname);
        socket.send(sendPacket);
        System.out.print ("Waiting for packet.... ");
        byte[] recbuf = new byte[BUFSIZE];
        DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE);
        boolean timeout = false;
        try{
          socket.receive(receivePacket);
        }catch (InterruptedIOException ioe){
          timeout = true;
        }
        
        if(!timeout){
          System.out.println ("packet received!");
          System.out.println ("Details : " + receivePacket.getAddress());
          ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
          BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
          for(;;){
            String line = reader.readLine();
            if(line == null)
              break;
            else
              System.out.println(line);
          }
        }else{
          System.out.println ("packet lost!");
        }
        
        try{
          Thread.sleep(1000);
        }catch (InterruptedException ie){}
      }
    }catch (IOException ioe){
      System.err.println ("Socket error " + ioe);
    }
  }
}