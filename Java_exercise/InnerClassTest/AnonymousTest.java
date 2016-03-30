import java.util.Date;
/**
 * Anonymous inner class test.
 * Created by Zeng Ge on 2016/3/30.
 */
public class AnonymousTest {

    public static void main(String[] agrs){
        Outclass4 test = new Outclass4();
        test.anonymousClassTest();
    }
}

class Outclass4{
    private static String a = "外部类静态变量";
    private  String b  = "外部类普通变量";

    private static void staticOuterMethod(){
        System.out.println("外部类静态方法");
    }

    private void normalOuterMethod(){
        System.out.println("外部类普通方法");
    }

    private void printDate(Date d){
        System.out.println(d.getTime());
    }

    public void anonymousClassTest(){
        printDate(new Date(){
            public long getTime() {
                System.out.println(a);
                System.out.println(b);
                staticOuterMethod();
                normalOuterMethod();

                return 1024;
            }
        });
    }

}
