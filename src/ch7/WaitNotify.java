package ch7;

/**
 * Created by airshaos on 23/8/17.
 */
public class WaitNotify extends Thread {
    public static void execute() throws Exception{
        Thread notificationThread = new WaitNotify();
        notificationThread.start();
        synchronized (notificationThread){
            notificationThread.wait();
        }
        System.out.println ("The wait is over");
    }

    public void run(){
        System.out.println ("Hit enter to stop waiting thread");
        try{
            System.in.read();
        }catch (java.io.IOException ioe){}

        synchronized (this){
            this.notifyAll();
        }
    }
}
