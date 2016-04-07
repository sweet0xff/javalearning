package IOExample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 字符输入流Reader.int reade(),读取不到则返回-1
 * 用FileReader子类对Reader类对象进行实例化.
 * 字符流与字节流的区别:字节流直接与终端进行数据交互,而字符流需要经过缓冲器进行处理后再输出.
 * 字符流对中文处理上能带来最大的方便.
 *
 * Created by Zeng on 2016/4/7.
 */
public class ReaderTest {
    public static void main(String[] agrs)throws IOException{
        File f = new File("D:"+ File.separator + "haha" + File.separator + "hehe.txt");
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        if(!f.exists()){
                f.createNewFile();
        }
       //为Reader对象实例化
        Reader rd = new FileReader(f);
        char[] c = new char[1024];  //注意read(char[] c)读取的是字符数组,不是字节数组
        int len = rd.read(c);
        rd.close();
        System.out.println(new String(c,0,len)); //注意要把字符串数组传到String类里面进行处理再print出来
    }
}
