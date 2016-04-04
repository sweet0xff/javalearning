package list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set 练习，无序，不重复.
 * Created by Zeng Ge on 2016/4/4.
 */
public class HashSetTest {

    public static void main(String[] agrs){
        Set<String> s = new HashSet<>();
        s.add("hello");
        s.add("world ");
        s.add("hello");
        s.add("java");
//        System.out.println(s);
        Iterator<String> iter = s.iterator();
        while (iter.hasNext()){
            String string = iter.next();
        System.out.println(string);

        }
    }
}
