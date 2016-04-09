package IO;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * scanner.useDelimiter(String pattern)设置分隔符.
 * Created by zeng on 16-4-9.
 */
public class ScannerTestTwo {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(new FileInputStream(new File("/home/zeng/a/hehe.txt")));

        //如果不设置分隔符，则会以空格和换行符作为分隔符.
        sc.useDelimiter("\n"); //设置换行符为分隔符.
        while (sc.hasNext()){
            System.out.println(sc.next());
        }
        sc.close();

    }
}
