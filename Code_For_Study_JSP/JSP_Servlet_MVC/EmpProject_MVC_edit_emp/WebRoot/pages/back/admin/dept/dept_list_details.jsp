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
	var backUrl = "<%=basePath%>/pages/back/admin/dept/DeptServlet?status=listDetails" ;
</script>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<body>
<center>
<h1>部门详细列表</h1>
<table border="1" width="100%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input type="checkbox" name="all" id="all" onClick="selectAll('all','deptno')">		</td>
		<td align="center" valign="middle"><strong>编号</strong></td>
		<td align="center" valign="middle"><strong>名称</strong></td>
		<td align="center" valign="middle"><strong>位置</strong></td>
		<td align="center" valign="middle"><strong>人数</strong></td>
		<td align="center" valign="middle"><strong>总工资</strong></td>
		<td align="center" valign="middle"><strong>平均工资</strong></td>
		<td align="center" valign="middle"><strong>最高工资</strong></td>
		<td align="center" valign="middle"><strong>最低工资</strong></td>
		<td align="center" valign="middle"><strong>平均服务年限</strong></td>
		<td align="center" valign="middle"><strong>操作</strong></td>
	</tr>
<c:if test="${allDepts != null}" var="res">
	<c:forEach items="${allDepts}" var="dept">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input name="deptno" type="checkbox" id="deptno" value="${dept.deptno}">		</td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.deptno}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/dept/DeptServlet?deptno=${dept.deptno}&status=show','部门信息',1000,600)">${dept.dname}</a>
		</span></td> 
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.loc}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.stat.count}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.stat.sum}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.stat.avg}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a onclick="openWindow('<%=basePath%>/pages/back/admin/emp/EmpServlet?deptno=${dept.deptno}&sal=${dept.stat.max}&status=listSal','部门信息',1000,600)" href="#">${dept.stat.max}</a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a onclick="openWindow('<%=basePath%>/pages/back/admin/emp/EmpServlet?deptno=${dept.deptno}&sal=${dept.stat.min}&status=listSal','部门信息',1000,600)" href="#">${dept.stat.min}</a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.stat.avgyear}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a href="<%=basePath%>/pages/back/admin/emp/emp_insert.jsp?deptno=${dept.deptno}">增加新雇员</a> 
		</span></td>
	</tr>
	</c:forEach>
</c:if>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="11" align="right">
			<input type="button" value="批量删除" onclick="deleteBatchHandleStatus('deptno','<%=basePath%>/pages/back/admin/dept/DeptServlet','deleteBatch')">		
		</td>
	</tr>
</table>
</center>
</body>
</html>
