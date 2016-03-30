/**
 * NumberFormatException test.
 * Created by Zeng Ge on 2016/3/30.
 */
public class ExceptionTest {

    public static void main(String[] agrs){
        test();
    }

    public static void test(){
        try{
            String s = "hehe";
            int num = Integer.parseInt(s);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

    }
}
