package net.khe.util;

import java.io.File;
import java.io.IOException;

/**
 * Created by hyc on 2016/12/22.
 */
public class Files {
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
}
