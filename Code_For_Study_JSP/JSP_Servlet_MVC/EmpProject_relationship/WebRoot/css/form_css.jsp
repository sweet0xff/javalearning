<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/css"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
.right {
	width:25px ;
	height:22px ;
	background:url(<%=basePath%>/images/right.gif) left top no-repeat ;
}
.wrong {
	width:25px ;
	height:22px ;
	background:url(<%=basePath%>/images/wrong.gif) left top no-repeat ;
}
.success{
	background:#f5f5f5;
	font-weight:bold;
	color:#000000;
	border:1px #009900 solid;
}
.fail{
	background:#f5f5f5;
	font-weight:bold;
	color:#000000;
	border:1px #990000 solid;
}
.init{
	background:#f5f5f5;
	font-weight:bold;
	color:#000000;
}