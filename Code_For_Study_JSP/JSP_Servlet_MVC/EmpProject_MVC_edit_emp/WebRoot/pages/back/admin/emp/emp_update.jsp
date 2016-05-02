<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
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
.source {
	width: 700px;
	font-size: 12px;
	font-family: Courier New;
	border: 1px solid #AAAAAA;
	background-color: #F0F0EE;
	padding: 5px;
}

#preview,.img,img {
	width: 300px;
	height: 300px;
}

#preview {
	border: 1px solid #000;
}

.source pre {
	margin: 0;
}

form {
	margin: 0;
}

.editor {
	margin-top: 5px;
	margin-bottom: 5px;
}

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
<script type="text/javascript" charset="utf-8" src="edit/lang/zh_CN.js"></script>
<script type="text/javascript" charset="utf-8"
	src="edit/kindeditor-core.js"></script>
<script type="text/javascript" charset="utf-8" src="edit/plugin-all.js"></script>
<script type="text/javascript">
	KE.show({
		id : 'note',
		cssPath : 'edit/index.css'
	});
</script>
</head>
<body>
<c:if test="${emp != null}" var="res">
	<center>
		<form action="EmpServlet" method="post"
			onSubmit="return validate()" enctype="multipart/form-data">
			<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="4">
						<div align="center" class="STYLE1">修改雇员数据</div>
					</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td width="15%" align="center" valign="middle"><span
						class="STYLE2">雇员编号：</span></td>
					<td width="44%">${emp.empno}</td>
					<td width="41%"><span class="STYLE4" id="empnoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
					<td width="52%">
						<span class="STYLE4"><strong>雇员照片：</strong></span>					</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员姓名：</strong></span></td>
					<td><input name="ename" type="text" class="init " id="ename"
						onBlur="validateEname()" value="${emp.ename}"></td>
					<td><span class="STYLE4" id="enameMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
					<td rowspan="8" align="center" valign="middle">
						<div id="preview"><img src="<%=basePath%>/photo/${emp.photo}"></div>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员职位：</strong></span></td>
					<td><input name="job" type="text" class="init " id="job"
						onBlur="validateJob()" value="${emp.job }"></td>
					<td><span class="STYLE4" id="jobMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员领导：</strong></span></td>
					<td>
						<select name="mgr" id="mgr">
							<option value=0>=== 没有领导 ===</option>
							<c:if test="${allEmps != null}" var="res">
								<c:forEach items="${allEmps}" var="mgr">
									<c:if test="${emp.empno!=mgr.empno}">
										<option value="${mgr.empno}" ${emp.mgr.empno==mgr.empno?"selected":""}>${mgr.ename}</option>
									</c:if>			
								</c:forEach>
							</c:if> 
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
							<c:if test="${allDepts != null}" var="res">
								<c:forEach items="${allDepts}" var="dept">
									<option value="${dept.deptno}" ${emp.dept.deptno==dept.deptno?"selected":""}>${dept.dname}</option>
								</c:forEach>
							</c:if> 
						</select>
					</td>
					<td><span class="STYLE4" id="deptnoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇佣日期：</strong></span></td>
					<td><input name="hiredate" type="text" class="init "
						id="hiredate" onclick='popUpCalendar(this, this, "yyyy-mm-dd")'
						size="15" maxlength="15" readonly="true" value="${emp.hiredate}"></td>
					<td><span class="STYLE4" id="hiredateMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>基本工资：</strong></span></td>
					<td><input name="sal" type="text" class="init " id="sal"
						onBlur="validateSal()" value="${emp.sal}"></td>
					<td><span class="STYLE4" id="salMsg">&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>佣&nbsp;&nbsp;&nbsp;&nbsp;金：</strong></span></td>
					<td><input name="comm" type="text" class="init " id="comm"
						onBlur="validateComm()" value="${emp.comm}"></td>
					<td><span class="STYLE4" id="commMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>照&nbsp;&nbsp;&nbsp;&nbsp;片：</strong></span></td>
					<td><input name="photo" type="file" class="init " id="photo" onChange="preview(this)"></td>
					<td><span class="STYLE4" id="photoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>简&nbsp;&nbsp;&nbsp;&nbsp;介：</strong></span></td>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="4">
						<div class="editor">
							<textarea id="note" name="note" style="width:650px;height:200px;visibility:hidden;">${emp.note}</textarea>
						</div>
					</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="4">
						<div align="center">
							<input type="hidden" name="status" id="status" value="update">
							<input type="hidden" name="photo" value="${emp.photo}">
							<input type="hidden" name="cp" value="${param.cp}">
							<input type="hidden" name="ls" value="<%=request.getParameter("ls")%>">
							<input type="hidden" name="col" value="<%=request.getParameter("col")%>">
							<input type="hidden" name="kw" value="<%=request.getParameter("kw")%>">
							<input type="hidden" name="backUrl" value="<%=request.getParameter("backUrl")%>">
							<input type="hidden" name="empno" id="empno" value="${emp.empno}">
							<input type="submit" value="更新"> 
							<input type="reset"
								value="重置">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</center>
</c:if>
</body>
</html>
