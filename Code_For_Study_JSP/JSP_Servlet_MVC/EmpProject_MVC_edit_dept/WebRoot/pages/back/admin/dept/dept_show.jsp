<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c"%>
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
<h1>部门信息显示</h1>
<table border="1" width="100%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><strong>编号</strong></td>
		<td align="center" valign="middle"><strong>名称</strong></td>
		<td align="center" valign="middle"><strong>位置</strong></td>
		<td align="center" valign="middle"><strong>人数</strong></td>
		<td align="center" valign="middle"><strong>总工资</strong></td>
		<td align="center" valign="middle"><strong>平均工资</strong></td>
		<td align="center" valign="middle"><strong>最高工资</strong></td>
		<td align="center" valign="middle"><strong>最低工资</strong></td>
		<td align="center" valign="middle"><strong>平均服务年限</strong></td>
	</tr>
		<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.deptno}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.dname}
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
			${dept.stat.max}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.stat.min}
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			${dept.stat.avgyear}
		</span></td>
	</tr>
</table>
<hr>
<jsp:include page="/pages/split_page_plugin.jsp">
	<jsp:param name="currentPage" value="${currentPage}"/>
	<jsp:param name="lineSize" value="${lineSize}"/>
	<jsp:param name="actionUrl" value="${actionUrl}"/>
	<jsp:param name="allRecorders" value="${allRecorders}"/>
	<jsp:param name="columnData" value="${columnData}"/>
	<jsp:param name="column" value="${column}"/>
	<jsp:param name="keyWord" value="${keyWord}"/>
</jsp:include>
<form action="emp_delete_batch_do.jsp" method="post" onsubmit="return deleteBatchConfirm('empno')">
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
			<a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?empno=${emp.empno}&backUrl=${backUrl}&cp=${currentPage}&ls=${lineSize}&col=${column}&kw=${keyWord}&status=updatePre">修改</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a href="<%=basePath%>/pages/back/admin/emp/EmpServlet?empno=${emp.empno}&backUrl=${backUrl}&cp=${currentPage}&ls=${lineSize}&col=${column}&kw=${keyWord}&status=delete" onclick="return deleteConfirm()">删除</a> 
		</span></td>
	</tr> 
</c:forEach>
</c:if>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="11" align="right">
			<input type="hidden" name="cp" value="${currentPage }">
			<input type="hidden" name="ls" value="${lineSize}">
			<input type="hidden" name="col" value="${column}">
			<input type="hidden" name="kw" value="${keyWord}">
			<input type="hidden" name="backUrl" value="<%=basePath%>/pages/back/admin/emp/${actionUrl}">
			<input type="submit" value="批量删除">		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>
