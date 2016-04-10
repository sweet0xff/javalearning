package Generic;

/**
 * 泛型方法.不一定非要定义在支持泛型的类里面.
 * Created by zeng on 16-4-10.
 */
public class GenericMethodTest {
    public static void main(String[] args) {
        String s = fun("hehe");
        System.out.println(s.length());
    }

    public static <T> T fun(T t){
        return t;
    }
}
