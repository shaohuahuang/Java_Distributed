package ch7;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

/**
 * Created by airshaos on 23/8/17.
 */
public class PipeDemo extends Thread {
    PipedOutputStream output;
    public PipeDemo(PipedOutputStream out){
        output = out;
    }

    public void run(){
        try{
            PrintStream p = new PrintStream(output);
            p.println("Hello from another thread, via pipes!");
            p.close();
        }catch (Exception e){}
    }

    public static void execute(){
        try{
            PipedOutputStream pout = new PipedOutputStream();
            PipedInputStream pin = new PipedInputStream(pout);

            PipeDemo pipeDemo = new PipeDemo(pout);
            pipeDemo.start();

            int input = pin.read();
            while (input != -1){
                System.out.print ( (char) input);
                input = pin.read();
            }
        }catch (Exception e){
            System.err.println ("Pipe error " + e);
        }
    }
}
