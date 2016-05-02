package org.xxx.servlet.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.xxx.model.entity.User;
import org.xxx.model.entity.UserJson;
import org.xxx.model.factory.ServiceBackFactory;

@WebServlet("/GetUserList")
public class GetUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetUserListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		List<User> ulist = new ArrayList<User>();
		
		try {
			//获取总用户数
			int count = ServiceBackFactory.getIUserServiceBackInstance().findAllCount();

			ulist =ServiceBackFactory.getIUserServiceBackInstance().findAll();
			
			UserJson ujson = new UserJson();
			ujson.setUlist(ulist);
			ujson.setMessageCode(200);
			ujson.setMessageInfo("success");
			ujson.setCount(count);
			//将对象转换成json对象
			JSONObject jsonObject = JSONObject.fromObject(ujson);
			
			out.println(jsonObject.toString());
			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
