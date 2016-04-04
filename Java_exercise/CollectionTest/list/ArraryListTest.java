package list;

import java.util.*;

/**
 * list练习。有序，可重复。
 * Created by james on 2016/4/4.
 */
public class ArraryListTest {

    public static void main(String[] agrs){
        List<String> al = new ArrayList<String>();
        System.out.println("the size is " + al.size() + "   is empty ?" + al.isEmpty());
        al.add("hello");
        al.add("world");
        al.add("hello");
        al.add("java");
        System.out.println("the size is " + al.size() + "  is empty ?" + al.isEmpty());

        //List子接口扩充了一个get方法
        for(int i = 0 ; i <al.size(); i ++){
            String s= al.get(i);
            System.out.println(s);
        }
    }
}
