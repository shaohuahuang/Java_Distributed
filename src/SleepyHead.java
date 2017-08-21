/**
 * Created by airshaos on 21/8/17.
 */
public class SleepyHead extends Thread {
    public void run(){
        System.out.println ("I feel sleepy. Wake me in eight hours");
        try{
            Thread.sleep(1000 * 3600 * 8);
            System.out.println ("That was a nice nap");
        }catch (InterruptedException ie)
        {
            System.err.println ("Just five more minutes....");
        }
    }

    public static void main(String args[]) throws java.io.IOException{
        Thread sleepy = new SleepyHead();
        sleepy.start();
        System.out.println ("Press enter to interrupt the thread");
        System.in.read();
        sleepy.interrupt();
    }


}
