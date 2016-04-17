package math;

/**
 * Math类里面提供的方法都是static型的.Math没有普通属性.
 * Created by Zeng on 2016/4/11.
 */
public class roundTest {
    public static void main(String[] args) {
        System.out.println(Math.round(16.5)); //17
        System.out.println(Math.round(16.4)); //16
        System.out.println(Math.round(-16.5)); //注意这个是 -16
        System.out.println(Math.round(-16.51)); //-17
        System.out.println(Math.round(-16.4)); //-16
    }
}
