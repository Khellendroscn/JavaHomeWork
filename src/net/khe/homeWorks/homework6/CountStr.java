package net.khe.homeWorks.homework6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hyc on 2016/11/16.
 */
public class CountStr {
    public static int countStr(String str,String child){
        Pattern p = Pattern.compile(child);
        Matcher m = p.matcher(str);
        int result = 0;
        while (m.find()){
            ++result;
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "String testString StringtestString Stringtest test";
        String child = "test";
        System.out.printf("How many ¡¾%s¡¿ in \"%s\"?:\n%d",child,string,countStr(string,child));
    }
}
