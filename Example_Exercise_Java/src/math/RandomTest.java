package math;

import java.util.Random;

/**
 * Created by Zeng on 2016/4/11.
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for(int i = 0 ; i < 10; i++){
            System.out.print(random.nextInt(100) + ","); //nextInt()设置边界值.100选不到.
        }
    }

}
