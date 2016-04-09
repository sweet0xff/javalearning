package IO;

import java.io.OutputStream;

/**
 * System.out实现简单的输出,System.out返回的是OutputStream 类型的方法
 * System.out是由系统默认提供好的实例化对象
 * Created by zeng on 16-4-9.
 */
public class SystemOutTest {
    public static void main(String[] args)throws Exception {
        OutputStream out = System.out;
        out.write("hello world".getBytes()); //能根据传进去的子类的不同而输出
    }
}
