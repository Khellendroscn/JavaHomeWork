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
        println("�������ļ�λ�ã�");
        while (true){
            Scanner sc = new Scanner(System.in);
            String dir = sc.next();
            try{
                showFile(new File(dir));
                println("�������ļ�λ�ã�");
            }catch (IOException e){
                println("�ļ�δ�ҵ�������������:");
            }
        }
    }
}
