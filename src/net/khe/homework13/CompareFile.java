package net.khe.homework13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hyc on 2016/12/27.
 */
public class CompareFile{
    public static boolean equalsFiles(File lhs,File rhs){
        final int BufferSize = 256;
        try {
            FileChannel lch = new FileInputStream(lhs).getChannel();
            FileChannel rch = new FileInputStream(rhs).getChannel();
            ByteBuffer lbuffer = ByteBuffer.allocate(BufferSize);
            ByteBuffer rbuffer = ByteBuffer.allocate(BufferSize);
            int lflag = lch.read(lbuffer);
            int rflag = rch.read(rbuffer);
            while (lflag!=-1&&rflag!=-1){
                if(!Arrays.equals(lbuffer.array(),rbuffer.array())) return false;
                lflag = lch.read(lbuffer);
                rflag = rch.read(rbuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        File f1 = new File("input/test1.txt");
        File f2 = new File("input/test2.txt");
        File f3 = new File("input/test3.txt");
        System.out.println(equalsFiles(f1,f2));
        System.out.println(equalsFiles(f1,f3));
    }
}
