import java.io.*;
import java.lang.*;
/**
 * 字符流的练习.
 *
 * Created by Administrator on 2016/3/25.
 */
public class FileReaderTest2 {

    public static void main(String[] args )throws IOException{
        File file = new File("test.txt");
        FileWriter fr = new FileWriter(file);
        BufferedWriter frb = new BufferedWriter(fr);
        frb.write("同志们好！同志们辛苦了.");
        frb.newLine();
        frb.write("想不想学Java？");
        frb.write("gun!") ;
        frb.close();
        fr.close();
    }
}
