package net.khe.homeWorks.homework7;

/**
 * Created by hyc on 2016/11/29.
 */
public class Decode {
    public static char decodeChar(char ch){
        if((ch>'a'&&ch<='z')||(ch>'A'&&ch<='Z')) --ch;
        else if(ch=='a') ch='z';
        else if(ch=='A') ch='Z';
        return ch;
    }
    public static String decodeString(String str){
        StringBuffer buffer = new StringBuffer(str);
        for(int i=0;i<buffer.length();++i){
            char ch = buffer.charAt(i);
            ch = decodeChar(ch);
            buffer.setCharAt(i,ch);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str = "AZazAbCd";
        str = decodeString(str);
        System.out.println(str);
    }
}
