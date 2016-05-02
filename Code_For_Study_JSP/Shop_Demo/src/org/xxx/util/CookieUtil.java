package cn.mldn.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CookieUtil {
    /**
     * 定义一个专门保存Cookie的方法，可以设置Cookie的保存名字与保存时间
     *
     * @param response 主要可以使用addCookie（）方法保存Cookie对象
     * @param request  主要设置Cookie保存路径
     * @param name     保存Cookie的名字
     * @param value    保存Cookie的内容
     * @param expiry   保存时间
     */
    public static void save(HttpServletResponse response, HttpServletRequest request, String name, String value, int expiry) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(expiry);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static Map<String, String> load(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Cookie c[] = request.getCookies();
        if (c != null) {
            for (int x = 0; x < c.length; x++) {
                if(!"JSESSIONID".equals(c[x].getName())) {
                    map.put(c[x].getName(), c[x].getValue());
                }
            }
        }
        return map;
    }

    // 清除Cookie
    public static void clear(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = load(request);
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> me = iter.next();
            Cookie c = new Cookie(me.getKey(), "");
            c.setPath("/");
            c.setMaxAge(0);
            response.addCookie(c);
        }
    }
}
