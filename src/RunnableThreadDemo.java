/**
 * Created by airshaos on 21/8/17.
 */
public class RunnableThreadDemo implements java.lang.Runnable {
    public void run(){
        System.out.println ("I am an instance of the java.lang.Runnable interface");
    }

    public static void main(String args[]){
        System.out.println ("Creating runnable object");
        Runnable run = new RunnableThreadDemo();
        System.out.println ("Creating first thread");
        Thread t1 = new Thread (run);
        System.out.println ("Creating second thread");
        Thread t2 = new Thread (run);
        System.out.println ("Starting both threads");

        t1.start(); t2.start();
    }
}
