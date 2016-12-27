package net.khe.homework13;

import java.io.*;
import java.util.Random;
import static net.khe.util.Files.*;
/**
 * Created by hyc on 2016/12/22.
 */
public class RandomNumFile {
    public static void main(String[] args) {
        final int min = 1000;
        final int max = 2000;
        Random rand = new Random();
        File file = new File("output/data.dat");
        try {
            createFileIfNotExists(file);
            DataOutputStream os =
                    new DataOutputStream(new FileOutputStream(file));
            for(int i=0;i<10;++i){
                int n = rand.nextInt(max-min)+min;
                os.writeInt(n);
            }
            os.flush();
            os.close();
            DataInputStream is =
                    new DataInputStream(new FileInputStream(file));
            while (is.available()!=0){
                System.out.println(is.readInt());
            }
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("无法找到文件："+file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
