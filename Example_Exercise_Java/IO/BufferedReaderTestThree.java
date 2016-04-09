package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 利用BufferedReader读取文件内容.适合读取中文
 * Created by zeng on 16-4-9.
 */
public class BufferedReaderTestThree {
    public static void main(String[] args) throws Exception{
        File fl = new File("/home/zeng/a/hehe.txt");
        BufferedReader buf = new BufferedReader(new FileReader(fl));

        String s = null;
        while((s = buf.readLine()) != null){
           System.out.println(s);
        }
        buf.close();
    }
}
