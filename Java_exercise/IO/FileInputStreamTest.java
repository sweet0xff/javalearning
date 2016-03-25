import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream类的练习.
 *
 * Created by Administrator on 2016/3/25.
 */
public class FileInputStreamTest {

    public static void main(String[] agrs) {
        try{
            File file = new File("test.txt");
            FileInputStream fl = new FileInputStream(file);
            for(int i =0; i <file.length(); i ++) {
                char ch = (char)(fl.read());
                System.out.println(ch);
            }
            System.out.println();
            fl.close();
        }catch (FileNotFoundException flnofind){
            System.out.println("文件打开失败！！！");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}


