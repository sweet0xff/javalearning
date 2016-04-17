package intToInteger;

/**
 * 输出结果为String version print.
 * 如果注释掉16,17,18行代码则会输出Object version print.
 * Created by Zeng on 2016/4/11.
 */

public class ObjectNullTest {
    public static void main(String[] args) {
        Test test = new Test();
        test.print(null);
    }
}
class Test{

    public void print(String some) {
        System.out.println("String version print");
    }

    public void print(Object some) {
        System.out.println("Object version print");
    }
}
