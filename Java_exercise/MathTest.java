import java.util.Scanner;
import java.lang.Math;

/**
 * Math类的练习，此程序实现了勾股定理.
 *
 * Created by Zeng Ge on 2016/3/24.
 */
public class MathTest {

    public static void main (String [] agrs){
        Scanner input = new Scanner(System.in);
        System.out.println("please enter a numer :");
        double a = input.nextInt();
        System.out.println("please enter another numer :");
        double b = input.nextInt();

        System.out.println(Math.sqrt(Math.pow(a,2) + Math.pow(b,2)));
    }
}
