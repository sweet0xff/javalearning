import java.io.*;
import java.lang.*;

/**
 * Created by Zeng Ge on 2016/3/25.
 */
public class FileOutPutStreamtest2 {

    public static void main(String[] agrs)throws Exception {
        String s = "Java is amazing!";
        FileOutputStream fl = new FileOutputStream("test.txt");
        byte[] buffer = s.getBytes();
        fl.write(buffer);
        fl.close();
    }
}
