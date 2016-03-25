import java.io.*;
import java.lang.*;

/**
 * Created by Zeng Ge on 2016/3/25.
 */
public class FileOutStreamtest {

    public static void main(String[] agrs)throws IOException{
        String s = "hello world.";
        File file = new File("test.txt");
        FileOutputStream fl = new FileOutputStream(file,true);
        for(int i = 0 ;i < s.length(); i ++){
            fl.write(s.charAt(i));
        }
        fl.close();
    }
}
