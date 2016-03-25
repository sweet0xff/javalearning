import java.io.*;
/**
 * 实现文件复制的功能.
 *
 * Created by Zeng Ge on 2016/3/25.
 */
public class FileOutPutStreamTest3 {

    public static void main(String[] agrs)throws Exception{
        File srcFile = new File("src.txt");
        File destFile = new File("dest.txt");
        if(!(destFile.exists())){
            destFile.createNewFile();
        }
        FileInputStream fl = new FileInputStream(srcFile);
        FileOutputStream fls = new FileOutputStream(destFile);
        byte[] buffer = new byte[1024];
        System.out.println("开始复制文件......");
        while (fl.read(buffer)!= -1){
            fls.write(buffer);
        }
        System.out.println("文件复制成功！");
        fl.close();
        fls.close();
    }
}
