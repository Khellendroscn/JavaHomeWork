package net.khe.homework13;

import java.io.*;

/**
 * Created by hyc on 2016/12/27.
 */
public class Coded {
    public static char codedChar(char ch){
        switch (ch){
            case 'a':return 'z';
            case 'b':return 'y';
            case 'A':return 'A';
            case 'B':return 'Y';
            default:return ch;
        }
    }
    public static String codedStr(String str){
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<sb.length();++i){
            sb.setCharAt(i,codedChar(sb.charAt(i)));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        final int BufferSize = 256;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String str;
            while ((str = in.readLine())!=null){
                out.write(codedStr(str));
                out.write("\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
