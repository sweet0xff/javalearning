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
		
		//��ȡ��ǰ�˵ĵ�¼����
		String username = request.getParameter("username");
		
		//���û����ŵ���ǰ�˵ĵ�¼�Ự��
		HttpSession session = request.getSession();
		session.setAttribute("username", username);	
		
		//���ڴ���û��ļ���
		List<String> ulist = null;
		
		//���Թ����������
		ServletContext application = this.getServletContext();
		
		//�������û���application����
		if(application.getAttribute("userlist") != null){
			ulist = (List<String>) application.getAttribute("userlist");
			ulist.add(username);
//			application.setAttribute("userlist", ulist);
		}else{
			//���application������
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
