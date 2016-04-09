package IO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * toByteArrary可以合并两个文件中的内容
 * Created by zeng on 16-4-9.
 */
public class toByteArraryTest {

    public static void main(String[] args)throws Exception {
        File fa = new File("/" + "home" + File.separator + "zeng" + File.separator + "a" + File.separator + "hehe.txt");
        File fb = new File("/" + "home" + File.separator + "zeng" + File.separator + "a" + File.separator + "haha.txt");

        InputStream ina = new FileInputStream(fa);
        InputStream inb = new FileInputStream(fb);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int temp = 0 ; //每次读取一个字节
        while ((temp = ina.read()) != -1){
            out.write(temp);
        }

        while ((temp = inb.read()) != -1){
            out.write(temp);
        }
        //将所有的内容保存在内存中
        byte [] data = out.toByteArray();

        out.close();
        inb.close();
        ina.close();

        System.out.println(new String(data));
    }
}
