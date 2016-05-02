<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
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
	Emp vo = new Emp() ;
	vo.setEmpno(Integer.parseInt(request.getParameter("empno"))) ;
	vo.setEname(request.getParameter("ename")) ;
	vo.setJob(request.getParameter("job")) ;
	vo.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"))) ;
	vo.setSal(Double.parseDouble(request.getParameter("sal"))) ;
	vo.setComm(Double.parseDouble(request.getParameter("comm"))) ;
	int mgrno = Integer.parseInt(request.getParameter("mgr")) ;
	int deptno = Integer.parseInt(request.getParameter("deptno")) ;
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
%>
<%
	String msg = "雇员信息修改失败！" ;
	if (ServiceBackFactory.getIEmpServiceBackInstance().update(vo)) {
		msg = "雇员信息修改成功！" ;
	}
	StringBuffer buf = new StringBuffer() ;
	buf.append(request.getParameter("backUrl")).append("?") ;
	buf.append("cp=").append(request.getParameter("cp")).append("&") ;
	buf.append("ls=").append(request.getParameter("ls")).append("&") ;
	buf.append("col=").append(request.getParameter("col")).append("&") ;
	buf.append("kw=").append(request.getParameter("kw"));
%>
<script type="text/javascript">
	alert("<%=msg%>") ;
	window.location = "<%=buf%>" ;
</script>
</body>
</html>
