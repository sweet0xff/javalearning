package IOExample;

import java.io.File;

/**
 * 递归列出目录所有文件的操作.
 * Created by Zeng on 2016/4/6.
 */
public class Recursive {
    public static void main(String[] agrs){
        File fl = new File("D:" + File.separator + "emacs");
        print(fl);

    }
    public static void print(File fl){
        if(fl.isDirectory()){ //判断是否是目录
            File [] result  = fl.listFiles();
            for(int i = 0; i < result.length; i ++) {
                print(result[i]); //递归调用
            }
        }
        System.out.println(fl);
//        fl.delete(); 删除所有文件

    }
}
