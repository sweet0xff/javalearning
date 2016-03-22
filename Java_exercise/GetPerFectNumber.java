/**
 * 求100000以内的完备数.
 * The result is 6, 28 ,496, 8128.
 *
 * Created by Zeng Ge on 2016/3/22.
 */
public class GetPerFectNumber {
    public static void main(String[] agrs) {
        for(int i = 1; i <=100000; i ++) {
            int sum = 0;
            for(int j = 1 ; j <= i ; j ++){
                if(i % j == 0 ) {
                    sum += j;
                }
            }
            if(sum == 2 * i){
                System.out.println(i + " is a Perfect Number.");
            }
        }
    }
}
