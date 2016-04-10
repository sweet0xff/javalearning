package Object;

/**
 *
 * Created by zeng on 16-4-10.
 */
public class Testequals {

    public static void main(String[] args) {
        Bookbook b = new  Bookbook("Java 核心技术",100.33);
        Bookbook c = new  Bookbook("Java 核心技术",100.33);
        System.out.println(b.equals(c));
        System.out.println(b.equals("hehe"));  //不是本类对象时返回false
        System.out.println(b);

    }
}

class Bookbook{
    private String name;
    private double price;
    public Bookbook(String name ,double price){
        this.name = name;
        this.price = price;
    }
    public String toString(){
        return "name = " + name + "\r\n" + "price = " + price;
    }
    public boolean equals(Object ob){  //参数是Object类型
        if(this == ob){   //比较地址是否相同.
            return true;
        }
        if(this == null){
            return false;
        }
        if(!(ob instanceof Bookbook)){  //判断是否是本类对象.
            return false;
        }
        Bookbook book = (Bookbook)ob;  //将Object类型向下转型成Bookbook
        if(this.name.equals(book.name)){
            return true;
        }
        return false;
    }
}