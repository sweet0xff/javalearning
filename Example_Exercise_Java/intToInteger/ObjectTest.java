package intToInteger;

/**
 * Object类可以接受一切引用数据类型.
 * 流程:先自动装箱成Integer类,再向上转型成Object类.
 * Created by Administrator on 2016/4/11.
 */
public class ObjectTest {

    public static void main(String[] args) {
        Object obj1 = 10; //先包装成Integer类,再向上转型成Object类
        //int temp = (int)obj1,是错误的写法,Object类不能直接转型成int这样的基本数据类型.
        int temp = (Integer) 10; //向下转型成Integer类

        System.out.println(temp *4);

//        Double obj2 = 10; 报错,要赋值成10.0

        Boolean hehe = true; //自动装箱
        if (hehe){  //直接拆箱,判断
            System.out.println("hello world");
        }
    }
}
