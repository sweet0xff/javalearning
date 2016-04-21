package org.xxx.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddCartServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		// 获取商品编号
		String gid = request.getParameter("gid");

		// 从请求中获取session会话对象
		HttpSession session = request.getSession();

		// 购物对象
		Map<String, Object> cartMap = null;

		// 先判断session中是否存在购物车对象
		if (session.getAttribute("cart") != null) {
			// 如果有购物车对象
			cartMap = (Map<String, Object>) session.getAttribute("cart");
			// 判断当前购物车中是否包含有该商品
			if (cartMap.containsKey(gid)) {
				// 如果有该商品，获取该商品的购买数量。然后加一
				// 当前商品的购买数量
				int count = (Integer) cartMap.get(gid);
				count++;
				// 更新购物车中的信息
				cartMap.put(gid, count);
			} else {
				// 没有当前商品
				// 将该商品添加到购物车中。并且该商品的购买数量为1
				cartMap.put(gid, 1);
			}
		} else {
			// 如果没有购物车对象
			// 创建一个购物车对象
			cartMap = new HashMap<String, Object>();
			// 将该商品添加到购物车中。并且该商品的购买数量为1
			cartMap.put(gid, 1);
		}
		// 将购物车放到 session会话中（更新购物车中的信息）
		session.setAttribute("cart", cartMap);
		response.sendRedirect("index.jsp");	
		
	}

}
