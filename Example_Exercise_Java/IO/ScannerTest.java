package IO;

import java.util.Scanner;

/**
 * Scanner专门负责处理输入流的操作.比BufferedReader类操作更加容易.
 * Created by zeng on 16-4-9.
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容：");
        if (sc.hasNext()){
            System.out.println("输入的内容是："+ sc.next());
        }
        sc.close();
    }
}
