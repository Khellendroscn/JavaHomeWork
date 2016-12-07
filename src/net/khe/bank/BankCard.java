package net.khe.bank;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hyc on 2016/12/7.
 */
public class BankCard {
    private int money;
    private BlockingQueue<BankCard> parentsQueue;
    private BlockingQueue<BankCard> childrenQueue;
    public final static int MAX_MONEY = 5000;

    public BankCard(BlockingQueue<BankCard> parentsQueue, BlockingQueue<BankCard> childrenQueue) {
        this.parentsQueue = parentsQueue;
        this.childrenQueue = childrenQueue;
    }

    public synchronized void saveMoney(int money)throws BankCardException
    {
        try {
            if (this.money >= MAX_MONEY) {
                throw new BankCardException("现在不需要存款");
            }
            this.money += money;
            if(childrenQueue.isEmpty()) childrenQueue.put(this);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void takeMoney(int money)throws BankCardException
    {
        try {
            if (this.money < money) {
                throw new BankCardException("余额不足");
            }
            this.money -= money;
            if(parentsQueue.isEmpty())parentsQueue.put(this);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized int getMoney()
    {
        return money;
    }
    public void notifyPeople(ArrayList<?> list){
        for(Object obj:list){
            synchronized (obj){
                obj.notifyAll();
            }
        }
    }
}
class BankCardException extends Throwable {
    public BankCardException(String msg){
        super(msg);
    }
}