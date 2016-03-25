import java.io.*;
/**
 * 此程序可以输出中文.
 * Created by Zeng Ge on 2016/3/25.
 */
public class FileInputStreamTest2 {


    public static void main(String[] agrs) {
        try {
            File file = new File("test.txt");
            FileInputStream fl = new FileInputStream(file);
            byte[] buffer = new byte[(int)(file.length())];
            fl.read(buffer);
            String s = new  String(buffer);
            System.out.println(s);
            fl.close();
        }catch (FileNotFoundException flnofind){
            System.out.println("文件打开失败！！！");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
