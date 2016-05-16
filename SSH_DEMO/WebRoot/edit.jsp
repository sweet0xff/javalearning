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
  <form action="students_update.action">
  	<table>
  		<tr>
  			<td>姓名：</td>
  			<td><input type="text" value ="${students.sname}"></td>
  		</tr>
  		<tr>
  			<td>性别：</td>
  			<td><input type = "radio" value = "男">男
  				<input type= "radio" value = "女">女
  			</td>
  		</tr>
  		<tr>
  			<td>课程</td>
  			<td>
  				<%--  <select name="studests.classtype.cid">  --%>
  				<select name="cid"> 
  					<s:iterator value="clist" var = "c">
	  					<option value="${c.cid}">${c.cname }</option>
  					</s:iterator>	
  				</select>
  			</td>
  		</tr>
  		<tr>
  			<td colspan="2"><input type="submit" value="update"></td>
  		</tr>
  	</table>
</form>
  </body>
</html>
