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
<script type="text/javascript" src="<%=basePath%>js/emp.js"></script>
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
<%
	Map<String,Object> map = ServiceBackFactory.getIEmpServiceBackInstance().insertPre() ;
	List<Dept> allDepts = (List<Dept>) map.get("allDepts") ;
	List<Emp> allEmps = (List<Emp>) map.get("allEmps") ;
	int deptno = 0 ;
	if (request.getParameter("deptno") != null) {	// 现在传递了部门编号
		deptno = Integer.parseInt(request.getParameter("deptno")) ;
	}
%>
	<center>
		<form action="emp_insert_do.jsp" method="post"
			onSubmit="return validate()">
			<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="3">
						<div align="center" class="STYLE1">增加新雇员数据</div>
					</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td width="15%" align="center" valign="middle"><span
						class="STYLE2">雇员编号：</span></td>
					<td width="44%"><input name="empno" type="text" class="init "
						id="empno" onBlur="validateEmpno()" size="4" maxlength="4"></td>
					<td width="41%"><span class="STYLE4" id="empnoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员姓名：</strong></span></td>
					<td><input name="ename" type="text" class="init " id="ename"
						onBlur="validateEname()"></td>
					<td><span class="STYLE4" id="enameMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员职位：</strong></span></td>
					<td><input name="job" type="text" class="init " id="job"
						onBlur="validateJob()"></td>
					<td><span class="STYLE4" id="jobMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员领导：</strong></span></td>
					<td>
						<select name="mgr" id="mgr">
							<option value=0>=== 没有领导 ===</option>
							<%
								Iterator<Emp> iterEmp = allEmps.iterator() ;
								while (iterEmp.hasNext()) {
									Emp tempEmp = iterEmp.next() ;
							%>
								<option value="<%=tempEmp.getEmpno()%>"><%=tempEmp.getEname()%></option>
							<%
								}
							%>
						</select>
					</td>
					<td><span class="STYLE4" id="mgrMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>所在部门：</strong></span></td>
					<td>
						<select name="deptno" id="deptno">
							<option value=0>=== 没有部门 ===</option>
							<%
								Iterator<Dept> iterDept = allDepts.iterator() ;
								while (iterDept.hasNext()) {
									Dept tempDept = iterDept.next() ;
							%>
								<option value="<%=tempDept.getDeptno()%>" <%=tempDept.getDeptno().equals(deptno)?"selected":""%>><%=tempDept.getDname()%></option>
							<% 
								}
							%>
						</select>
					</td>
					<td><span class="STYLE4" id="deptnoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇佣日期：</strong></span></td>
					<td><input name="hiredate" type="text" class="init "
						id="hiredate" onclick='popUpCalendar(this, this, "yyyy-mm-dd")'
						size="15" maxlength="15" readonly="true"></td>
					<td><span class="STYLE4" id="hiredateMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>基本工资：</strong></span></td>
					<td><input name="sal" type="text" class="init " id="sal"
						onBlur="validateSal()"></td>
					<td><span class="STYLE4" id="salMsg">&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>佣&nbsp;&nbsp;&nbsp;&nbsp;金：</strong></span></td>
					<td><input name="comm" type="text" class="init " id="comm"
						onBlur="validateComm()"></td>
					<td><span class="STYLE4" id="commMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="3">
						<div align="center">
							<input type="submit" value="增加"> <input type="reset"
								value="重置">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
