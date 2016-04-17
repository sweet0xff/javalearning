package statictest;

/**
 * Created by Zeng on 2016/4/12.
 */
public class StaticMainMethod {
    public static void main(String[] args) {
        //fun()不是静态的,需要实例化对象就可以调用
        StaticMainMethod s = new StaticMainMethod();
        s.fun();

        staticfun();//可以直接调用静态方法.

    }
    public void fun(){
        System.out.println("hello world, I am a static method");
    }

    public static void staticfun(){
        System.out.println("hello world, I am a non-static method");
    }
}
