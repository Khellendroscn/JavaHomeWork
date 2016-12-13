package net.khe.homework10;

import java.util.Arrays;
import java.util.HashSet;
import static net.khe.util.Print.*;
/**
 * Created by hyc on 2016/12/9.
 */
public class TestHashSet {
    public static void main(String[] args) {
        println("create hash set");
        HashSet<String> stringSet = new HashSet<>();
        println("add values");
        stringSet.addAll(Arrays.asList("aaa","bbb","ccc","ddd","eee"));
        println("stringSet: "+stringSet);
        println("try to add repeating element");
        stringSet.add("aaa");
        println("stringSet: "+stringSet);
        println("is stringSet contains aaa ? "+stringSet.contains("aaa"));
        println("is stringSet contains fff ? "+stringSet.contains("fff"));
        println("remove aaa");
        stringSet.remove("aaa");
        println("stringSet: "+stringSet);
        println("is stringSet contains aaa ? "+stringSet.contains("aaa"));
    }
}
