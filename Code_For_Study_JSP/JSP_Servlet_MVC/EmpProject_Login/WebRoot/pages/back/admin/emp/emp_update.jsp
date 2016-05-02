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
	int empno = Integer.parseInt(request.getParameter("empno")) ;
	Map<String,Object> map = ServiceBackFactory.getIEmpServiceBackInstance().updatePre(empno) ;
	List<Dept> allDepts = (List<Dept>) map.get("allDepts") ;
	List<Emp> allEmps = (List<Emp>) map.get("allEmps") ;
	Emp vo = (Emp) map.get("emp") ;
	if (vo != null) {
%>
	<center>
		<form action="emp_update_do.jsp" method="post"
			onSubmit="return validate()">
			<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="3">
						<div align="center" class="STYLE1">修改雇员数据</div>
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
					<td><input name="ename" type="text" class="init " id="ename"
						onBlur="validateEname()" value="<%=vo.getEname()%>"></td>
					<td><span class="STYLE4" id="enameMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员职位：</strong></span></td>
					<td><input name="job" type="text" class="init " id="job"
						onBlur="validateJob()" value="<%=vo.getJob()%>"></td>
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
									if (!vo.getEmpno().equals(tempEmp.getEmpno())) {
							%>
								<option value="<%=tempEmp.getEmpno()%>" <%=vo.getMgr().getEmpno().equals(tempEmp.getEmpno())?"selected":""%>><%=tempEmp.getEname()%></option>
							<%
									}
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
								<option value="<%=tempDept.getDeptno()%>" <%=vo.getDept().getDeptno().equals(tempDept.getDeptno())?"selected":""%>><%=tempDept.getDname()%></option>
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
						size="15" maxlength="15" readonly="true" value="<%=vo.getHiredate()%>"></td>
					<td><span class="STYLE4" id="hiredateMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>基本工资：</strong></span></td>
					<td><input name="sal" type="text" class="init " id="sal"
						onBlur="validateSal()" value="<%=vo.getSal()%>"></td>
					<td><span class="STYLE4" id="salMsg">&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>佣&nbsp;&nbsp;&nbsp;&nbsp;金：</strong></span></td>
					<td><input name="comm" type="text" class="init " id="comm"
						onBlur="validateComm()" value="<%=vo.getComm()%>"></td>
					<td><span class="STYLE4" id="commMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="3">
						<div align="center">
							<input type="hidden" name="cp" value="<%=request.getParameter("cp")%>">
							<input type="hidden" name="ls" value="<%=request.getParameter("ls")%>">
							<input type="hidden" name="col" value="<%=request.getParameter("col")%>">
							<input type="hidden" name="kw" value="<%=request.getParameter("kw")%>">
							<input type="hidden" name="backUrl" value="<%=request.getParameter("backUrl")%>">
							<input type="hidden" name="empno" id="empno" value="<%=vo.getEmpno()%>">
							<input type="submit" value="更新"> 
							<input type="reset"
								value="重置">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</center>
<%
	}
%>
</body>
</html>
