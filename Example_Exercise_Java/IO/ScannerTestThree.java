package IO;

import java.util.Scanner;

/**
 *
 * Created by zeng on 16-4-9.
 */
public class ScannerTestThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入分数：");

       //也可以用正则表达式验证,sc.hasNext("\\d{1,4}-\\d{2}-\\d{2}")
        if (sc.hasNextDouble()) {  //hasNextDouble返回的就是Double 类型
            double score = sc.nextDouble();
            System.out.println("输入的数据是：" + score);
        } else {
            System.out.println("错误，输入的不是数字");
        }

        sc.close();

    }
}
