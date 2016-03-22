import java.util.*;

/**
 * 判断闰年
 *
 * Created by Zeng Ge on 2016/3/22.
 */
public class Testone {

    public static void main(String [] agrs) {
        Scanner input = new Scanner(System.in);//构造Scanner 对象
        System.out.print("Please enter a Number: ");
        int year = input.nextInt();//读取一个整数

        if (isLeapYear(year)) {
            System.out.print("It is 闰年。");
        }
        else {
            System.out.print("It is not 闰年。");
        }

    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
}