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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<a href="students_addBefore.action"><strong>添加学生</strong></a>
  	<table>
  		<tr>
  			<th>学生编号</th>
  			<th>学生姓名</th>
  			<th>学生性别</th>
  			<th>班级类型</th>
  			<th colspan="2">操作</th>
  		</tr>
  		<s:iterator value="slist" var ="s">
  			<tr>
  				<td>${s.students.sid}</td>
  				<td>${s.students.sname}</td>
  				<td>${s.students.ssex }</td>
  				<td>${s.classtype.cname }</td>
  				<td><a href = "students_findStudentsById.action?students.sid=${s.students.sid}">修改</a></td>
  				<td><a href ="students_delete.action?students.sid=${s.students.sid}">删除</a></td>
  			</tr>
  		</s:iterator>
  	</table>
  
  </body>
</html>
