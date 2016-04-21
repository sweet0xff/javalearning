package org.xxx.servlet;

import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChatRoom extends HttpServlet {

	public ChatRoom() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		//获取当前人的登录名字
		String username = request.getParameter("username");
		
		//将用户名放到当前人的登录会话中
		HttpSession session = request.getSession();
		session.setAttribute("username", username);	
		
		//用于存放用户的集合
		List<String> ulist = null;
		
		//可以共享的作用域
		ServletContext application = this.getServletContext();
		
		//如果存放用户的application存在
		if(application.getAttribute("userlist") != null){
			ulist = (List<String>) application.getAttribute("userlist");
			ulist.add(username);
//			application.setAttribute("userlist", ulist);
		}else{
			//如果application不存在
			ulist =new ArrayList<String>();
			ulist.add(username);
		}
		application.setAttribute("userlist", ulist);
		System.out.print(ulist);
		response.sendRedirect("index.jsp");
		
		}
		
		


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
