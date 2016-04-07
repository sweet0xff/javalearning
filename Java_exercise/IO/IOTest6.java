package IO;

import javax.swing.plaf.synth.SynthUI;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/6.
 */
public class IOTest6 {
    public static void main(String[] agrs){
        File fl = new File("D:"+ File.separator +"\5.PNG");
        System.out.println(fl.isFile());
        System.out.println(fl.isDirectory());
        System.out.println("文件大小:" + (new BigDecimal((double)fl.length()/1024).divide
                (new BigDecimal(1),2,BigDecimal.ROUND_CEILING)) + "KB");
        System.out.println("上次修改的时间是: "+new SimpleDateFormat
                ("yyyy-MM-dd HH:mm:ss").format(new Date(fl.lastModified())));
        System.out.println(fl.getPath());
    }

}
