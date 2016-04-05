package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/4/5.
 */
public class IOTest4 {
    public static void main(String [] agrs)throws FileNotFoundException,IOException{
        String s = "I love java, really?";
        FileOutputStream f = new FileOutputStream("hehe.txt");

        byte[] buf = s.getBytes();  //将字符串转换成数组
        f.write(buf);  //将字符串数组一次性写入文件
        f.close();
    }
}
