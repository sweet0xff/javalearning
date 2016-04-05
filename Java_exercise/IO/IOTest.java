package IO;

import javax.imageio.event.IIOWriteProgressListener;
import java.io.File;
import java.io.IOException;

/**
 *
 * Created by Zeng on 2016/4/5.
 */
public class IOTest {

    public static void main(String[] agrs)throws IOException{
        File fl  = new File("hehe.txt");
        if(!fl.exists()){
            fl.createNewFile();
        }else {
            fl.delete();
        }
    }
}
