package net.khe.homework12;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Created by hyc on 2016/12/21.
 */
public class CopyFile {
    public static void copyFile(File source,File target)throws IOException{
        //使用nio拷贝文件
        final int BufferSize = 1024;
        createFileIfNotExists(target);
        FileChannel inChannel = new FileInputStream(source).getChannel();
        FileChannel outChannel = new FileOutputStream(target).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BufferSize);
        int readFlag = inChannel.read(buffer);
        while (readFlag!=-1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
            inChannel.read(buffer);
        }
        inChannel.close();
        outChannel.close();
    }
    public static void createFileIfNotExists(File file) throws IOException {
        //检查文件，如果文件不存在则创建它
        if(!file.exists()){//文件不存在
            File dir = file.getParentFile();//获取文件路径
            if(!dir.exists()){
                dir.mkdir();//创建路径
            }
            file.createNewFile();//创建文件
        }else if(!file.isFile()){//该文件或路径已存在
            throw new IOException("Target is not a file.");//如果目标不是文件，抛出异常
        }
    }

    public static void main(String[] args) {
        try{
            copyFile(new File("test/test1.txt"),new File("test/test1_copy.txt"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
