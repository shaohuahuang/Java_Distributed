package ch7;

/**
 * Created by airshaos on 22/8/17.
 */
public class Counter {
    private int countValue;
    public Counter(){
        countValue = 0;
    }
    public synchronized void increaseCount(){
        int count = countValue;
        try{
            Thread.sleep(5);
        }catch (InterruptedException ie){

        }
        count++;
        countValue = count;
    }

    public synchronized int getCount(){
        return countValue;
    }
}
