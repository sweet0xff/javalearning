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
<%	// 接收要查询雇员信息的编号 
	int empno = Integer.parseInt(request.getParameter("empno")) ;
	Emp vo = ServiceBackFactory.getIEmpServiceBackInstance().show(empno) ;
	if (vo != null) {
%>
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
				<td width="44%"><%=vo.getEmpno()%></td>
				<td width="15%" align="center" valign="middle"><span
					class="STYLE2">雇员照片：</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员姓名：</strong></span></td>
				<td><%=vo.getEname()%></td>
				<td width="15%" align="center" valign="middle" rowspan="8">
					<img src="<%=basePath%>/photo/<%=vo.getPhoto()%>" width="250" height="250">
				</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员职位：</strong></span></td>
				<td><%=vo.getJob()%></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员领导：</strong></span></td>
				<td>
					<a href="<%=basePath%>/pages/back/admin/emp/emp_show.jsp?empno=<%=vo.getMgr().getEmpno()%>"><%=vo.getMgr().getEname()==null?"":vo.getMgr().getEname()%></a>
				</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>所在部门：</strong></span></td>
				<td>
					<a href="<%=basePath%>/pages/back/admin/dept/dept_show.jsp?deptno=<%=vo.getDept().getDeptno()%>"><%=vo.getDept().getDname()%></a></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇佣日期：</strong></span></td>
				<td><%=vo.getHiredate()%></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>基本工资：</strong></span></td>
				<td><%=vo.getSal()%></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>佣&nbsp;&nbsp;&nbsp;&nbsp;金：</strong></span></td>
				<td><%=vo.getComm()%></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>简&nbsp;&nbsp;&nbsp;&nbsp;介：</strong></span></td>
				<td colspan="1">&nbsp;</td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td colspan="3"><%=vo.getNote()%></td>
			</tr>
		</table>
<% 
	}
%>
	</center>
</body>
</html>
