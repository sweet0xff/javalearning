package org.xxx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.SimpleAttributeSet;

public class MessageList extends HttpServlet {

	public MessageList() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 	 {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		//获取当前session对象,并且获取当前登录人的名字
		HttpSession session = request.getSession();
		
		//获取当前application对象
		ServletContext application = this.getServletContext();
		
		//当前登录人
		String username = (String)session.getAttribute("username");
		
		//发送的内容
		String message =(String) request.getParameter("messsage");
		
		//获取时间
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		String sendMessage = username + "say: " + message + date;
		
		List<String> messageList = null;
		
		if(application.getAttribute("MSG") != null){
			messageList= (List<String>)application.getAttribute("MSG");
			messageList.add(sendMessage);
		}else{
			messageList = new ArrayList<String>();
			messageList.add(sendMessage);
		}
		application.setAttribute("MSG", messageList);
		response.sendRedirect("sendmsg.jsp");
		

	}


}
