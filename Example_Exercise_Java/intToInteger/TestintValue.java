package intToInteger;

import java.util.DoubleSummaryStatistics;

/**
 * 基本数据类型的自动装箱和自动拆箱.
 * 对象型包装类:Character ,Boolean
 * 数值型包装类:Integer,Byte,Double,Short,Long,Float.都是Number类的子类.
 * Number是一个抽象类,定义了六个方法, intValue(),doubleValue(),floatValue(),byteValue(),shotValue(),longValue().
 * 每个包装类都可以接受各自的数据类型的变量,实现装箱, 上面六个方法实现拆箱操作.
 * Created by Zeng on 2016/4/11.
 */
public class TestintValue {
    public static void main(String[] args) {

        Integer m4 = 10; //自动装箱
        int temp = m4;     //自动拆箱
        m4 ++;
        System.out.println(m4 * temp); //110

        Integer m6 = 10; //自动装箱
        Integer m7 = 10; //自动装箱
        Integer m8 = new Integer(10); //用构造方法实现装箱
        System.out.println(m6 == m7); //true
        System.out.println(m6 == m8); //false
        System.out.println(m7 == m8);//false

        //上述两种不同装箱实现要比较需要用equals方法.
        System.out.println(m6.equals(m8)); //ture
        System.out.println(m7.equals(m8)); //ture

        Integer m = new Integer(10);
        System.out.println(m.intValue());

        Double m2 = new Double(10.2);
        System.out.println(m2.doubleValue());

        Boolean m3 = new Boolean(true);
        System.out.println(m3.booleanValue());

    }
}
