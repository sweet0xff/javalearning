package org.xxx.servlet.back;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xxx.model.entity.Admin;
import org.xxx.model.factory.ServiceBackFactory;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String aname = request.getParameter("mid");
		String apassword = request.getParameter("password");

		Admin admin = new Admin();
		admin.setAname(aname);
		admin.setApassword(apassword);

		HttpSession session = request.getSession();

		try {
			if (ServiceBackFactory.getIAminServiceInstance().login(admin)) {
				session.setAttribute("admin", admin);
				response.sendRedirect("adminindex.jsp");
			} else {
				session.setAttribute("mssage", "µÇÂ¼Ê§°Ü,ÇëÖØÐÂµÇÂ¼");
				response.sendRedirect("adminlogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
