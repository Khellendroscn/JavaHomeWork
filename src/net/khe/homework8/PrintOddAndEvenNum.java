package net.khe.homework8;

/**
 * Created by hyc on 2016/11/30.
 */
public class PrintOddAndEvenNum {
    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0;i<=10;i+=2){
                System.out.print(i+" , ");
                Thread.yield();
            }
        }).start();
        new Thread(()->{
            for(int i=1;i<=10;i+=2){
                System.out.print(i+" , ");
                Thread.yield();
            }
        }).start();
    }
}
