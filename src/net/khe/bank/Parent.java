package net.khe.bank;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by hyc on 2016/12/7.
 */
public class Parent implements Runnable{
    private String name;
    private int moneyPerTime;
    private int waitTime;
    private BlockingQueue<BankCard> parentsQueue;

    public Parent(String name, int moneyPerTime, int waitTime, BlockingQueue<BankCard> parentsQueue) {
        this.name = name;
        this.moneyPerTime = moneyPerTime;
        this.waitTime = waitTime;
        this.parentsQueue = parentsQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                BankCard card = parentsQueue.take();
                try{
                    card.saveMoney(moneyPerTime);
                    parentsQueue.put(card);
                    System.out.println(name+" ´æÈë "+moneyPerTime+" Ôª");
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
