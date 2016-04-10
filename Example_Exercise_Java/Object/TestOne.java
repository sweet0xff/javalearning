package Object;

import java.util.Objects;

/**
 * Object是所有类的父类.有一个无参构造方法.子类在实例化的时候都会默认调用这个无参的构造方法
 * Created by zeng on 16-4-10.
 */
public class TestOne {
    public static void main(String[] args) {
        Object oba = new HeHe(); //向上转型,实例化对象时默认调用父类无参构造方法
        Object obb = "hello ";

        HeHe obc = (HeHe)oba;
        String s = (String)obb;  //向下转型
    }
}

class HeHe extends Object {}
