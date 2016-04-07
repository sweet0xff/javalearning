package IOExample;

import javax.imageio.event.IIOWriteProgressListener;
import java.io.File;
import java.io.IOException;

/**
 * 文件的创建和删除
 * Created by Zeng Ge on 2016/4/6.
 */
public class MkdirsOrCreateNewFile {
    public static void main(String[] agrs)throws IOException{
        File fl = new File("D:"+ File.separator +"test.txt");//separator,解决Windows和Linux,Unix上文件路径分隔符不一致的问题
        if(fl.exists()){
            fl.delete();  //判断文件是否存在
        }else {
            System.out.println(fl.createNewFile()); //creat a file
        }

        File file = new File("D:" +File.separator + "test" + File.separator+ "test.txt"); //创建目录和文件
        if(!file.getParentFile().exists()){  //判断目录是否存在
            file.getParentFile().mkdir();
        }
        if(file.exists()){
            file.delete();
        }else {
            System.out.println(file.createNewFile());
        }

        //创建多级目录
        File ff = new File("D:"+ File.separator+ "a" + File.separator + "b" + File.separator +"c" + File.separator +"hehe.txt");
        if(!ff.getParentFile().exists()){
            ff.getParentFile().mkdirs();
        }
        if(!ff.exists()){ //创建文件
            ff.createNewFile();
        }
    }
}
