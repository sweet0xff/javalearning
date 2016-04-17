package testequals;

/**
 * 对象比较的实现.
 * Created by Zeng on 2016/4/12.
 */
public class Test {
    public static void main(String[] args) {
        Bookbook b1 =new Bookbook("java",111);
        Bookbook b2 =new Bookbook("java",111);
        if(b1.compare(b2)){
            System.out.println("the same");
        }else {
            System.out.println("not the same");
        }


    }
}
class Bookbook{
    private String name;
    private double price;

    public Bookbook(String name , double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {

        return name;
    }


    public boolean compare(Bookbook book){
        if(this == book){
            return true;
        }
        if(book == null){
            return false;
        }
        if(this.name.equals(book.name) && this.getPrice() == book.getPrice()){
            return  true;
        }
        return false;

    }
}