package datetest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date类的练习.
 * Created by Administrator on 2016/4/13.
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sdate.format(date));

        long s = System.currentTimeMillis();
        System.out.println(s);


        Date date1 = new Date(s);  //Date类构造方法返回Date型变量,接受一个long型.
        System.out.println(date1.getTime()); //getTime()返回long型


    }
}

