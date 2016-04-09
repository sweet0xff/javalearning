package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BufferedReader的正则表达式的使用
 * Created by zeng on 16-4-9.
 */
public class BufferedReaderTestTwo {
    public static void main(String[] args) throws Exception{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("请输入年龄：");
            String s = buf.readLine();

            if(s.matches("\\d{1,3}")){
                System.out.print("年龄是：" + Integer.parseInt(s));
                break;
            }else {
                System.out.println("年龄输入错误，应该由数字构成！");
            }
        }
        buf.close();
    }
}
