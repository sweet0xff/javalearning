package org.xxx.servlet.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddGoodServlet")
public class AddGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddGoodServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String gid = request.getParameter("gid");
		
		Map<String, Object> cartMap =null;
		
		if(session.getAttribute("cart") != null){
			cartMap = (Map<String,Object>)session.getAttribute("cart");
			if(cartMap.containsKey(gid)){
				Integer count =0; 
				count = (Integer)cartMap.get(gid);
				count ++;
				cartMap.put(gid, 1);
			}else{
				cartMap.put(gid, 1);
			}
		}else{
			cartMap = new HashMap<String, Object>();
			cartMap.put(gid, 1);
		}

		session.setAttribute("cart", cartMap);
		response.sendRedirect("cartlist.jsp");
	}

}
