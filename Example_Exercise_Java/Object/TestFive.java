package Object;

/**
 * Object类可以接收任何类型对象的引用.
 * Created by zeng on 16-4-10.
 */
public class TestFive {
    public static void main(String[] args) {
        //Object类接收接口类型对象
        A  a = new B();  //接口对象.
        Object ob = a;   //接收接口对象.
        A m = (A)ob; //向下转型
        m.fun();

        B b = new B();  //接口对象
        Object obj = b ;  //Oject接收接口对象
        B n = (B)obj;    //向下转型
        n.fun();
    }
}

interface A{
    public void fun();
}
class B implements A{
    public void fun(){
        System.out.println("hello world");
    }
}
