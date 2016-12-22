package net.khe.homework12;

import net.khe.util.TextFileReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static net.khe.util.Print.*;
/**
 * Created by hyc on 2016/12/21.
 */
public class ShowFile {
    public static void showFile(File file)throws IOException{
        TextFileReader reader;
        reader = new TextFileReader(file);
        for(String text:reader){
            println(text);
        }
    }

    public static void main(String[] args) {
        println("请输入文件位置：");
        while (true){
            Scanner sc = new Scanner(System.in);
            String dir = sc.next();
            try{
                showFile(new File(dir));
                println("请输入文件位置：");
            }catch (IOException e){
                println("文件未找到，请重新输入:");
            }
        }
    }
}
