<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href = "<%=basePath %>">
<meta charset="utf-8">
<title>后台管理</title>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>

<script type="text/javascript" src="js/getuserlist.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css" />

<script type="text/javascript">
	$(function(){
		getDatas();
	});
</script> 
</head>

<body>
	<!--导航栏-->
	<div class="row">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container col-sm-offset-2">
				<div class="nav-header">
					<a class="navbar-brand" href="admininfo">${admin.aname}的主页</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="usermanager.jsp">用户管理</a></li>
						<li><a href="#">订单管理</a></li>
						<li><a href="goodsmanager.jsp">商品管理</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

		<!--内容栏-->
	<div id="resultDiv" class="container" style="margin-top:100px"></div>

		
	
</body>

</html>
