package intToInteger;

/**
 * 基本数据类型的动装箱和拆箱实现.
 * 对象型包装类:Character ,Boolean
 * 数值型包装类:Integer,Byte,Double,Short,Long,Float.都是Number类的子类.
 * Number是一个抽象类,定义了六个方法, intValue(),doubleValue(),floatValue(),byteValue(),shotValue(),longValue().
 * Created by Zeng on 2016/4/11.
 */
public class intToIntegerTest {
    public static void main(String[] args) {
        MyInt hehe = new MyInt(10); //将int包装成类
        int temp = hehe.intValue();
        System.out.println(temp*5);
        //System.out.println(hehe*5)是错误的写法.
    }
}

class MyInt{
    private int num ;  // 这个类包装的基本数据类型.

    public MyInt(int num){ //构造的目的是为了将基本数据类型传递给对象
        this.num = num;
    }

    public int intValue(){ //将包装的数据内容返回.拆箱.
        return this.num;
    }

}
