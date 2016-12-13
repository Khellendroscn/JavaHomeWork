package net.khe.homework10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hyc on 2016/12/9.
 */
public class GenTest {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.addAll(Arrays.asList(1,2,3,4,5));
        String[] strs = ints.toArray(new String[2]);
    }
}
