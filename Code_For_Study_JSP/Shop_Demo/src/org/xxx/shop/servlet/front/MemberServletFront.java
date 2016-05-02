package cn.mldn.shop.servlet.front;


import cn.mldn.shop.factory.ServiceFrontFactory;
import cn.mldn.shop.vo.Member;
import cn.mldn.util.BasePath;
import cn.mldn.util.CookieUtil;
import cn.mldn.util.MD5Code;
import cn.mldn.util.validate.ValidateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "MemberServletFront", urlPatterns = "/pages/MemberServletFront/*")
public class MemberServletFront extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 程序错误跳转页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        if (status != null || "".equals(status)) {
            if ("regist".equals(status)) {
                path = this.regist(request);
            } else if ("active".equals(status)) {
                path = this.active(request);
            } else if ("login".equals(status)) {
                path = this.login(request, response);
            } else if ("logout".equals(status)) {
                path = this.logout(request, response);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }


    public String logout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.clear(request, response);
        request.getSession().invalidate();
        request.setAttribute("msg", "你已经安全退出！");
        request.setAttribute("url", "/index.jsp");
        return "/pages/forward.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) {
        String msg = null;
        String url = null;
        String mid = request.getParameter("mid");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String rand = (String) request.getSession().getAttribute("rand");
        if (ValidateUtil.validatEmpty(mid) && ValidateUtil.validatEmpty(password) && ValidateUtil.validatEmpty(code) && ValidateUtil.validatEmpty(rand)) {
            if (ValidateUtil.validateRepeat(code, rand)) {
                Member vo = new Member();
                vo.setMid(mid);
                vo.setPassword(new MD5Code().getMD5ofStr(password));
                try {
                    if (ServiceFrontFactory.getIMemberServiceFrontInstance().login(vo)) {
                        request.getSession().setAttribute("mid", mid);
                        request.getSession().setAttribute("photo", vo.getPhoto());
                        msg = "登录成功！";
                        url = "/index.jsp";
                        if (request.getParameter("reme") != null) { // 表示选择了复选框
                            int expiry = Integer.parseInt(request.getParameter("reme"));
                            CookieUtil.save(response, request, "mid", vo.getMid(), expiry);
                            CookieUtil.save(response, request, "password", vo.getPassword(), expiry);
                        }
                    } else {
                        msg = "登录失败，错误的用户名或密码！";
                        url = "/pages/member_login.jsp";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                msg = "验证码输入错误！";
                url = "/pages/member_login.jsp";
            }
        } else {
            msg = "信息输入错误，请重新登录！";
            url = "/pages/member_login.jsp";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String active(HttpServletRequest request) {
        String msg = null;
        String url = null;
        String mid = request.getParameter("mid");
        String code = request.getParameter("code");
        if (ValidateUtil.validatEmpty(mid) && ValidateUtil.validatEmpty(code)) {
            Member vo = new Member();
            vo.setMid(mid);
            vo.setCode(code);
            try {
                if (ServiceFrontFactory.getIMemberServiceFrontInstance().active(vo)) {
                    msg = "恭喜你，你的账号已经激活成功，可以正常登录系统！";
                    url = "/pages/member_login.jsp";
                } else {
                    msg = "激活失败，请与管理员联系！";
                    url = "/index.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "错误的激活操作，请与管理员联系";
            url = "/index.jsp";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String regist(HttpServletRequest request) {
        String msg = null;
        String url = null;
        // 接受页面传递来的参数
        String mid = request.getParameter("mid");
        String password = request.getParameter("password");
        // 服务器端验证
        if (ValidateUtil.validatEmpty(mid) && ValidateUtil.validatEmpty(password)) {
            Member vo = new Member(); // 要将数据封装到VO类对象里
            vo.setMid(mid);
            vo.setPassword(new MD5Code().getMD5ofStr(password));
            vo.setRegdate(new Date());// 用户注册日期
            vo.setPhoto("nophoto.gif");
            vo.setCode(UUID.randomUUID().toString().replace("-", "")); // 生成一个随机激活码
            vo.setStatus(2); // 用户属于未激活状态
            try {
                if (ServiceFrontFactory.getIMemberServiceFrontInstance().regist(vo)) {
                    msg = "用户注册成功，请激活后登录！";
                    url = "/index.jsp";
                    System.out.println("【发激活邮件】" + BasePath.getBasePath(request) + "/pages/MemberServletFront/active?mid=" + vo.getMid() + "&code=" + vo.getCode());
                } else {
                    msg = "用户注册失败，请重新输入注册信息";
                    url = BasePath.getBasePath(request) + "/pages/member_regist.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else { // 服务器端验证不通过提示信息和跳转路径
            msg = "用户注册失败，请重新输入注册信息";
            url = BasePath.getBasePath(request) + "/pages/member_regist.jsp";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }
}
