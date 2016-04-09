package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;

import static java.lang.System.in;

/**
 * 打印流,所有输出数据都可以用打印流完成
 * printf方法支持格式化输出
 * Created by zeng on 16-4-9.
 */
public class PrintStreamTest {
    public static void main(String[] args)throws Exception {
        File f = new File("/home/zeng/a/hehe.txt");
        OutputStream op = new FileOutputStream(f);
        PrintStream ps = new PrintStream(op);
/*
也可以这样写
PrintStream ps = new PrintStream(new FileOutputStream(new File("/home/zeng/a/hehe.txt"))) ;
*/

        ps.print("nihao");
        ps.println(1 + 1);
        ps.println(2.3);

        String name = "Jordan";
        int age = 16;
        double score = 59.4345645265;

        ps.printf("姓名: %s , 年龄：%d , 分数：%5.2f",name,age,score);

        //String也有一个format方法可以对要输出的内容进行格式化
        String s = String.format("姓名: %s , 年龄：%d , 分数：%5.2f",name,age,score);
        System.out.println(s);
    }
}
