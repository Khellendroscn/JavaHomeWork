package net.khe.homeWorks.homework5;

/**
 * Created by hyc on 2016/11/2.
 */
public class ExceptionTest1 {
    public static void main(String[] args) {
        try{
            System.out.println("2/0="+(2/0));
        }catch (Exception e){
            System.out.println("除数不能为零");
        }finally {
            System.out.println("finally");
        }
    }
}
