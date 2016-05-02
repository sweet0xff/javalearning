<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.oracle.vo.*"%>
<%@ page import="cn.mldn.oracle.factory.*"%>
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
<%	// 查询表中的全部数据，返回的是List集合，所以一定使用Iterator输出
	List<Emp> all = ServiceBackFactory.getIEmpServiceBackInstance().list() ;
	Iterator<Emp> iter = all.iterator() ;
%>
<%String backUrl = basePath + "/pages/back/admin/emp/emp_list.jsp" ;%>
<center>
<h1>雇员基本列表</h1>
<form action="emp_delete_batch_do.jsp" method="post" onsubmit="return deleteBatchConfirm('empno')">
<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input type="checkbox" name="all" id="all" onClick="selectAll('all','empno')">		</td>
		<td align="center" valign="middle"><strong>雇员编号</strong></td>
		<td align="center" valign="middle"><strong>姓名</strong></td>
		<td align="center" valign="middle"><strong>职位</strong></td>
		<td align="center" valign="middle"><strong>雇佣日期</strong></td>
		<td align="center" valign="middle"><strong>基本工资</strong></td>
		<td align="center" valign="middle"><strong>佣金</strong></td>
		<td colspan="2" align="center" valign="middle"><strong>操作</strong></td>
	</tr>
<%
	while (iter.hasNext()) {
		Emp vo = iter.next() ;
%>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input name="empno" type="checkbox" id="empno" value="<%=vo.getEmpno()%>">		</td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getEmpno()%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/emp/emp_show.jsp?empno=<%=vo.getEmpno()%>','雇员信息',800,600)"><%=vo.getEname()%></a>
		</span></td> 
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getJob()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getHiredate()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getSal()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getComm()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="<%=basePath%>/pages/back/admin/emp/emp_update.jsp?empno=<%=vo.getEmpno()%>&backUrl=<%=backUrl%>">修改</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a href="<%=basePath%>/pages/back/admin/emp/emp_delete_do.jsp?empno=<%=vo.getEmpno()%>&backUrl=<%=backUrl%>" onclick="return deleteConfirm()">删除</a>  
		</span></td>
	</tr>
<%
	}
%>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="9" align="right">
				<input type="hidden" name="backUrl" value="<%=basePath%>/pages/back/admin/emp/emp_list.jsp">
			<input type="submit" value="批量删除">		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>
