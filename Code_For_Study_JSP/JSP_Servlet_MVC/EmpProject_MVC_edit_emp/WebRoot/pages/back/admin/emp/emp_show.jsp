<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>雇员管理程序</title>
<script type="text/javascript" src="<%=basePath%>js/util.js"></script>
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
<c:if test="${emp!=null}" var="res">
	<center>
		<table border="1" width="90%" cellpadding="5" cellspacing="0"
			bgcolor="F2F2F2">
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3">
					<div align="center" class="STYLE1">显示雇员信息</div>
				</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td width="15%" align="center" valign="middle"><span
					class="STYLE2">雇员编号：</span></td>
				<td width="44%">${emp.empno}</td>
				<td width="15%" align="center" valign="middle"><span
					class="STYLE2">雇员照片：</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员姓名：</strong></span></td>
				<td>${emp.ename}</td>
				<td width="15%" align="center" valign="middle" rowspan="8">
					<img src="<%=basePath%>/photo/${emp.photo}" width="250" height="250">
				</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员职位：</strong></span></td>
				<td>${emp.job}</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员领导：</strong></span></td>
				<td>
					<a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?empno=${emp.mgr.empno}&status=show">${emp.mgr.ename}</a>
				</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>所在部门：</strong></span></td>
				<td>
					<a href="<%=basePath%>/pages/back/admin/dept/DeptServlet?deptno=${emp.dept.deptno}&status=show">${emp.dept.dname}</a></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇佣日期：</strong></span></td>
				<td>${emp.hiredate}</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>基本工资：</strong></span></td>
				<td>${emp.sal}</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>佣&nbsp;&nbsp;&nbsp;&nbsp;金：</strong></span></td>
				<td>${emp.comm}</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>简&nbsp;&nbsp;&nbsp;&nbsp;介：</strong></span></td>
				<td colspan="1">&nbsp;</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3">${emp.note}</td>
			</tr>
		</table>
</c:if>
	</center>
</body>
</html>
