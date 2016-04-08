package IO;

import java.io.*;

/**
 * 实现文件的拷贝功能.
 * Created by Zeng on 2016/4/8.
 */
public class CopyFileTestTwo {

    public static void main(String[] args) throws IOException{
        long start = System.currentTimeMillis();
        File in = new File("F:" + File.separator + "a" + File.separator + "origin.PPT");
        if(!in.exists()){
            System.out.println("源文件不存在");
            System.exit(1);
        }

        File out = new File("F:" + File.separator + "b" + File.separator + "copy.PPT");
        if(!out.getParentFile().exists()){
            out.getParentFile().mkdirs();
        }

        InputStream input = new FileInputStream(in);
        OutputStream output = new FileOutputStream(out);

        byte [] data = new byte[1024]; //每次读取1024个字节
        int temp = 0;
        //将读取的数据保存在数组里，并返回读取的个数
        while ((temp = input.read(data)) != -1){
            output.write(data,0,temp);
        }

        output.close();
        input.close();
        long end = System.currentTimeMillis();
        System.out.println("用时： " + (end - start));

    }

}
