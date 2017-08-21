/**
 * Created by airshaos on 17/8/17.
 */
import java.io.*;
import java.net.*;
public class PacketSendDemo {
    public static void main(String args[]){
        int argc = args.length;
        if (argc != 1)
        {
            System.out.println ("Syntax :");
            System.out.println ("java PacketSendDemo hostname");
            return;
        }

        String hostname = args[0];

        try{
            System.out.println ("Binding to a local port");
            DatagramSocket socket = new
                    DatagramSocket();
            System.out.println ("Bound to local port "
                    + socket.getLocalPort());

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);


        }catch (IOException ioe){

        }

    }
}
