package map;

import java.util.*;

/**
 * Created by james on 2016/4/4.
 */
public class MapTest {

    public static void main(String[] agrs){
        Map<String,Integer> map= new HashMap<String,Integer>();
        map.put("yi",1);
        map.put("er",2);
        map.put("san",3);
        map.put("san",223);
        map.put(null,53);
        System.out.println(map);
        System.out.println(map.get("yi"));
        System.out.println(map.get(null));
        System.out.println(map.get("hehe"));

        Set<String> s = map.keySet(); //获取全部的key.
        Iterator<String> iter =s.iterator();
        while (iter.hasNext()){
            String s1 = iter.next();
            System.out.println(s1);
        }
    }
}
