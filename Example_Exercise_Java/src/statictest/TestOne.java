package statictest;

/**
 * 内存区一共有四个:栈内存,堆内存,全局数据区,全局代码区.static属性保存在全局数据区.
 * Created by Zeng on 2016/4/12.
 */
public class TestOne {
    public static void main(String[] args) {
        Book ba = new Book("Java开发", 100);
        Book bb = new Book("MySQL开发" ,88);
        Book bc = new Book("JSP开发" , 66);
        System.out.println(ba.getinfo());
        System.out.println(bb.getinfo());
        System.out.println(bc.getinfo());

        //如果String有static修饰,则三个对象的pub都会被修改 ,不需要实例化对象,直接由对象名.属性访问.
        //static属性虽然定义在类里面,但并不受类控制.
//        Book.pub = "机械工业出版社";

        ba.pub = "清华大学出版社";//如果没有static修修饰,则只会修改ba的pub值

        System.out.println(ba.getinfo());
        System.out.println(bb.getinfo());
        System.out.println(bc.getinfo());
    }
}
class Book{
    private String name ;
    private double price;

    String pub = "邮电出版社";
    //如果是String
    public Book(String name ,double price){
        this.name = name;
        this.price = price;
    }
    public String getinfo(){
        return "书名: " + name + " 价格: " + price + " 出版社 :" + pub;
    }
}

