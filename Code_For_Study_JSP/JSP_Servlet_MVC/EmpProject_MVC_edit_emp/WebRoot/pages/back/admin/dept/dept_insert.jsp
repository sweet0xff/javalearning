<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.oracle.vo.*"%>
<%@ page import="cn.mldn.oracle.factory.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>雇员管理程序</title>
<script type="text/javascript" src="<%=basePath%>js/dept.js"></script>
<script type="text/javascript" src="<%=basePath%>js/util.js"></script>
<script type="text/javascript" src="<%=basePath%>js/data.js"></script>
<link type="text/css" href="<%=basePath%>css/form_css.jsp" rel="stylesheet">
<style type="text/css">
<!--
.STYLE1 {
	font-size: xx-large;
	font-weight: bold;
}

.STYLE2 {
	font-size: 12;
	font-weight: bold;
}

.STYLE4 {
	font-size: 12
}
-->
</style>
</head>
<body>
	<center>
		<form action="DeptServlet" method="post" onsubmit="return validate()">
			<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="3">
						<div align="center" class="STYLE1">增加新部门数据</div>
					</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td width="15%" align="center" valign="middle"><span
						class="STYLE2">部门编号：</span></td>
					<td width="44%"><input name="deptno" type="text" class="init "
						id="deptno" onBlur="validateDeptno()" size="2" maxlength="2"></td>
					<td width="41%"><span class="STYLE4" id="deptnoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>名&nbsp;&nbsp;称：</strong></span></td>
					<td><input name="dname" type="text" class="init " id="dname"
						onBlur="validateDname()"></td>
					<td><span class="STYLE4" id="dnameMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>位&nbsp;&nbsp;置：</strong></span></td>
					<td><input name="loc" type="text" class="init " id="loc"
						onBlur="validateLoc()"></td>
					<td><span class="STYLE4" id="locMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="3">
						<div align="center">
							<input type="hidden" name="status" id="status" value="insert">
							<input type="submit" value="增加"> 
							<input type="reset" value="重置">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
