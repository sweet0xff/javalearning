<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
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
<script type="text/javascript" src="<%=basePath%>js/util.js"></script>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<body>
<center>
<h1>雇员基本列表</h1>
<form action="EmpServlet" method="post" onsubmit="return deleteBatchConfirm('empno')">
<table border="1" width="100%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input type="checkbox" name="all" id="all" onClick="selectAll('all','empno')">		</td>
		<td align="center" valign="middle"><strong>雇员编号</strong></td>
		<td align="center" valign="middle"><strong>姓名</strong></td>
		<td align="center" valign="middle"><strong>职位</strong></td>
		<td align="center" valign="middle"><strong>领导</strong></td>
		<td align="center" valign="middle"><strong>部门</strong></td>
		<td align="center" valign="middle"><strong>雇佣日期</strong></td>
		<td align="center" valign="middle"><strong>基本工资</strong></td>
		<td align="center" valign="middle"><strong>佣金</strong></td>
		<td colspan="2" align="center" valign="middle"><strong>操作</strong></td>
	</tr>
<c:if test="${allEmps != null}" var="res">
	<c:forEach items="${allEmps}" var="emp">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input name="empno" type="checkbox" id="empno" value="${emp.empno}">		</td>
		<td align="center" valign="middle"><span class="STYLE2">
			${emp.empno}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/emp/EmpServlet?empno=${emp.empno}&status=show','雇员信息',800,600)">${emp.ename}</a>
		</span></td> 
		<td align="center" valign="middle"><span class="STYLE2">${emp.job}</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/emp/EmpServlet?empno=${emp.mgr.empno}&status=show','雇员信息',800,600)">${emp.mgr.ename}</a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/dept/DeptServlet?deptno=${emp.dept.deptno}','部门信息',1200,800)">${emp.dept.dname}</a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">${emp.hiredate}</span></td>
		<td align="center" valign="middle"><span class="STYLE2">${emp.sal}</span></td>
		<td align="center" valign="middle"><span class="STYLE2">${emp.comm}</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?empno=${emp.empno}&cp=${currentPage}&ls=${lineSize}&col=${column}&kw=${keyWord}&status=updatePre&backUrl=${backUrl}">修改</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?empno=${emp.empno}&cp=${currentPage}&ls=${lineSize}&col=${column}&kw=${keyWord}&status=delete&backUrl=${backUrl}" onclick="return deleteConfirm()">删除</a> 
		</span></td>
	</tr> 
</c:forEach>
</c:if>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="11" align="right">
		<input type="hidden" name="status" id="status" value="deleteBatch">
			<input type="hidden" name="backUrl" value="${backUrl}">
			<input type="submit" value="批量删除">		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>
