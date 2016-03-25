import java.io.*;
import java.lang.*;

/**
 * 字符流的练习.
 * Created by Administrator on 2016/3/25.
 */
public class FileReaderTest {

    public static void main(String [] agrs)throws IOException{
        File file = new File("test.txt");
        FileReader flr = new FileReader(file);
        BufferedReader flrb = new BufferedReader(flr);
        String s;
        while ((s= flrb.readLine())!=null){
            System.out.println(s);
        }

        flrb.close();
        flr.close();
    }
}
