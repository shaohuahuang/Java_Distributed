/**
 * Created by airshaos on 17/8/17.
 */
import java.io.*;
public class InputStreamToReaderDemo {
    public static void main(String args[]){
        try{
            System.out.print ("Please enter your name : ");
            InputStream input  = System.in;
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            String name = bufReader.readLine();
            System.out.println ("Pleased to meet you, " +
                    name);
        }catch (IOException ioe){
            System.err.println ("I/O error : " + ioe);
        }
    }
}
