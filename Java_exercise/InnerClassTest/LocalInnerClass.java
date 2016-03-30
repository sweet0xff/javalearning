/**
 * local inner class test.
 * Created by Zeng Ge  on 2016/3/30.
 */
public class LocalInnerClass {

    public static void main(String[] agrs){
        OuterClass1 A = new OuterClass1();
        A.LocalInnerClassMethod();
    }
}

class OuterClass1{
    private static String  outClassStaticField = "外部类静态变量";
    private String outClassNormalField = "外部类普通变量";

    private static void outClassStaticMethod(){
        System.out.println("外部类静态方法");
    }

    private void outClassNormalMethod(){
        System.out.println("外部类普通方法");
    }

    public void LocalInnerClassMethod(){
        String localField = "局部变量";
        final String localFieldFinal = "局部变量final";
        class LocalInnerClass{
            public void localClassMethod(){
                //不能访问非final变量
                //System.out.println("localField");
                System.out.println(localFieldFinal);
                System.out.println(outClassStaticField);
                System.out.println(outClassNormalField);
                outClassStaticMethod();
                outClassNormalMethod();
            }
        }
        LocalInnerClass  lic = new LocalInnerClass();
        lic.localClassMethod();
    }
}
