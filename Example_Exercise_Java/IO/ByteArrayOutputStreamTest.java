package IO;

import java.io.*;

/**
 * 用内存操作流来实现大小写的转换，将数据先保存在内存里，而后从里面取出每一个数据
 * Created by zeng on 16-4-9.
 */
public class ByteArrayOutputStreamTest {

    public static void main(String[] args)throws Exception {
       String s = "hello world !!";

        //ByteArrayOutputStreamTest 继承自OutputStream，本次利用了向上转型
        InputStream in = new ByteArrayInputStream(s.getBytes());

        OutputStream out = new java.io.ByteArrayOutputStream();
        int temp = 0;
        while ((temp = in.read()) != -1){
            out.write(Character.toUpperCase(temp)); //所有数据都将保存在内存中
        }

        System.out.println(out);

        out.close();
        in.close();
    }

}
