<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="Student_editStudent.action" method="post">
  	<table>
  		<tr>
  			<td>学生编号：</td>
  			<td><input type="text" name= "student.sid" value="<s:property value = 'student.sid'/>" /></td>
  		</tr>
  		<tr>
  			<td>学生姓名：</td>
  			<td>
  				<input type="text" value="${student.sname }" name ="student.sname" />
  			</td>
  		</tr>
  		<tr>
  			<td>学生姓別：</td>
  			<td>
  				<input type="text" value="${student.ssex }" name = "student.ssex" />
  			</td>
  		</tr>
  		<tr>
  			<td>课程类型：</td>
  			<td>
  				<select name="student.classtype.cid">
  					<s:iterator var="c" value="clist">
  						<option value="${c.cid}">${c.cname}</option>
  					</s:iterator> 
  				</select> 
  			</td>
  		</tr>
  		<tr>
  			<td><input type= "submit" value="提交修改"/></td>
  		</tr>
  	</table>
  </form>
  <s:debug />
  </body>
</html>
