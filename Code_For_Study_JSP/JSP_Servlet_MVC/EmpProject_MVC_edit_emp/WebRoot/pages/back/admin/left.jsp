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
<html>
<head>
<title>雇员管理程序</title>
<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<style>
body {
	font: 12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}

#container {
	width: 182px;
}

H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;
}

H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(images/menu_bgS.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}

.content {
	width: 182px;
	height: 15px;
	margin: 0px;
	overflow: hidden;
	padding: 0px;
}

.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block
}

.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}

.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px, 0px, 0px, 0px);
}

.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}

.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}

.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}

.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(images/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>

<body>
	<table width="100%" height="280" border="0" cellpadding="0"
		cellspacing="0" bgcolor="#EEF2FB">
		<tr>
			<td width="182" valign="top"><div id="container">
					<h1 class="type">
						<a href="javascript:void(0)">网站基本信息</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="" target="main">作者：MLDN</a></li>
							<li><a href="#" target="main">www.MLDN.cn</a></li>
						</ul>
					</div>
					<h1 class="type">
						<a href="javascript:void(0)">雇员管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?status=insertPre" target="main">增加雇员</a></li>
							<li><a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?status=list" target="main">雇员列表</a></li>
							<li><a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?status=listSplit" target="main">分页列表</a></li>
							<li><a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?status=listDetails" target="main">详细列表</a></li>
						</ul>
					</div>
					<h1 class="type">
						<a href="javascript:void(0)">部门管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="<%=basePath%>/pages/back/admin/dept/dept_insert.jsp" target="main">增加部门</a></li>
							<li><a href="<%=basePath%>/pages/back/admin/dept/DeptServlet?status=list" target="main">部门管理</a></li>
							<li><a href="<%=basePath%>/pages/back/admin/dept/DeptServlet?status=listDetails" target="main">详细信息</a></li>
						</ul>
					</div>
					<h1 class="type">
						<a href="javascript:void(0)">用户管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="<%=basePath%>/pages/back/admin/admin/admin_insert.jsp" target="main">增加管理员</a></li>
						</ul>
					</div>
				</div>

				</div> <script type="text/javascript">
					var contents = document.getElementsByClassName('content');
					var toggles = document.getElementsByClassName('type');

					var myAccordion = new fx.Accordion(toggles, contents, {
						opacity : true,
						duration : 400
					});
					myAccordion.showThisHideOpen(contents[0]);
				</script></td>
		</tr>
	</table>
</body>
</html>
