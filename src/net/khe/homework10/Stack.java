package net.khe.homework10;

import net.khe.homeWorks.homework5.OutOfRangeException;

import java.util.Arrays;

/**
 * Created by hyc on 2016/12/9.
 */
public class Stack<T> {
    private T[] array;
    private int size;
    private int top;
    public Stack(int length){
        this.size = 0;
        array = (T[])new Object[length];
        top = -1;
    }
    public Stack(T...initList){
        this.size = initList.length;
        array = initList;
        top = size-1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int getSize(){
        return size;
    }
    public void push(T item){
        if(array.length <= size){
            throw new RuntimeException(new OutOfRangeException());
        }
        ++size;
        array[++top] = item;
    }
    public T pop(){
        if(isEmpty()){
            return null;
        }
        --size;
        return array[top--];
    }
    public T getTop(){
        if(isEmpty()){
            return null;
        }
        return array[top];
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for(int i=0;i<size;++i){
            stringBuilder.append(array[i]+" ");
            if(i!=size-1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack(1,2,3,4,5);
        System.out.println("stack "+stack);
        System.out.println("stack.pop() "+stack.pop());
        System.out.println("stack "+stack);
        System.out.println("stack.push(6)");
        stack.push(6);
        System.out.println("stack "+stack);
        //System.out.println("stack.push(7) //out of range");
        //stack.push(7);
    }
}
