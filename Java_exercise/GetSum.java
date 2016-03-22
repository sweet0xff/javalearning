/**
 *  求1+2！+3！+...+15!的和.
 *  The result is 1401602636313.
 *
 * Created by  Zeng Ge on 2016/3/22.
 */
public class GetSum {

    public static void main(String [] agrs){
        long totalsum = 0L;
        for(int j = 1; j <= 15; j++){
           long sum = 1L;
           for(int k = j; k >= 1; k --) {
              sum = sum * k;
//              System.out.println(totalsum);
           }
           totalsum = totalsum + sum;
        }
        System.out.println(totalsum);
    }
}
