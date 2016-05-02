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
		<form action="emp_insert_do.jsp" method="post" onSubmit="return validate()" enctype="multipart/form-data">
			<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="4">
						<div align="center" class="STYLE1">增加新雇员数据</div>
					</td> 
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td width="9%" align="center" valign="middle"><span
						class="STYLE2">雇员编号：</span></td>
				  <td width="32%"><input name="empno" type="text" class="init "
						id="empno" onBlur="validateEmpno()" size="4" maxlength="4"></td>
					<td width="7%"><span class="STYLE4" id="empnoMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
					<td width="52%">
						<span class="STYLE4"><strong>雇员照片：</strong></span>					</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td align="center" valign="middle"><span class="STYLE4"><strong>雇员姓名：</strong></span></td>
					<td><input name="ename" type="text" class="init " id="ename"
						onBlur="validateEname()"></td>
					<td><span class="STYLE4" id="enameMsg">&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
					<td rowspan="8" align="center" valign="middle">
						<div id="preview"></div>
				  </td>
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
							<textarea id="note" name="note" style="width:650px;height:200px;visibility:hidden;"></textarea>
						</div>
					</td>
				</tr>
				<tr onMouseOver="changeColor(this,'white')"
					onMouseOut="changeColor(this,'F2F2F2')">
					<td colspan="4">
						<div align="center">
							<input type="submit" value="增加"> <input type="reset"
								value="重置">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</center>
	<script type="text/javascript">  
		function preview(file) {
			var prevDiv = document.getElementById('preview');
			if (file.files && file.files[0]) {
				var reader = new FileReader();
				reader.onload = function(evt) {
					prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
				} 
				reader.readAsDataURL(file.files[0]);
			} else {
				prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
			}
		}
	</script>
</body>
</html>
