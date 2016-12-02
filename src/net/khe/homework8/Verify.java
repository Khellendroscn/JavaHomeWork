package net.khe.homework8;
import static net.khe.util.Print.*;
/**
 * Created by hyc on 2016/11/30.
 */
public class Verify {
    public static boolean isName(String name){
        return name.matches("[A-Z]\\w+ [A-Z]\\w+");
    }
    public static boolean isEmail(String emailAddr){
        return emailAddr.matches("\\w+@\\w+.\\w+");
    }
    public static boolean isPhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\d{11}");
    }
    public static boolean isPostNumber(String postNum){
        return postNum.matches("\\d{6}");
    }
    public static void main(String[] args) {
        println("isName(\"Khellendros Huang\") "+ isName("Khellendros Huang"));
        println("isName(\"khellendroshuang\") "+ isName("khellendroshuang"));
        println("isEmail(\"986160053@qq.com\") "+ isEmail("986160053@qq.com"));
        println("isEmail(\"986160053.qq.com\") "+ isEmail("986160053.qq.com"));
        println("isPhoneNumber(\"13819055300\") "+ isPhoneNumber("13819055300"));
        println("isPhoneNumber(\"1381905530\") "+ isPhoneNumber("1381905530"));
        println("isPostNumber(\"314500\") "+isPostNumber("314500"));
        println("isPostNumber(\"31450\") "+isPostNumber("31450"));
    }
}
