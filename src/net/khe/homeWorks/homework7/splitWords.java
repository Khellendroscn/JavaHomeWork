package net.khe.homeWorks.homework7;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hyc on 2016/11/29.
 */
public class splitWords {
    public static void main(String[] args) {
        String str = "no pains,no gains";
        String regex = "\\w+";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        ArrayList<String> strings = new ArrayList<>();
        while (matcher.find()){
            strings.add(matcher.group());
        }
        System.out.println(strings);
    }

}
