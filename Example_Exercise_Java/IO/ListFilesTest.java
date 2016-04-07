package IOExample;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zeng on 2016/4/6.
 */
public class ListFilesTest {
    public static void main(String[] agrs) {
        File fl = new File("D:" + File.separator);
        if (fl.isDirectory()) { //列出所有子目录和文件,修改时间,大小,保留两位有效小数
            String[] result = fl.list();
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
            File[] rs = fl.listFiles();
            for (int i = 0; i < rs.length; i++) {
                System.out.println(rs[i].getName() + "\t\t\t" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(rs[i].lastModified()))
                        + "\t\t\t" +
                        (rs[i].isDirectory()?"文件夹":"文件") + "\t\t\t"
                        + (rs[i].isFile()?(new BigDecimal((double)rs[i].length()/1024).divide
                        (new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP)):""));
            }
        }
    }
}
