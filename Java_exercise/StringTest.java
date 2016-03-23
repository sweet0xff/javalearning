/**
 * String类的相关练习.
 *
 * Created by Zeng Ge on 2016/3/23.
 */
public class StringTest {

    public static void main(String[] agrs) {

        String s1 = "AAA";
        String s2 = "AAA";
        String s3 = new String("BBBB");
        String s4 = new String("BBBB");

        if(s1 == s2){
            System.out.println("s1和s2指向同一字符串。");//true
        }else{
            System.out.println("s1和s2不是指向同一字符串。");
        }

        if(s3 == s4){
            System.out.println("s3和s4指向同一字符串。");
        }else{
            System.out.println("s3和s4不是指向同一字符串。");//true
        }
    }
}
