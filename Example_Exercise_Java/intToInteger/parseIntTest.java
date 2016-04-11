package intToInteger;

/**
 * 用包装类提供的parseXXX()方法将字符串转基本数据类型.
 * Integer类:public staic int parseInt(String s)
 * Double类:public static double parseDouble(String s)
 * Boolean类:public static boolean parseBoolean(String s)
 *
 * Created by Zeng on 2016/4/11.
 */
public class parseIntTest {

    public static void main(String[] args) {
        String s = "222";
        //"332aad"是错误的写法,不能包含数字,会报错java.lang.NumberFormatException
        int temp = Integer.parseInt(s);
        System.out.println(temp * 2);

//        String s3 = "2.22";
//        int temp3 = Integer.parseInt(s3);   会报错,NumberFormatException
//        System.out.println(s3);

        String s1 = "666";
        double temp1 = Double.parseDouble(s1);
        System.out.println(temp1);

        String s4 = "true";//"tureadlglkaj" 不满足条件.
        boolean temp4 = Boolean.parseBoolean(s4);
        if(temp4){
            System.out.println("满足条件");
        }else {
            System.out.println("不满足条件");
        }
    }
}
