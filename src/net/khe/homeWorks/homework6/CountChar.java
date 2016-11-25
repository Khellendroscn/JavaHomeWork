package net.khe.homeWorks.homework6;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hyc on 2016/11/16.
 */
public class CountChar {
    public static int[] countChar(String str){
        String[] regexs = {
                "[A-Z]",
                "[a-z]",
                "[^A-Za-z]",
        };
        int[] result = new int[regexs.length];
        for(int i=0;i<regexs.length;++i){
            Pattern pattern = Pattern.compile(regexs[i]);
            Matcher matcher = pattern.matcher(str);
            result[i] = 0;
            while(matcher.find()){
                ++result[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "HelloWorld#$%";
        System.out.println("str: "+str);
        System.out.println("´óÐ´×ÖÄ¸\tÐ¡Ð´×ÖÄ¸\t·Ç×ÖÄ¸");
        int[] counts = countChar(str);
        System.out.printf("%8d\t%8d\t%6d",counts[0],counts[1],counts[2]);
    }
}
