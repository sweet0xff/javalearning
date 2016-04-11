package intToInteger;

/**
* 用String类提供的valueOf()方法将基本数据类型转字符串.
 * Created by Zeng on 2016/4/11.
 */
public class TestValueof {
    public static void main(String[] args) {
        int num = 10000;
        String s = num + "";  //一般不这么写,会产生垃圾问题.用ValueOf
        System.out.println(s.replaceAll("0","8"));//输出18888

        int num1 = 5555;
        String s1  = String.valueOf(num1);
        System.out.println(s1.replace("5","6"));//输出6666
    }
}
