package net.khe.homework9;

/**
 * Created by hyc on 2016/12/2.
 */
public class App1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        t1.start();
        new Thread(()->{
            for(int i=100;i>=0;--i){
                System.out.println("Hello"+i);
                Thread.yield();
            }
        }).start();
    }
}
