package IOExample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 输出字符数组,有别于字节数组.最大的特征是可以输出字符串.
 * Writer是一个抽象类,如果要把这个类的对象实例化,应该用FileWriter子类.
 * Created by Administrator on 2016/4/7.
 */
public class WriterTest {
    public static void main(String[] agrs)throws IOException{
        File f = new File("D:" + File.separator + "haha" + File.separator + "hehe.txt");
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }
        if(!f.exists()){
            f.createNewFile();
        }
       //实例化Writer子类对象
        Writer w = new FileWriter(f);
        //进行内容输出,Writer类有一个可以直接接受字符串然后输出的write方法.
        String s = "hello Java hello world";
        w.write(s);
        w.close();
    }
}
