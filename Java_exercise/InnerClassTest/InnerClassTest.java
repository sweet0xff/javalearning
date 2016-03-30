/**
 * Anonymous Inner Class test.
 * Created by Zeng Ge on 2016/3/30.
 */

interface Inter {
    public void show();
};

class Outer {
    public static Inter method(){
        return new Inter(){
            public void show(){
                System.out.print("hehe,还行");
            }
        };
    };
};


public class InnerClassTest {

    public static void main(String[] agrs){
        Outer outer= new Outer();
        outer.method().show();
    }
}
