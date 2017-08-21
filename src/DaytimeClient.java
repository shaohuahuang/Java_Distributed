import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by AirShaos on 19/8/17.
 */
public class DaytimeClient {
  public static final int SERVICE_PORT = 2000;
  public static void main(String args[]){
    if (args.length != 1)
    {
      System.out.println ("Syntax - DaytimeClient host");
      return;
    }
    
    String hostname = args[0];
    
    try {
      Socket daytime = new Socket(hostname, SERVICE_PORT);
      System.out.println ("Connection established");
      daytime.setSoTimeout(2000);
      BufferedReader reader = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
  
      System.out.println ("Results : " + reader.readLine());
      daytime.close();
    }catch (IOException ioe){
      System.err.println ("Error " + ioe);
    }
  }
}
