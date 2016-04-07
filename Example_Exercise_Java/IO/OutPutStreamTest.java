package IOExample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件输入,输出操作.字节流和字符流两种方式.
 * 1,通过File类定义一个要操作的的文件的路径.
 * 2,通过字节流或字符流的子类对象为父类对象实例化.
 * 3,进行数据的读或写
 * 4,数据流属于资源操作,必须关闭资源操作
 *
 * 字节流:InPutStream,OutPutStream.字符流:Reader,WriterTest.
 * OutPutStream类有三个重要的write方法,write(int b),write(byte []),write(byte[], int off, int len)
 *
 * Created by Zeng.
 */
public class OutPutStreamTest {
    public static void main(String[] agrs)throws IOException{
        File f = new File("D:" + File.separator + "Demo" + File.separator + "demo.txt");
        //此时目录不存在,所以文件不能输出,先创建目录
        if(!f.getParentFile().exists()){
            f.getParentFile().mkdirs();
        }

        //没有文件时,会自动创建文件.
//        if(!f.exists()){
//            f.createNewFile();
//        }

        //用OutPutStream和其子类进行对象实例化
//        OutputStream os = new FileOutputStream(f);

        OutputStream os = new FileOutputStream(f,true);//内容追加

        String s = "good good study ,day day up \r\n";//\r\n 是换行操作
        byte[] data =s.getBytes(); //将字符串变成字节数组
        os.write(data);  //将内容输出

        //单个字节输入
        for(int i = 0 ; i<data.length; i ++) {
            os.write(data[i]);
        }

        //输出指定长度
//        os.write(data,2,10);

        os.close();
    }
}