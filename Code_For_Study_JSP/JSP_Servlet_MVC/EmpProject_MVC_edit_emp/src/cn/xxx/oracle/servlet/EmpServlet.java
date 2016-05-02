package cn.mldn.oracle.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.oracle.factory.ServiceBackFactory;
import cn.mldn.oracle.vo.Dept;
import cn.mldn.oracle.vo.Emp;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@SuppressWarnings("serial")
public class EmpServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = "/pages/errors.jsp";
		// 接收操作的方式代码
		String status = request.getParameter("status");
		SmartUpload smart = null; // 定义一个SmartUpload对象
		// 如果现在是上传的表单，那么表单一定要进行封装，而一旦封装之后无法利用request取得
		if (status == null) { // 现在无法取得status参数内容，假设是上传文件
			smart = new SmartUpload();
			smart.initialize(super.getServletConfig(), request, response);
			try {
				smart.upload();
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			status = smart.getRequest().getParameter("status");
		}
		if (!(status == null || "".equals(status))) { // 有参数
			if ("insert".equalsIgnoreCase(status)) {
				this.insert(request, response, smart);
			} else if ("insertPre".equalsIgnoreCase(status)) {
				this.insetPre(request, response);
			} else if ("update".equalsIgnoreCase(status)) {
				this.update(request, response, smart);
			} else if ("updatePre".equalsIgnoreCase(status)) {
				this.updatePre(request, response);
			} else if ("delete".equalsIgnoreCase(status)) {
				this.delete(request, response);
			} else if ("deleteBatch".equalsIgnoreCase(status)) {
				this.deleteBach(request, response);
			} else if ("list".equalsIgnoreCase(status)) {
				this.list(request, response);
			} else if ("listSplit".equalsIgnoreCase(status)) {
				this.listSplit(request, response);
			} else if ("listDetails".equalsIgnoreCase(status)) {
				this.listDetails(request, response);
			} else if ("show".equalsIgnoreCase(status)) {
				this.show(request, response);
			} else if ("listSal".equalsIgnoreCase(status)) {
				this.listSal(request, response);
			}
		} else { // 如果没参数直接跳转到errors.jsp页面
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void insetPre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Map<String, Object> map = ServiceBackFactory
					.getIEmpServiceBackInstance().insertPre();
			request.setAttribute("allDepts", map.get("allDepts"));
			request.setAttribute("allEmps", map.get("allEmps"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/back/admin/emp/emp_insert.jsp")
				.forward(request, response);
	}

	public void insert(HttpServletRequest request,
			HttpServletResponse response, SmartUpload smart)
			throws ServletException, IOException {
		Emp vo = new Emp();
		vo.setEmpno(Integer.parseInt(smart.getRequest().getParameter("empno")));
		vo.setEname(smart.getRequest().getParameter("ename"));
		vo.setJob(smart.getRequest().getParameter("job"));
		try {
			vo.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(smart
					.getRequest().getParameter("hiredate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vo.setSal(Double.parseDouble(smart.getRequest().getParameter("sal")));
		vo.setComm(Double.parseDouble(smart.getRequest().getParameter("comm")));

		int mgrno = Integer.parseInt(smart.getRequest().getParameter("mgr"));
		int deptno = Integer
				.parseInt(smart.getRequest().getParameter("deptno"));

		if (mgrno != 0) { // 有领导，需要配置领导关系，在DAO里面只找到领导编号
			Emp mgr = new Emp();
			mgr.setEmpno(mgrno); // 保存领导编号
			vo.setMgr(mgr); // 保存领导关系
		}
		if (deptno != 0) { // 有部门
			Dept dept = new Dept();
			dept.setDeptno(deptno);
			vo.setDept(dept); // 保存部门关系
		}

		vo.setNote(smart.getRequest().getParameter("note"));

		String photoName = "nophoto.jpg"; // 默然的图片名称
		if (smart.getFiles().getSize() > 0) { // 有图片上传
			photoName = java.util.UUID.randomUUID() + "."
					+ smart.getFiles().getFile(0).getFileExt(); // 生成图片名称
		}
		vo.setPhoto(photoName);
		String msg = "雇员信息添加失败！";
		try {
			if (ServiceBackFactory.getIEmpServiceBackInstance().insert(vo)) {
				if (smart.getFiles().getSize() > 0) { // 有图片上传
					String photoPath = this.getServletContext().getRealPath(
							"/photo")
							+ java.io.File.separator + photoName;
					smart.getFiles().getFile(0).saveAs(photoPath);
				}
				msg = "雇员信息添加成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("path", request.getContextPath()
				+ "/pages/back/admin/emp/EmpServlet?status=insertPre");
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}

	public void updatePre(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		try {
			Map<String, Object> map = ServiceBackFactory
					.getIEmpServiceBackInstance().updatePre(empno);
			request.setAttribute("allDepts", map.get("allDepts"));
			request.setAttribute("allEmps", map.get("allEmps"));
			request.setAttribute("emp", map.get("emp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/back/admin/emp/emp_update.jsp")
				.forward(request, response);
	}

	public void update(HttpServletRequest request,
			HttpServletResponse response, SmartUpload smart)
			throws ServletException, IOException {
		Emp vo = new Emp();
		vo.setEmpno(Integer.parseInt(smart.getRequest().getParameter("empno")));
		vo.setEname(smart.getRequest().getParameter("ename"));
		vo.setJob(smart.getRequest().getParameter("job"));
		try {
			vo.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(smart
					.getRequest().getParameter("hiredate")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		vo.setSal(Double.parseDouble(smart.getRequest().getParameter("sal")));
		vo.setComm(Double.parseDouble(smart.getRequest().getParameter("comm")));

		int mgrno = Integer.parseInt(smart.getRequest().getParameter("mgr"));
		int deptno = Integer
				.parseInt(smart.getRequest().getParameter("deptno"));

		if (mgrno != 0) { // 有领导，需要配置领导关系，在DAO里面只找到领导编号
			Emp mgr = new Emp();
			mgr.setEmpno(mgrno); // 保存领导编号
			vo.setMgr(mgr); // 保存领导关系
		}
		if (deptno != 0) { // 有部门
			Dept dept = new Dept();
			dept.setDeptno(deptno);
			vo.setDept(dept); // 保存部门关系
		}

		vo.setNote(smart.getRequest().getParameter("note"));
		String photo = smart.getRequest().getParameter("photo");
		if (smart.getFiles().getSize() > 0) { // 有图片上传
			if ("nophoto.jpg".equals(photo)) { // 原本没有图片名称
				photo = java.util.UUID.randomUUID() + "."
						+ smart.getFiles().getFile(0).getFileExt(); // 生成图片名称
			}
		}
		vo.setPhoto(photo);
		String msg = "雇员信息修改失败！";
		try {
			if (ServiceBackFactory.getIEmpServiceBackInstance().update(vo)) {
				if (smart.getFiles().getSize() > 0) { // 有图片上传
					String photoPath = this.getServletContext().getRealPath(
							"/photo")
							+ java.io.File.separator + photo;
					smart.getFiles().getFile(0).saveAs(photoPath);
				}
				msg = "雇员信息修改成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer buf = new StringBuffer();
		buf.append(smart.getRequest().getParameter("backUrl")).append("&");
		buf.append("cp=").append(smart.getRequest().getParameter("cp"))
				.append("&");
		buf.append("ls=").append(smart.getRequest().getParameter("ls"))
				.append("&");
		buf.append("col=").append(smart.getRequest().getParameter("col"))
				.append("&");
		buf.append("kw=").append(smart.getRequest().getParameter("kw"));
		request.setAttribute("msg", msg);
		request.setAttribute("path", buf);
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		String pic = request.getParameter("pic"); // 图片名称
		String msg = "雇员信息删除失败！";
		try {
			if (ServiceBackFactory.getIEmpServiceBackInstance().delete(empno)) {
				if (!"nophoto.jpg".equals(pic)) { // 不是nophoto.jpg
					String photoPath = this.getServletContext().getRealPath(
							"/photo")
							+ java.io.File.separator + pic;
					java.io.File file = new java.io.File(photoPath);
					if (file.exists()) { // 文件存在
						file.delete();
					}
				}
				msg = "雇员信息删除成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer buf = new StringBuffer();
		buf.append(request.getParameter("backUrl")).append("&");
		buf.append("cp=").append(request.getParameter("cp")).append("&");
		buf.append("ls=").append(request.getParameter("ls")).append("&");
		buf.append("col=").append(request.getParameter("col")).append("&");
		buf.append("kw=").append(request.getParameter("kw")).append("&");
		buf.append("deptno=").append(request.getParameter("deptno")).append("&") ;
		buf.append("sal=").append(request.getParameter("sal"));
		request.setAttribute("msg", msg);
		request.setAttribute("path", buf);
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}

	public void deleteBach(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String empno[] = request.getParameterValues("empno");
		Set<Integer> set = new HashSet<Integer>();
		List<String> all = new ArrayList<String>(); // 保存要删除的图片名称
		for (int x = 0; x < empno.length; x++) {
			String temp[] = empno[x].split("\\|");
			set.add(Integer.parseInt(temp[0]));
			if (!"nophoto.jpg".equals(temp[1])) { // 不是nophoto.jpg
				all.add(temp[1]); // 要删除的图片名称
			}
		}
		String msg = "雇员信息删除失败！";
		try {
			if (ServiceBackFactory.getIEmpServiceBackInstance()
					.deleteBatch(set)) {
				Iterator<String> iter = all.iterator();
				while (iter.hasNext()) {
					String photoPath = this.getServletContext().getRealPath(
							"/photo")
							+ java.io.File.separator + iter.next();
					java.io.File file = new java.io.File(photoPath);
					if (file.exists()) { // 文件存在
						file.delete();
					}
				}
				msg = "雇员信息删除成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer buf = new StringBuffer();
		buf.append(request.getParameter("backUrl")).append("&");
		buf.append("cp=").append(request.getParameter("cp")).append("&");
		buf.append("ls=").append(request.getParameter("ls")).append("&");
		buf.append("col=").append(request.getParameter("col")).append("&");
		buf.append("kw=").append(request.getParameter("kw"));
		request.setAttribute("msg", msg);
		request.setAttribute("path", buf);
		request.getRequestDispatcher("/pages/forward.jsp").forward(request,
				response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("allEmps", ServiceBackFactory
					.getIEmpServiceBackInstance().list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String backUrl = request.getContextPath()
				+ "/pages/back/admin/emp/EmpServlet?status=list";
		request.setAttribute("backUrl", backUrl);
		request.getRequestDispatcher("/pages/back/admin/emp/emp_list.jsp")
				.forward(request, response);
	}

	public void listSplit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1; // 保存当前所在页
		int lineSize = 5; // 每页显示的数据行
		String actionUrl = "EmpServlet"; // 参数的传递路径
		String columnData = "雇员编号:empno|雇员姓名:ename|雇员职位:job";
		String column = null; // 定义模糊查询的列
		String keyWord = null; // 定义模糊查询的关键字
		column = request.getParameter("col");
		keyWord = request.getParameter("kw");
		if (column == null || "".equals(column)) { // 没有内容
			column = "empno"; // 默认按照empno查询
		}
		if (keyWord == null || "".equals(keyWord)) {
			keyWord = ""; // 表示查询全部
		}
		if ("GET".equalsIgnoreCase(request.getMethod())) { // 判断请求方式
			keyWord = java.net.URLDecoder.decode(keyWord, "UTF-8");
		}
		try {
			currentPage = Integer.parseInt(request.getParameter("cp"));
		} catch (Exception e) {
		}
		try {
			lineSize = Integer.parseInt(request.getParameter("ls"));
		} catch (Exception e) {
		}
		String backUrl = request.getContextPath() + "/pages/back/admin/emp/"
				+ actionUrl + "?status=listSplit";
		try {
			Map<String, Object> map = ServiceBackFactory
					.getIEmpServiceBackInstance().list(column, keyWord,
							currentPage, lineSize);
			request.setAttribute("allEmps", map.get("allEmps"));
			request.setAttribute("allRecorders", map.get("empCount"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lineSize", lineSize);
		request.setAttribute("actionUrl", actionUrl);
		request.setAttribute("columnData", columnData);
		request.setAttribute("column", column);
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("status", "listSplit");
		request.setAttribute("backUrl", backUrl);
		request.getRequestDispatcher("/pages/back/admin/emp/emp_list_split.jsp")
				.forward(request, response);
	}

	public void listDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1; // 保存当前所在页
		int lineSize = 5; // 每页显示的数据行
		String actionUrl = "EmpServlet"; // 参数的传递路径
		String columnData = "雇员编号:empno|雇员姓名:ename|雇员职位:job";
		String column = null; // 定义模糊查询的列
		String keyWord = null; // 定义模糊查询的关键字
		column = request.getParameter("col");
		keyWord = request.getParameter("kw");
		if (column == null || "".equals(column)) { // 没有内容
			column = "empno"; // 默认按照empno查询
		}
		if (keyWord == null || "".equals(keyWord)) {
			keyWord = ""; // 表示查询全部
		}
		if ("GET".equalsIgnoreCase(request.getMethod())) { // 判断请求方式
			keyWord = java.net.URLDecoder.decode(keyWord, "UTF-8");
		}
		try {
			currentPage = Integer.parseInt(request.getParameter("cp"));
		} catch (Exception e) {
		}
		try {
			lineSize = Integer.parseInt(request.getParameter("ls"));
		} catch (Exception e) {
		}
		String backUrl = request.getContextPath() + "/pages/back/admin/emp/"
				+ actionUrl + "?status=listDetails";
		try {
			Map<String, Object> map = ServiceBackFactory
					.getIEmpServiceBackInstance().listDetails(column, keyWord,
							currentPage, lineSize);
			request.setAttribute("allEmps", map.get("allEmps"));
			request.setAttribute("allRecorders", map.get("empCount"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lineSize", lineSize);
		request.setAttribute("actionUrl", actionUrl);
		request.setAttribute("columnData", columnData);
		request.setAttribute("column", column);
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("status", "listDetails");
		request.setAttribute("backUrl", backUrl);
		request.getRequestDispatcher(
				"/pages/back/admin/emp/emp_list_details.jsp").forward(request,
				response);

	}

	public void show(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		try {
			request.setAttribute("emp", ServiceBackFactory
					.getIEmpServiceBackInstance().show(empno));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/back/admin/emp/emp_show.jsp")
				.forward(request, response);
	}

	public void listSal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionUrl = "EmpServlet"; // 参数的传递路径
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		double sal = Double.parseDouble(request.getParameter("sal"));
		try {
			request.setAttribute("allEmps", ServiceBackFactory
					.getIEmpServiceBackInstance().showBySal(deptno, sal));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String backUrl = request.getContextPath() + "/pages/back/admin/emp/"
				+ actionUrl + "?status=listSal&deptno=" + deptno + "&sal="
				+ sal;
		request.setAttribute("backUrl", backUrl);
		request.getRequestDispatcher("/pages/back/admin/emp/emp_sal_list.jsp").forward(request,
				response);
	}
}
