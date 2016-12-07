package net.khe.bank;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by hyc on 2016/12/7.
 */
public class Child implements Runnable{
    private String name;
    private int moneyPerTime;
    private int waitTime;
    private BlockingQueue<BankCard> childrenQueue;

    public Child(String name, int moneyPerTime, int waitTime, BlockingQueue<BankCard> childrenQueue) {
        this.name = name;
        this.moneyPerTime = moneyPerTime;
        this.waitTime = waitTime;
        this.childrenQueue = childrenQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                BankCard card = childrenQueue.take();
                try{
                    card.takeMoney(moneyPerTime);
                    childrenQueue.put(card);
                    System.out.println(name+" È¡³ö "+moneyPerTime+" Ôª");
                }catch (BankCardException e){
                    System.out.println(e.getMessage());
                }
                TimeUnit.MILLISECONDS.sleep(waitTime);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
