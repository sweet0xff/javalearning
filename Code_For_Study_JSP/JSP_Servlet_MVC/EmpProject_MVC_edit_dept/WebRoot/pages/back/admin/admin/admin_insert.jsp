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
<script type="text/javascript" src="<%=basePath%>/js/util.js" ></script>
<script type="text/javascript" src="<%=basePath%>/js/login.js"></script>
<link type="text/css" href="<%=basePath%>css/form_css.jsp" rel="stylesheet">

</head>

<body>
	<h1>增加新管理员</h1>
	<form name="myform" action="<%=basePath%>/pages/back/admin/admin/admin_insert_do.jsp"
		method="post" onsubmit="return validateInsert()">
		<table cellSpacing="0" cellPadding="0" width="100%" border="0"
			height="143" id="table212">
			<tr>
				<td width="13%" height="38" class="top_hui_text"><span
					class="login_txt">管理员：&nbsp;&nbsp; </span></td>
				<td height="38" colspan="2" class="top_hui_text"><input
					name="aid" id="aid" class="init" value="" size="20"
					onblur="validateAid()"> <span id="aidMsg">&nbsp;&nbsp;</span>
				</td>
			</tr>
			<tr>
				<td width="13%" height="35" class="top_hui_text"><span
					class="login_txt"> 密&nbsp;&nbsp;码：&nbsp;&nbsp; </span></td>
				<td height="35" colspan="2" class="top_hui_text"><input
					class="init" id="password" name="password" type="password"
					size="20" onblur="validatePassword()"> <span
					id="passwordMsg">&nbsp;&nbsp;</span></td>
			</tr>
			<tr>
				<td width="13%" height="35"><span class="login_txt">确认密码：</span></td>
				<td height="35" colspan="2" class="top_hui_text">
					<input
					class="init" name="conf" id="conf" type="password" value="" onblur="validateConf()"> 
					<span id="confMsg">&nbsp;&nbsp;</span>
				</td>
			</tr>
			<tr>
				<td height="35">&nbsp;</td>
				<td width="20%" height="35"><input name="Submit" type="submit"
					class="button" id="Submit" value="增加"></td>
				<td width="67%" class="top_hui_text"><input name="cs"
					type="button" class="button" id="cs" value="取 消"
					onClick="showConfirmMsg1()"></td>
			</tr>
		</table>
		<br>
	</form>
</body>
</html>
