package net.khe.homeWorks.stringutil;

import net.khe.util.Generator;
import net.khe.util.RandomGenerator;

import java.util.Arrays;

/**
 * Created by hyc on 2016/11/16.
 */
public class RandomChars {
    public static char[] randomChars(int length){
        //×Ö·ûÉú³ÉÆ÷
        String charSet = "abcdefghijklmnopqrstuvwxyz";
        Generator<Character> generator = new RandomGenerator.Character(charSet);
        char[] chars = new char[length];
        for(int i=0;i<length;++i){
            char c = generator.next();
            for(int j=0;j<i;++j){
                //ÅÐ¶ÏÖØ¸´
                if(chars[j] == c){
                    c = generator.next();
                    j=0;
                }
            }
            chars[i] = c;
        }
        Arrays.sort(chars);//ÅÅÐò
        return chars;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;++i){
            System.out.println(Arrays.toString(randomChars(5)));
        }
    }
}
