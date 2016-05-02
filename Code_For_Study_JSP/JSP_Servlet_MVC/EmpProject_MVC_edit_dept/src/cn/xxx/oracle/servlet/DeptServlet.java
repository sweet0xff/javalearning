package cn.mldn.oracle.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.oracle.factory.ServiceBackFactory;
import cn.mldn.oracle.vo.Dept;

@SuppressWarnings("serial")
public class DeptServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = "/pages/errors.jsp";
		// 接收操作的方式代码
		String status = request.getParameter("status");
		if (!(status == null || "".equals(status))) { // 有参数
			if ("insert".equalsIgnoreCase(status)) {
				this.insert(request, response);// 执行增加操作
			} else if ("update".equalsIgnoreCase(status)) {
				this.update(request,response) ;// 执行修改操作
			} else if ("delete".equalsIgnoreCase(status)) {
				this.delete(request, response);// 执行删除操作
			} else if ("deleteBatch".equalsIgnoreCase(status)) {
				this.deleteBatch(request, response);// 执行批量删除操作
			} else if ("list".equalsIgnoreCase(status)) {
				this.list(request, response);// 执行列表操作
			} else if ("listDetails".equalsIgnoreCase(status)) {
				this.listDetails(request, response);// 执行详细列表操作
			} else if ("show".equalsIgnoreCase(status)) {
				this.show(request, response);// 执行查看部门信息操作
			}
		} else { // 如果没参数直接跳转到errors.jsp页面
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void deleteBatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptno [] = request.getParameterValues("deptno") ;
		Set<Integer> set = new HashSet<Integer>() ;
		for (int x = 0 ; x < deptno.length ; x ++) {
			set.add(Integer.parseInt(deptno[x])) ;
		}
		String msg = "部门信息删除失败！" ;
		try {
			if (ServiceBackFactory.getIDeptServiceBackInstance().deleteBatch(set)) {
				msg = "部门信息删除成功！" ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("path", request.getParameter("backUrl"));
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}
	public void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = 1 ;	// 保存当前所在页
		int lineSize = 5 ;		// 每页显示的数据行
		String actionUrl = "DeptServlet" ;	// 参数的传递路径
		String columnData = "雇员编号:empno|雇员姓名:ename|雇员职位:job" ;
		String column = null ;	// 定义模糊查询的列
		String keyWord = null ;	// 定义模糊查询的关键字
		column = request.getParameter("col") ;
		keyWord = request.getParameter("kw") ;
		if (column == null || "".equals(column)) {	// 没有内容
			column = "empno" ;	// 默认按照empno查询
		}
		if (keyWord == null || "".equals(keyWord)) {
			keyWord = "" ;	// 表示查询全部
		}
		if("GET".equalsIgnoreCase(request.getMethod())) {	// 判断请求方式
			keyWord = java.net.URLDecoder.decode(keyWord, "UTF-8") ;
		}
		try {
			currentPage = Integer.parseInt(request.getParameter("cp")) ;
		} catch (Exception e) {}
		try {
			lineSize = Integer.parseInt(request.getParameter("ls")) ;
		} catch (Exception e) {}
		int deptno = Integer.parseInt(request.getParameter("deptno")) ;
		
		try {
			Dept dept = ServiceBackFactory.getIDeptServiceBackInstance().show(column,keyWord,currentPage,lineSize,deptno) ;
			request.setAttribute("dept", dept);
			request.setAttribute("allEmps", dept.getEmps());
			request.setAttribute("allRecorders", dept.getStat().get("count"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lineSize", lineSize);
		request.setAttribute("actionUrl", actionUrl);
		request.setAttribute("columnData", columnData);
		request.setAttribute("column", column);
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("status", "show");
		String backUrl = request.getContextPath() + "/pages/back/admin/emp/" + actionUrl ;
		request.setAttribute("backUrl", backUrl);
		request.getRequestDispatcher("/pages/back/admin/dept/dept_show.jsp").forward(request,
				response);
	}
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno")) ;	// 先取得deptno数据
		Dept vo = new Dept() ;
		vo.setDeptno(deptno) ;
		vo.setDname(request.getParameter("dname-" + deptno)) ;
		vo.setLoc(request.getParameter("loc-" + deptno)) ;
		String msg = "部门信息修改失败！" ;
		try {
			if (ServiceBackFactory.getIDeptServiceBackInstance().update(vo)) {
				msg = "部门信息修改成功！" ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("path", request.getContextPath()
				+ "/pages/back/admin/dept/DeptServlet?status=list");
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}
	public void listDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("allDepts", ServiceBackFactory
					.getIDeptServiceBackInstance().listDetails());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/back/admin/dept/dept_list_details.jsp")
				.forward(request, response);
	} 
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno")) ;
		String msg = "部门信息删除失败！" ;
		try {
			if (ServiceBackFactory.getIDeptServiceBackInstance().delete(deptno)) {
				msg = "部门信息删除成功！" ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("path", request.getContextPath()
				+ "/pages/back/admin/dept/DeptServlet?status=list");
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("allDepts", ServiceBackFactory
					.getIDeptServiceBackInstance().list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/back/admin/dept/dept_list.jsp")
				.forward(request, response);
	}

	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno")); // 先取得deptno数据
		Dept vo = new Dept();
		vo.setDeptno(deptno);
		vo.setDname(request.getParameter("dname"));
		vo.setLoc(request.getParameter("loc"));
		String msg = "部门信息增加失败！";
		try {
			if (ServiceBackFactory.getIDeptServiceBackInstance().insert(vo)) {
				msg = "部门信息增加成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("path", request.getContextPath()
				+ "/pages/back/admin/dept/dept_insert.jsp");
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}
}
