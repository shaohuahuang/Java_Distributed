/**
 * Created by airshaos on 21/8/17.
 */

public class ExtendThreadDemo extends java.lang.Thread {
    int threadNumber;
    public ExtendThreadDemo(int num){
        threadNumber = num;
    }

    public void run(){
        System.out.println ("I am thread number " + threadNumber);
        try{
            Thread.sleep(5000);
        }catch (InterruptedException ie){

        }
        System.out.println (threadNumber + " is finished!");
    }

//    public static void main(String args[]){
//        System.out.println ("Creating thread 1");
//        Thread t1 = new ExtendThreadDemo(1);
//        System.out.println ("Creating thread 2"); // Create second thread instance
//        Thread t2 = new ExtendThreadDemo(2);
//        t1.start();
//        t2.start();
//    }

    public static void main(String args[]){
        System.out.println ("Creating thread 1");
        Thread t1 = new ExtendThreadDemo(1);
        System.out.println ("Creating thread 2");
        Thread t2 = new ExtendThreadDemo(2);
//        t1.setDaemon(true);
//        t2.setDaemon(true);
        t1.start();
        t2.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ie) {}
    }

}
