import java.util.Scanner;

/**
 * 该程序模拟了一个简单的计算器，实现了加减乘除功能.
 * 并对构造方法进行了重载.
 *
 * Created by Zeng Ge on 2016/3/23.
 */
public class Construct {

    public static void main (String[] agrs) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number :");
        int a = input.nextInt();

        System.out.print("Please enter another number :");
        int b = input.nextInt();

        Number calu = new Number(a,b);
        System.out.println("和等于：" + calu.add());
        System.out.println("差等于：" +calu.subtration());
        System.out.println("积等于：" +calu.multiplication());
        System.out.println("除等于：" +calu.devision());
    }
}

class Number{
    int a = 0;
    int b = 0;
    Number(int a, int b){
        this.a = a;
        this.b = b;
    }

    public  int add() {
        return a + b ;
    }

    public  int subtration(){
        return a - b ;
    }

    public  int multiplication(){
        return a * b ;
    }

    public  int devision(){
        return a / b ;
    }
}
