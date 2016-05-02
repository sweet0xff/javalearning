package cn.mldn.oracle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.oracle.factory.ServiceBackFactory;
import cn.mldn.oracle.util.MD5Code;
import cn.mldn.oracle.vo.Admin;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = "/pages/errors.jsp" ;	// 错误的跳转页
		String code = request.getParameter("code") ;
		String rand = (String) request.getSession().getAttribute("rand") ;
		if (!rand.equalsIgnoreCase(code)) {	// 不相等
			path = "/pages/back/login.jsp" ;
			request.setAttribute("err", "验证码输入错误！");
		} else {	// 如果输入的验证码正确，则继续向下判断
			Admin vo = new Admin() ;
			vo.setAid(request.getParameter("aid")) ;
			vo.setPassword(new MD5Code().getMD5ofStr(request
					.getParameter("password")
					+ "{"
					+ request.getParameter("aid") + "}"));
			try {
				if (ServiceBackFactory.getIAdminServiceBackInstance().login(vo)) {
					request.getSession().setAttribute("aid", vo.getAid()) ;
					// forward.jsp要进行提示的信息
					request.setAttribute("msg", "登录成功，欢迎：" + vo.getAid()
							+ "光临！");
					// 由forward.jsp提示信息之后的跳转路径
					request.setAttribute("path", request.getContextPath()
							+ "/pages/back/admin/index.jsp");	
					path = "/pages/forward.jsp" ;
				} else {
					path = "/pages/back/login.jsp" ;
					request.setAttribute("err", "错误的用户名及密码！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
