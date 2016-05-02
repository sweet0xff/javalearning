<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.jspsmart.upload.*"%>
<%@ page import="cn.mldn.oracle.vo.*"%>
<%@ page import="cn.mldn.oracle.factory.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%	// 解决POST请求的乱码
	request.setCharacterEncoding("UTF-8") ;
%>
<html>
<head>
<title>雇员管理程序</title>
</head>

<body>
<%
	SmartUpload smart = new SmartUpload() ;
	smart.initialize(config, request, response) ;
	smart.upload() ;
%>
<%
	Emp vo = new Emp() ;
	vo.setEmpno(Integer.parseInt(smart.getRequest().getParameter("empno"))) ;
	vo.setEname(smart.getRequest().getParameter("ename")) ;
	vo.setJob(smart.getRequest().getParameter("job")) ;
	vo.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(smart.getRequest().getParameter("hiredate"))) ;
	vo.setSal(Double.parseDouble(smart.getRequest().getParameter("sal"))) ;
	vo.setComm(Double.parseDouble(smart.getRequest().getParameter("comm"))) ;
	
	int mgrno = Integer.parseInt(smart.getRequest().getParameter("mgr")) ;
	int deptno = Integer.parseInt(smart.getRequest().getParameter("deptno")) ;
	
	if (mgrno != 0) {	// 有领导，需要配置领导关系，在DAO里面只找到领导编号
		Emp mgr = new Emp() ;
		mgr.setEmpno(mgrno) ;	// 保存领导编号
		vo.setMgr(mgr) ;	// 保存领导关系 
	}
	if (deptno != 0) {	// 有部门
		Dept dept = new Dept() ;
		dept.setDeptno(deptno) ;
		vo.setDept(dept) ;	// 保存部门关系
	}
	
	vo.setNote(smart.getRequest().getParameter("note")) ;
	
	String photoName = "nophoto.jpg" ;	// 默然的图片名称
	if (smart.getFiles().getSize() > 0) {	// 有图片上传
		photoName = java.util.UUID.randomUUID() + "."
				+ smart.getFiles().getFile(0).getFileExt();	// 生成图片名称
	}
	vo.setPhoto(photoName) ;
%>
<%
	String msg = "雇员信息添加失败！" ;
	if (ServiceBackFactory.getIEmpServiceBackInstance().insert(vo)) {
		if (smart.getFiles().getSize() > 0) {	// 有图片上传 
			String photoPath = this.getServletContext().getRealPath(
					"/photo")
					+ java.io.File.separator + photoName;
			smart.getFiles().getFile(0).saveAs(photoPath) ;
		}
		msg = "雇员信息添加成功！";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>") ;
	window.location = "<%=basePath%>/pages/back/admin/emp/emp_insert.jsp" ;
</script>
</body>
</html>
