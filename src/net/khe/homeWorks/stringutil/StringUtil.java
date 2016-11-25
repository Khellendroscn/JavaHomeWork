package net.khe.homeWorks.stringutil;

import net.khe.util.UnpackArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.khe.util.Print.*;

/**
 * Created by hyc on 2016/11/23.
 */
public class StringUtil {
    public static int[] childsAt(String str, String child){
        List<Integer> indexs = new ArrayList<>();
        int index = str.indexOf(child);
        while (index!=-1){
            indexs.add(indexs.size()>0?index+indexs.get(indexs.size()-1)+1:index);
            str = str.substring(index+1);
            index = str.indexOf(child);
        }
        Integer[] arr = new Integer[indexs.size()];
        arr = indexs.toArray(arr);
        return UnpackArray.unpack(arr);
    }
    public static boolean isMirrorStr(String str)
    {
        char[] chars = str.toCharArray();
        for(int i=0,j=chars.length-1;i<j;++i,--j)
        {
            if(chars[i]!=chars[j])
                return false;
        }
        return true;
    }
    public static String emailUser(String emailAddr){
        String emailPattern = "(.+)@(.+)";
        Matcher matcher = Pattern.compile(emailPattern).matcher(emailAddr);
        if(matcher.matches()) return matcher.group(1);
        else return null;
    }
    public static int countChar(String str,char target){
        int count = 0;
        char[] chars = str.toCharArray();
        char lastChar = '\0';
        for(char c:chars){
            if(lastChar!=target&&c==target) ++count;
            lastChar = c;
        }
        return count;
    }
    public static String leftPad(String str,int length,char c){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;++i){
            sb.append(c);
        }
        return sb.toString()+str;
    }
    public static void main(String[] args) {
        String str = "abcabcacbabc",
                child = "abc";
        int[] indexs = childsAt(str,child);
        String line = "========================================";
        println(line);
        println("test childsAt():");
        println("string: "+str+" child: "+child);
        println(Arrays.toString(childsAt(str,child)));
        println(line);
        println("test isMirrorStr():");
        str = "abcacba";
        println("is "+str+" a 'mirror string'? "+isMirrorStr(str));
        str = "abcacab";
        println("is "+str+" a 'mirror string'? "+isMirrorStr(str));
        println(line);
        println("test emailUser():");
        String emailAddr = "Khellendros@xxx.com";
        println("email address: "+emailAddr);
        println("user: "+emailUser(emailAddr));
        println(line);
        println("test countChar():");
        char c = 'a';
        str = "aaabbbcccaaabbcaaba";
        printf("How many ¡¾%c¡¿ in \"%s\" ?\n",c,str);
        println(countChar(str,c));
        println(line);
        println("test leftPad():");
        println("string: "+str);
        println(leftPad(str,4,'#'));
    }
}
