package net.khe.homework12;

import java.io.*;

/**
 * Created by hyc on 2016/12/21.
 */
public class Account implements Serializable{
    public final String id;
    public final String name;
    public final String password;
    public transient final String email;
    public final Date registedTime;

    public Account(String id, String name, String password, String email, Date registedTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.registedTime = registedTime;
    }
    @Override
    public String toString(){
        return String.format("Id: %s\nName: %s\nEmail: %s\nRegistedTime: %s",
                id,name,email,registedTime.toString());
    }

    public static void main(String[] args) {
        Account ac =
                new Account("Khellendros","hyc","hyc111","9999@qq.com",
                        new Date(2016,12,21));
        File target = new File("test/test2.Account");
        try {
            CopyFile.createFileIfNotExists(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ac);
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(target)));
            oos.writeObject(ac);
            oos.flush();
            System.out.println("write succeed");
            ObjectInputStream ois =
                    new ObjectInputStream(
                            new BufferedInputStream(
                                    new FileInputStream(target)));
            Account acClone = (Account)ois.readObject();
            System.out.println("clone:\n"+acClone);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Date implements Serializable{
    final int year;
    final int month;
    final int day;

    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    @Override
    public String toString(){
        return String.format("%4d-%2d-%2d",year,month,day);
    }
}