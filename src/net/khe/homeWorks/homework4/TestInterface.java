package net.khe.homeWorks.homework4;

import static net.khe.util.Print.*;
/**
 * Created by hyc on 2016/10/17.
 */
interface MobilePhone{
    void call();
    void receive();
    void sendMsg();
    void receiveMsg();
}
interface Camera{
    void takePhoto();
}
class CameraPhone implements Camera,MobilePhone {
    protected String getType(){return this.getClass().getSimpleName();}
    public void call(){
        println(getType()+" Call");
    }
    public void receive(){
        println(getType()+" receive");
    }
    public void sendMsg(){
        println(getType()+" send message");
    }
    public void receiveMsg(){
        println(getType()+" receive message");
    }
    public void takePhoto(){
        println(getType()+" receive message");
    }
}
class NokiaPhone extends CameraPhone{
    @Override
    protected String getType(){return "Nokia";}
}
class MotoPhone extends CameraPhone{
    @Override
    protected String getType(){return "Moto";}
}
class Student{
    private String name;
    private CameraPhone myPhone;
    public Student(String name,CameraPhone phone){
        this.name = name;
        this.myPhone = phone;
    }
    public void call(){myPhone.call();}
}
public class TestInterface {
    public static void main(String[] args) {
        Student zhangSan = new Student("张三",new NokiaPhone());
        Student liSi = new Student("李四",new MotoPhone());
        zhangSan.call();
        liSi.call();
    }
}
