/**
 * ArithmeticException test.
 * Created by Zeng Ge on 2016/3/30.
 */
public class ArithmeticException {

    public static void main(String[] main) {
        int a = 10;
        int b = a / 0;
        try {
            System.out.print(b);
        } catch (java.lang.ArithmeticException e) {
            e.printStackTrace();

        }
    }
}

