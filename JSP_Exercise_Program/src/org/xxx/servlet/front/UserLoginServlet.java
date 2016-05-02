package org.xxx.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.xxx.model.entity.User;
import org.xxx.model.factory.ServiceFrontFactory;

@WebServlet({ "/MemberLoginServlet", "/memberlogin" })
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		String uaccount = request.getParameter("name");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		User vo = new User();
		vo.setUaccount(uaccount);
		vo.setUpassword(password);
		
		try {
			if(ServiceFrontFactory.getIUserServiceFrontInstance().login(vo)){
				session.setAttribute("message", "µÇÂ½³É¹¦!");
				session.setAttribute("uaccount", uaccount);
				response.sendRedirect("userindex.jsp");
			}else {
				session.setAttribute("message", "µÇÂ¼Ê§°Ü!");
				response.sendRedirect("errors.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
