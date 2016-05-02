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
<link type="text/css" href="<%=basePath%>css/form_css.jsp" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/util.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dept.js"></script>
<script type="text/javascript">
	var backUrl = "<%=basePath%>/pages/back/admin/dept/DeptServlet?status=list" ;
</script>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<body>
<center>
<h1>部门信息管理</h1>
<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input type="checkbox" name="all" id="all" onClick="selectAll('all','deptno')">		</td>
		<td align="center" valign="middle"><strong>部门编号</strong></td>
		<td align="center" valign="middle"><strong>名称</strong></td>
		<td align="center" valign="middle"><strong>位置</strong></td>
		<td colspan="2" align="center" valign="middle"><strong>操作</strong></td>
	</tr>
	<c:if test="${allDepts != null}" var="res">
	<c:forEach items="${allDepts}" var="dept">
		<form action="DeptServlet" method="post" onsubmit="return validate(${dept.deptno})">
		<tr onMouseOver="changeColor(this,'white')"
			onMouseOut="changeColor(this,'F2F2F2')">
			<td align="center" valign="middle">
				<input name="deptno" type="checkbox" id="deptno" value="${dept.deptno}">		</td>
			<td align="center" valign="middle"><span class="STYLE2">
				${dept.deptno}
			</span></td>
			<td align="center" valign="middle"><span class="STYLE2">
				<input class="init" type="text" name="dname-${dept.deptno}" id="dname-${dept.deptno}" value="${dept.dname}" onblur="validateDname(${dept.deptno})">
				<span id="dname-${dept.deptno}Msg">&nbsp;&nbsp;</span>
			</span></td> 
			<td align="center" valign="middle"><span class="STYLE2">
				<input class="init" type="text" name="loc-${dept.deptno}" id="loc-${dept.deptno}" value="${dept.loc}" onblur="validateLoc(${dept.deptno})">
				<span id="loc-${dept.deptno}Msg">&nbsp;&nbsp;</span>
			</span></td>
			<td align="center" valign="middle"><span class="STYLE2">
				<input type="hidden" name="deptno-${dept.deptno}" id="deptno-${dept.deptno}" value="${dept.deptno}">
				<span id="deptno-${dept.deptno}Msg"></span>
				<input type="hidden" name="deptno" id="deptno" value="${dept.deptno}">
				<input type="hidden" name="status" id="status" value="update">
				<input type="submit" value="修改">
			</td>
			<td align="center" valign="middle"><span class="STYLE2"> 
				<a href="<%=basePath%>/pages/back/admin/dept/DeptServlet?deptno=${dept.deptno}&status=delete" onclick="return deleteConfirm()">删除</a> 
			</span></td>
		</tr>
		</form>
	</c:forEach>
	</c:if>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="9" align="right">
			<input type="button" value="批量删除" onclick="deleteBatchHandleStatus('deptno','<%=basePath%>/pages/back/admin/dept/DeptServlet','deleteBatch')">		
		</td>
	</tr>
</table>
</center>
</body>
</html>
