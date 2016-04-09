package IO;


import java.io.InputStream;
import java.sql.SQLOutput;

/**
 * System实例化对象使用的是PrintStream类对象进行的输出设备显示.
 * Created by zeng on 16-4-9.
 */
public class SystemInTest {
    public static void main(String[] args)throws Exception {
        InputStream in = System.in;
        System.out.println("请出入信息：");
        byte [] data = new byte[1024];

        int len = in.read(data);
        System.out.println("出入的信息是：" + new String(data,0,len));

    }
}
