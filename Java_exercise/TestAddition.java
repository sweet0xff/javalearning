/**
 * 此程序证明了对于浮点数，Java默认处理为double类型，而不是float类型.
 *
 * Created by Zeng Ge on 2016/3/24.
 */

public class TestAddition {

    public static void main(String[] args) {
        Addition a = new Addition ();

        System.out.println(a.addition(1,2));

        System.out.println(a.addition(3.0,4.0));//浮点数默认为double，会调用 double Addition（）函数

        //强制转换为float类型时，会调用float Addition（）函数
        //否则会报错，提示double转换为float类型会损失精度
        float x = (float)(5.0);
        float y = (float)(6.0);
        System.out.println(a.addition(x,y));

        System.out.println(a.addition("6","7"));
    }

}
class Addition {
    public int addition ( int a, int b) {
        return a + b;
    }

    public long addition ( long a, long b) {
        return a + b ;
    }

    public float addition ( float a, float b) {
        return a + b ;
    }

    public double addition (double a, double b) {
        return a + b + 1000 ;
    }

    public String addition ( String a, String b) {
        Integer ret = Integer.parseInt(a) + Integer.parseInt(b);//将字符串包装成整型类
        return ret.toString();
    }
}