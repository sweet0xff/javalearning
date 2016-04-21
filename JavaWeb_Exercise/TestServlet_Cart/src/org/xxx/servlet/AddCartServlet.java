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

		// ��ȡ��Ʒ���
		String gid = request.getParameter("gid");

		// �������л�ȡsession�Ự����
		HttpSession session = request.getSession();

		// �������
		Map<String, Object> cartMap = null;

		// ���ж�session���Ƿ���ڹ��ﳵ����
		if (session.getAttribute("cart") != null) {
			// ����й��ﳵ����
			cartMap = (Map<String, Object>) session.getAttribute("cart");
			// �жϵ�ǰ���ﳵ���Ƿ�����и���Ʒ
			if (cartMap.containsKey(gid)) {
				// ����и���Ʒ����ȡ����Ʒ�Ĺ���������Ȼ���һ
				// ��ǰ��Ʒ�Ĺ�������
				int count = (Integer) cartMap.get(gid);
				count++;
				// ���¹��ﳵ�е���Ϣ
				cartMap.put(gid, count);
			} else {
				// û�е�ǰ��Ʒ
				// ������Ʒ��ӵ����ﳵ�С����Ҹ���Ʒ�Ĺ�������Ϊ1
				cartMap.put(gid, 1);
			}
		} else {
			// ���û�й��ﳵ����
			// ����һ�����ﳵ����
			cartMap = new HashMap<String, Object>();
			// ������Ʒ��ӵ����ﳵ�С����Ҹ���Ʒ�Ĺ�������Ϊ1
			cartMap.put(gid, 1);
		}
		// �����ﳵ�ŵ� session�Ự�У����¹��ﳵ�е���Ϣ��
		session.setAttribute("cart", cartMap);
		response.sendRedirect("index.jsp");	
		
	}

}
