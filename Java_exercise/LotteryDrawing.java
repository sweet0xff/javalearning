import java.lang.reflect.Array;
import java.util.*;

/**
 * This program demonstrates array mainpulation.
 * source ：《Java核心技术》第一卷
 *
 * Created by Zeng Ge on 2016/3/22.
 */
public class LotteryDrawing {
   public static void main(String[] agrs){
      Scanner input = new Scanner(System.in);

      System.out.print("How many numbers do you want you draw ?");
      int k = input.nextInt();

      System.out.print("what is the highest number you can draw ?");
      int n = input.nextInt();

      //creat an arrary object;
      int[] numbers = new int[n];
      for(int i = 0; i < numbers.length; i ++) {
         numbers[i] = i +1;
      }

      //creat another arrary object;
      int[] result = new int[k];

      for(int i = 0; i <result.length; i ++) {
         //make a random index between 0 and n-1
         int r = (int)(Math.random() * n);
         result[i] = numbers[r];

         //be sure that we cann't choose a repeat one ,so move the last
         // element into the random location
         numbers[r] = numbers[n-1];
         n--;
      }

      //sort the arrary
      Arrays.sort(result);
      System.out.println("Haha ! Do you want to be rich ?");
      for (int r :result)
         System.out.println(r);

   }

}
