package cn.mldn.shop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MemberLoginFilter", urlPatterns = {"/pages/front/shopcar/*", "/pages/front/member/*","/pages/front/orders/*"})
public class MemberLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession ses = request.getSession();
        if (ses.getAttribute("mid") != null) { // 表示管理登录过
            chain.doFilter(req, resp);
        } else {
            request.setAttribute("msg", "你还未登录过，请登录后操作");
            request.setAttribute("url", "/pages/member_login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
