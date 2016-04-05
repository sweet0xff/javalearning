package IO;

import java.io.*;

/**
 * Created by Administrator on 2016/4/5.
 */
public class IOTest3 {

    public static void main(String [] agrs){
        try{
            File file = new File("hehe.txt");  //创建文件对象.
            FileInputStream ff = new FileInputStream(file);
            byte[] bf= new byte[(int)(file.length())];  //根据file的长度创建字节数组
            ff.read(bf);
            String s = new String(bf);
            System.out.print(s);
            ff.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

