<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.oracle.vo.*"%>
<%@ page import="cn.mldn.oracle.util.*"%>
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
	Admin vo = new Admin() ;
	vo.setAid(request.getParameter("aid")) ;
	vo.setPassword(new MD5Code().getMD5ofStr(request
		.getParameter("password")
		+ "{"
		+ request.getParameter("aid") + "}"));
%>
<%
	String msg = "管理员信息增加失败！" ;
	if (ServiceBackFactory.getIAdminServiceBackInstance().insert(vo)) {
		msg = "管理员信息增加成功！" ;
	}
%>
<script type="text/javascript">
	alert("<%=msg%>") ;
	window.location = "<%=basePath%>/pages/back/admin/admin/admin_insert.jsp" ;
</script>
</body>
</html>
