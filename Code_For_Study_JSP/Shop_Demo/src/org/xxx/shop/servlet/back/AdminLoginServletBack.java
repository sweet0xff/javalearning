package cn.mldn.shop.servlet.back;


import cn.mldn.shop.factory.ServiceBackFactory;
import cn.mldn.shop.factory.ServiceFrontFactory;
import cn.mldn.shop.vo.Admin;
import cn.mldn.util.BasePath;
import cn.mldn.util.MD5Code;
import cn.mldn.util.validate.ValidateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginServletBack", urlPatterns = "/pages/back/AdminLoginServletBack/*")
public class AdminLoginServletBack extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 程序错误跳转页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        if (status != "" || "".equals(status)) {
            if ("login".equals(status)) {
                path = this.login(request);
            } else if ("logout".equals(status)) {
                path = this.logout(request);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    public String login(HttpServletRequest request) {
        String msg = null;
        String url = null;
        String aid = request.getParameter("aid");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String rand = (String) request.getSession().getAttribute("rand");
        if (ValidateUtil.validatEmpty(aid) && ValidateUtil.validatEmpty(password) && ValidateUtil.validatEmpty(code) && ValidateUtil.validatEmpty(rand)) {
            if (ValidateUtil.validateRepeat(code, rand)) {
                Admin vo = new Admin();
                vo.setAid(aid);
                vo.setPassword(new MD5Code().getMD5ofStr(password));
                try {
                    if (ServiceBackFactory.getIAdminServiceBacktInstance().login(vo)) {
                        request.getSession().setAttribute("aid", aid);
                        request.getSession().setAttribute("lastdate", vo.getLastdate());
                        msg = "管理员登陆成功！";
                        url = "/pages/back/admin/index.jsp";
                    } else {
                        msg = "管理员登陆失败，错误的用户名或密码，请重新登陆！";
                        url = "/pages/back/login.jsp";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                msg = "验证码输入错误，请重新输入！";
                url = "/pages/back/login.jsp";
            }
        } else {
            msg = "管理员信息填写错误，请重新登陆！";
            url = "/pages/back/login.jsp";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String logout(HttpServletRequest request) {
        request.getSession().invalidate(); // 注销
        request.setAttribute("msg", "管理员注销成功！");
        request.setAttribute("url", "/pages/back/login.jsp");
        return "/pages/forward.jsp";
    }
}
