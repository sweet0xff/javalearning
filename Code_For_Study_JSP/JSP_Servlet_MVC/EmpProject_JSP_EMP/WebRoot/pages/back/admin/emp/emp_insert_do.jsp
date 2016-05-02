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
%>
<%
	String msg = "雇员信息添加失败！" ;
	if (ServiceBackFactory.getIEmpServiceBackInstance().insert(vo)) {
		msg = "雇员信息添加成功！" ;
	}
%>
<script type="text/javascript">
	alert("<%=msg%>") ;
	window.location = "<%=basePath%>/pages/back/admin/emp/emp_list.jsp" ;
</script>
</body>
</html>
