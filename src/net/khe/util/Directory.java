package net.khe.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by hyc on 2016/10/16.
 */
public final class Directory {
    public static File[] local(File dir,final String regex){
        //��ȡ��ǰ�ļ����µ��ļ���ʹ��������ʽ����ɸѡ
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String path,String regex){
        return local(new File(path),regex);
    }
    public static class TreeInfo implements Iterable<File>{//Ŀ¼��
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        @Override
        public String toString(){
            return "dirs: "+ PPrint.pformat(dirs) +
                    "\n\nfiles: "+PPrint.pformat(files);
        }
    }
    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }
    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }
    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }
    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }
    static TreeInfo recurseDirs(File startDir,String regex){
        //�ݹ��ȡ
        TreeInfo result = new TreeInfo();
        for(File item:startDir.listFiles()){
            if(item.isDirectory()){//�����Ŀ¼
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));//�ݹ���Ŀ¼��
            }else if(item.getName().matches(regex))
                result.files.add(item);//���ƥ����ļ�
        }
        return result;
    }

    public static void main(String[] args) {
        Print.println("�ݹ��ȡ��");
        if(args.length == 0)
            Print.println(walk("src/",".*\\.java"));
        else{
            for(String arg : args){
                Print.println(walk(arg));
            }
        }
        Print.println("����ȡ��ǰĿ¼��");
        File file = new File("src/net/khe/util");
        PPrint.pprintln(local(file,".*"));
    }
}
