import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Date类的练习
 * Created by Zeng Ge on 2016/3/27.
 */
public class DateTest {

    public static void main(String [] agrs){
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String s1 = sdf1.format(d);
        System.out.println(s1);
        String s2 = sdf2.format(d);
        System.out.println(s2);
        String s3 = sdf3.format(d);
        System.out.println(s3);
    }
}
