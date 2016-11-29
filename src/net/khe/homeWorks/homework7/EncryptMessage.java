package net.khe.homeWorks.homework7;

/**
 * Created by hyc on 2016/11/29.
 */
public class EncryptMessage {
    public static char encryptChar(char ch){
        if((ch>='a'&&ch<'z')||(ch>='A'&&ch<'Z')) ++ch;
        else if(ch=='z') ch='a';
        else if(ch=='Z') ch='A';
        return ch;
    }
    public static String encryptString(String str){
        StringBuffer buffer = new StringBuffer(str);
        for(int i=0;i<buffer.length();++i){
            char ch = buffer.charAt(i);
            ch = encryptChar(ch);
            buffer.setCharAt(i,ch);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str = "AZazAbCd";
        str = encryptString(str);
        System.out.println(str);
    }
}
