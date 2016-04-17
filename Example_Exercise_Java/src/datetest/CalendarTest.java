package datetest;

import java.util.Calendar;

/**
 * Calendar是一个抽象类,有一个静态方法返回Calendar类型对象. 所以不需要实例化.
 * Created by Zeng on 2016/4/13.
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();  //取得本类对象.
        StringBuffer stringBuffer= new StringBuffer();
        stringBuffer.append(calendar.get(Calendar.YEAR)).append("-");
        stringBuffer.append(calendar.get(Calendar.MONTH)+1).append("-");
        stringBuffer.append(calendar.get(Calendar.DAY_OF_MONTH)).append(" ");
        stringBuffer.append(calendar.get(Calendar.HOUR_OF_DAY)).append(":");
        stringBuffer.append(calendar.get(Calendar.MINUTE)).append(":");
        stringBuffer.append(calendar.get(Calendar.SECOND));
        System.out.println(stringBuffer);
        System.out.c

    }
}
