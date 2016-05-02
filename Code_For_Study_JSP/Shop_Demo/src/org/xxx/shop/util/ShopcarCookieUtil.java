package cn.mldn.shop.util;

import cn.mldn.util.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShopcarCookieUtil {
    /**
     * @param request
     * @param response
     * @param gid
     * @param count
     */
    public static void addCar(HttpServletRequest request, HttpServletResponse response, int gid, int count) {
        CookieUtil.save(response, request, "sc-" + String.valueOf(gid), String.valueOf(count), 5000);
    }

    public static Map<Integer, Integer> loadCar(HttpServletRequest request) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        Map<String, String> map = CookieUtil.load(request);
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> me = iter.next();
            if (me.getKey().startsWith("sc-")) { // 判断是否是以‘sc-’开头
                result.put(Integer.parseInt(me.getKey().split("-")[1]), Integer.parseInt(me.getValue()));
            }
        }
        return result;
    }

    public static void removeCar(HttpServletResponse response, HttpServletRequest request, Set<Integer> ids) {
        Iterator<Integer> iter = ids.iterator();
        while (iter.hasNext()) {
            CookieUtil.save(response, request, "sc-" + String.valueOf(iter.next()), "0", 0);
        }
    }
    public static void clearCar(HttpServletRequest request,HttpServletResponse response){
        CookieUtil.clear(request,response);
    }
}
