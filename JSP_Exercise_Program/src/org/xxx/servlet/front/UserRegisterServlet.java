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

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String uname = request.getParameter("name");
		String uaccount= request.getParameter("account");
		String upassword = request.getParameter("password");
		
		User user = new User();
		user.setUname(uname);
		user.setUaccount(uaccount);
		user.setUpassword(upassword);
		
		try {
			if(ServiceFrontFactory.getIUserServiceFrontInstance().regist(user)){
				session.setAttribute("user", user);
				response.sendRedirect("forword.jsp");
				
			}else {
				session.setAttribute("message", "‘]É‘ ßî°,’à÷ÿ–¬‘]É‘");
				response.sendRedirect("errors.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
