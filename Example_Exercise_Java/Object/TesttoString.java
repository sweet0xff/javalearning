package Object;

/**
 *
 * Created by zeng on 16-4-10.
 */
public class TesttoString {

    public static void main(String[] args) {
//        He he = new He();
//        String s = "hello ";
//        System.out.println(s);
//        System.out.println(he.toString());
//        System.out.print(he);  //自动调用toString方法.
        Book b = new  Book("Java 核心技术",100.33);
        System.out.println(b);

    }
}

//class He{}
class Book{
    private String name;
    private double price;
    public Book(String name ,double price){
        this.name = name;
        this.price = price;
    }
    public String toString(){
        return "name = " + name + "\r\n" + "price = " + price;
    }
}
