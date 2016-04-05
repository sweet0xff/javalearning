package IO;
import java.io.*;

/**
 * Created by Administrator on 2016/4/5.
 */
public class IOTest1 {

    public static void main(String [] agrs){
        File fl = new File("D:\\");
        File [] files = fl.listFiles();
        for(File f :files){
            System.out.println(f.getName());
        }
    }
}

