package net.khe.homeWorks.homework5;

import static net.khe.util.Print.*;
/**
 * Created by hyc on 2016/11/2.
 */
public class OutOfRangeException extends Exception {
    public OutOfRangeException(){
        super("数组访问异常：下标越界");
    }
    public static <T> T getElem(T[] array,int index)throws OutOfRangeException{
        if(index >= array.length) throw new OutOfRangeException();
        return array[index];
    }
    public static void main(String[] args) {
        Integer[] array = {0,1,2,3,4,5,};
        try{
            print("array[0]: ");
            println(getElem(array,0));
            print("array[7]: ");
            println(getElem(array,7));
        }catch (OutOfRangeException e){
            println(e.getMessage());
        }
    }
}
