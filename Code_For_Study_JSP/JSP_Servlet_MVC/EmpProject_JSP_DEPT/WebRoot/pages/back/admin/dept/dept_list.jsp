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
<link type="text/css" href="<%=basePath%>css/form_css.jsp" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/util.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dept.js"></script>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<body>
<%	// 查询表中的全部数据，返回的是List集合，所以一定使用Iterator输出
	List<Dept> all = ServiceBackFactory.getIDeptServiceBackInstance().list() ;
	Iterator<Dept> iter = all.iterator() ;
%>
<center>
<h1>雇员基本列表</h1>
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
<%
	while (iter.hasNext()) {
		Dept vo = iter.next() ;
%>
	<form action="dept_update_do.jsp" method="post" onsubmit="return validate(<%=vo.getDeptno()%>)">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input name="deptno" type="checkbox" id="deptno" value="<%=vo.getDeptno()%>">		</td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getDeptno()%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<input class="init" type="text" name="dname-<%=vo.getDeptno()%>" id="dname-<%=vo.getDeptno()%>" value="<%=vo.getDname()%>" onblur="validateDname(<%=vo.getDeptno()%>)">
			<span id="dname-<%=vo.getDeptno()%>Msg">&nbsp;&nbsp;</span>
		</span></td> 
		<td align="center" valign="middle"><span class="STYLE2">
			<input class="init" type="text" name="loc-<%=vo.getDeptno()%>" id="loc-<%=vo.getDeptno()%>" value="<%=vo.getLoc()%>" onblur="validateLoc(<%=vo.getDeptno()%>)">
			<span id="loc-<%=vo.getDeptno()%>Msg">&nbsp;&nbsp;</span>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<input type="hidden" name="deptno-<%=vo.getDeptno()%>" id="deptno-<%=vo.getDeptno()%>" value="<%=vo.getDeptno()%>">
			<span id="deptno-<%=vo.getDeptno()%>Msg"></span>
			<input type="hidden" name="deptno" id="deptno" value="<%=vo.getDeptno()%>">
			<input type="submit" value="修改">
		</td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a href="<%=basePath%>/pages/back/admin/dept/dept_delete_do.jsp?deptno=<%=vo.getDeptno()%>" onclick="return deleteConfirm()">删除</a> 
		</span></td>
	</tr>
	</form>
<%
	}
%>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="9" align="right">
			<input type="button" value="批量删除" onclick="deleteBatchHandle('deptno','<%=basePath%>/pages/back/admin/dept/dept_delete_batch_do.jsp')">		
		</td>
	</tr>
</table>
</center>
</body>
</html>
