/**
 * Created by james on 2016/4/4.
 */
public class GenericTest {

    public static void main(String[] agrs){
        Message<Integer> m1 = new Message<Integer>();
        m1.setX(10);
        fun(m1);
    }

    public static void fun(Message temp){
        temp.setX("hehe");
        System.out.println(temp.getX());
    }
}
 class Message<T>{
     private T x;
     private T y;

     public T getX() {
         return x;
     }
     public void setX(T x) {
         this.x = x;
     }

     public T getY() {
         return y;
     }
     public void setY(T y) {
         this.y = y;
     }

 }
