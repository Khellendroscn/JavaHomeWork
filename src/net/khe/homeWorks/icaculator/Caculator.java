package net.khe.homeWorks.icaculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.khe.util.Print.*;
/**
 * Created by hyc on 2016/11/8.
 */
public abstract class Caculator implements ICaculator {
    protected double num1;
    protected double num2;
    protected double result;
    private static String[] split(String expression) throws ExprException{
        String regex = "(.+)([\\+\\-\\*\\/])(.+)";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(expression);
        String[] result = new String[3];
        if (matcher.matches()){
            result[0] = matcher.group(1);
            result[1] = matcher.group(2);
            result[2] = matcher.group(3);
        }else {
            throw new ExprException("表达式错误");
        }
        //println(Arrays.toString(result));
        return result;
    }
    public void setNums(double num1,double num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public abstract double caculate();
    public static Caculator newCaculator(String expr) throws ExprException{
        String[] args = split(expr);
        char sign = args[1].toCharArray()[0];
        Caculator result;
        switch (sign){
            case '+':result = new PlusCaculator();break;
            case '-':result = new MinusCaculator();break;
            case '*':result = new MultiplyCaculator();break;
            case '/':result = new DivideCaculator();break;
            default:throw new ExprException("表达式错误");
        }
        result.setNums(new Double(args[0]),new Double(args[2]));
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr;
        println("请输入表达式，输入空行退出程序");
        while (!(expr=sc.nextLine()).equals("")){
            try {
                ICaculator caculator = Caculator.newCaculator(expr);
                println(expr+" = "+caculator.caculate());
                println("请输入下一个表达式");
            } catch (ExprException e) {
                println(e.getMessage());
                println("请重新输入");
                continue;
            }
        }
    }
}
class ExprException extends Exception{
    public ExprException(String what){super(what);}
}

class PlusCaculator extends Caculator {
    public double caculate(){
        return result=num1+num2;
    }
}
class MinusCaculator extends Caculator {
    public double caculate(){
        return result=num1-num2;
    }
}
class MultiplyCaculator extends Caculator {
    public double caculate(){
        return result=num1*num2;
    }
}
class DivideCaculator extends Caculator {
    public double caculate(){
        if(num2 == 0){
            println("除数不能为0");
        }
        return result=num1/num2;
    }
}