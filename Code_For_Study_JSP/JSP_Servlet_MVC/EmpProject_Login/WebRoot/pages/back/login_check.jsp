<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.oracle.vo.*"%>
<%@ page import="cn.mldn.oracle.factory.*"%>
<%@ page import="cn.mldn.oracle.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	// 解决POST请求的乱码
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<title>雇员管理程序</title>
</head>
<body>
<% 
	String code = request.getParameter("code") ;
	String rand = (String) session.getAttribute("rand") ;
	if (!rand.equalsIgnoreCase(code)) {	// 不相等
%>
		<jsp:forward page="login.jsp">
			<jsp:param name="errmsg" value="验证码输入错误！"/>
		</jsp:forward>
<%
	}
	Admin vo = new Admin() ;
	vo.setAid(request.getParameter("aid")) ;
	vo.setPassword(new MD5Code().getMD5ofStr(request
			.getParameter("password")
			+ "{"
			+ request.getParameter("aid") + "}"));
	if (ServiceBackFactory.getIAdminServiceBackInstance().login(vo)) {
		session.setAttribute("aid", vo.getAid()) ;
%>
		<script type="text/javascript">
			alert("登录成功，欢迎：<%=vo.getAid()%>光临！") ;
			window.location = "<%=basePath%>/pages/back/admin/index.jsp" ;
		</script>
<%
	} else {
%>
		<jsp:forward page="login.jsp">
			<jsp:param name="errmsg" value="错误的用户名及密码！"/>
		</jsp:forward>
<%
	}
%>
</body>
</html>
