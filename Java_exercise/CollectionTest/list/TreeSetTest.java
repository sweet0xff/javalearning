package list;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet练习，不重复，有序。
 * Created by james2 on 2016/4/4.
 */
public class TreeSetTest {

    public static void main(String[] agrs){
        Set<String> s2 = new TreeSet<String>();
        s2.add("hello");
        s2.add("world ");
        s2.add("hello");
        s2.add("java");
        System.out.println(s2);
    }

};
