<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<%
	session.invalidate() ;
%>
<script type="text/javascript">
	alert("退出成功，欢迎下次再来！") ;
	window.location = "<%=basePath%>/pages/back/login.jsp" ;
</script>
