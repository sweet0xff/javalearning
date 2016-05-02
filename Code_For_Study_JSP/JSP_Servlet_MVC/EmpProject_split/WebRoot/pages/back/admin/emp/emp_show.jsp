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
				<td width="41%"><span class="STYLE4" id="empnoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员姓名：</strong></span></td>
				<td><%=vo.getEname()%></td>
				<td><span class="STYLE4" id="enameMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇员职位：</strong></span></td>
				<td><%=vo.getJob()%></td>
				<td><span class="STYLE4" id="jobMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>雇佣日期：</strong></span></td>
				<td><%=vo.getHiredate()%></td>
				<td><span class="STYLE4" id="hiredateMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>基本工资：</strong></span></td>
				<td><%=vo.getSal()%></td>
				<td><span class="STYLE4" id="salMsg">&nbsp;&nbsp;</span></td>
			</tr>
			<tr onMouseOver="changeColor(this,'white')"
				onMouseOut="changeColor(this,'F2F2F2')">
				<td align="center" valign="middle"><span class="STYLE4"><strong>佣&nbsp;&nbsp;&nbsp;&nbsp;金：</strong></span></td>
				<td><%=vo.getComm()%></td>
				<td><span class="STYLE4" id="commMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
			</tr>
		</table>
<% 
	}
%>
	</center>
</body>
</html>
