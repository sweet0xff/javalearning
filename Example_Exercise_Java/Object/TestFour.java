package Object;

/**
 * Object 可以接收任何类型对象的引用.
 * Created by zeng on 16-4-10.
 */
public class TestFour {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        Object ob = a;   //接收数组对象
        if((ob instanceof int[])){  //是否是int[]类型
            int[] data = (int[])ob; //向下转型.

            for(int i = 0; i < data.length; i ++){
                System.out.println(data[i]);
            }
        }
    }
}

