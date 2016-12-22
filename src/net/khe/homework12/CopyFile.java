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
        //ʹ��nio�����ļ�
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
        //����ļ�������ļ��������򴴽���
        if(!file.exists()){//�ļ�������
            File dir = file.getParentFile();//��ȡ�ļ�·��
            if(!dir.exists()){
                dir.mkdir();//����·��
            }
            file.createNewFile();//�����ļ�
        }else if(!file.isFile()){//���ļ���·���Ѵ���
            throw new IOException("Target is not a file.");//���Ŀ�겻���ļ����׳��쳣
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
