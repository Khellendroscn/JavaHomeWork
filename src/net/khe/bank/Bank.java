package net.khe.bank;

import java.util.concurrent.*;

/**
 * Created by hyc on 2016/12/7.
 */
public class Bank {
    public static void main(String[] args) {
        BlockingQueue<BankCard> parentsQueue = new ArrayBlockingQueue<BankCard>(1);
        BlockingQueue<BankCard> childrenQueue = new ArrayBlockingQueue<BankCard>(1);
        BankCard bankCard = new BankCard(parentsQueue, childrenQueue);
        try {
            parentsQueue.put(bankCard);
            childrenQueue.put(bankCard);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Parent father = new Parent("爸爸",1500,500,parentsQueue);
        Parent mother = new Parent("妈妈",1000,800,parentsQueue);
        Parent grandpa = new Parent("爷爷",800,1000,parentsQueue);
        Child daughter1 = new Child("大女儿",400,600,childrenQueue);
        Child daughter2 = new Child("二女儿",300,600,childrenQueue);
        Child son = new Child("三儿子",500,600,childrenQueue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(father);
        exec.execute(mother);
        exec.execute(grandpa);
        exec.execute(daughter1);
        exec.execute(daughter2);
        exec.execute(son);
        exec.execute(()->{
            while (!Thread.interrupted()){
                System.out.println("银行卡余额 "+bankCard.getMoney());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
