/**
 * merber inner class test.
 * Created by Zeng Ge on 2016/3/30.
 */
public class MerberInnerCalss {

    public static void main(String [] agrs){
        OuterClass.InnerClass ic = new OuterClass().new InnerClass();
        ic.innerMethod();
    }
}
class OuterClass{
    private static String outerClassStaticField= "外部类的静态变量";
    private String outerClassField = "外部类的普通变量";

    private static void staticMethod(){
        System.out.println("外部类的静态方法");
    }

    private  void nomalMethod(){
        System.out.println("外部类的普通方法");
    }

    //成员内部类
    class InnerClass{
        //private static String s1 = "内部类不能有静态的变量";

        private String nomalField = "内部类普通变量";

//        private static void nomalMethod(){
//            System.out.print("内部类不能有静态的方法");
//        }

        private void nomalMethod(){
            System.out.println("内部类的普通方法");
        }

        public void innerMethod(){
            System.out.println(OuterClass.this.outerClassStaticField);
            System.out.println(OuterClass.this.outerClassField);
            OuterClass.this.staticMethod();
            OuterClass.this.nomalMethod();
            System.out.println(nomalField);
            nomalMethod();
        }
    }
}
