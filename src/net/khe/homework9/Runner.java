package net.khe.homework9;

/**
 * Created by hyc on 2016/12/2.
 */
public class Runner implements Runnable {
    @Override
    public void run(){
        for(int i=0;i<100;++i){
            System.out.println("Hello"+i);
            Thread.yield();
        }
    }
}
