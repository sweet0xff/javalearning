package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 字符缓冲区流：BufferedReaderTest,BufferedWriter
 * 字符缓冲区流：BufferedInputStream,BufferedOutputStream
 * 重点方法 public string readLine()
 * public  String readLine()是最重要的方法,返回的是String类型数据，可以用正则进行处理
 * Created by zeng on 16-4-9.
 */
public class BufferedReaderTest {
    public static void main(String[] args)throws Exception {
        //System.in是InputStream类对象
        //BufferedReader的构造方法接收的是Reader类对象
        //InputStreamReader是Reader类的子类，构造方法接收一个InputStream类对象
        //利用InputStreamReader将字节流转换为字符流
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请输入数据：");//没有长度限制
        String s = buf.readLine();   //readLine()方法以回车作为换行
        System.out.println("输入的数据是： " + s);
    }
}
