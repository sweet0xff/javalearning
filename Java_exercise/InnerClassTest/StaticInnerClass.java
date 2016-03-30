/**
 * static inner class test.
 * Created by Zeng Ge on 2016/3/30.
 */
public class StaticInnerClass {

    public static void  main(String[] agrs){
        Outerclass.InnerStaticClass isc = new Outerclass.InnerStaticClass();
        isc.testMethod();
    }
}

class Outerclass{
    private static String  outClassStaticField = "外部类静态变量";
    private String outClassNormalField = "外部类普通变量";

    private static void outClassStaticMethod(){
        System.out.println("外部类静态方法");
    }

    private void outClassNormalMethod(){
        System.out.println("外部类普通方法");
    }

    static class InnerStaticClass{
        private static String  innerlassStaticField = "内部类静态变量";
        private String innerClassNormalField = "内部类普通变量";

        private static void innerClassStaticMethod(){
            System.out.println("内部类静态方法");
        }

        private void innerClassNormalMethod(){
            System.out.println("内部类普通方法");
        }
        public void testMethod(){
            System.out.println(outClassStaticField);
            //不能访问外部类的非静态变量
//            System.out.println(outClassNormalField);
        }

//            OuterClass.outClassStaticMethod();
//            OuterClass.outClassNormalMethod();

    }
}
