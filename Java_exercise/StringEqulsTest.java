/**
 * Created by Zeng Ge on 2016/3/27.
 */
public class StringEqulsTest {

    public static void main(String[] agrs){
        String s1 = "hello world";
        String s2 = "hello world";

        String s3 = new String("love u");
        String s4 = new String("love u");
        System.out.println("s1 s2有相同的内存地址吗" + (s1 == s2));
        System.out.println("s3 s4有相同的内存地址吗" + (s3 == s4));
    }
}
