package math;

import java.util.Random;

/**
 * Created by Zeng on 2016/4/11.
 */
public class RandomTestTwo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] data = new int[7];  //开辟一个7个元素的数组
        int foot = 0; //操作数组的脚标
        while (foot < 7){
            int t = random.nextInt(37); //生成一个不大于37的随机数
            if(!isRepeat(data,t)){  //判断是否重复.
                data[foot++] = t;
            }
        }

        java.util.Arrays.sort(data); //排序
        for(int i = 0; i <data.length;i ++){
            System.out.print(data[i] + ",");
        }

    };

    //实现一个36选7的功能.并且不能有0 和重复的值.

    /**
     * 此方法主要是判断是否有重复的内容 ,不允许保存0
     * @param temp 指的是已经保存的数据
     * @param num  指的是新生成的数据.
     * @return
     */
    public static boolean isRepeat(int[] temp , int num){
        if(num == 0){
            return true;  //如果是0 ,直接返回,后面的代码不执行
        }
        for(int i = 0; i<temp.length; i ++){
            if(temp[i] == num){  //如果生成的数已经存在于数组中,则表示重复数
                return true;
            }
        }
        return false;

    };
}
