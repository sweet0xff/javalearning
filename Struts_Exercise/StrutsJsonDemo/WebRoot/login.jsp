<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
		function login(){
			var name = $("#name").val();
			var password = $("#password").val;
			
			var postData = {
				"user.name":name,
				"user.pasword":password	
			};
			
			$.post("user_login.action",postData,function(data){
				debugger;
			});
		}
	</script>

  </head>
  
  <body>
  <table>
  	<tr>
  	<td>账户</td>
  	<td><input type= "text" id="name"/></td>
  	</tr>
  	<tr>
  		<td>密码</td>
  		<td><input type="password" id = "password"/></td>
  	</tr>
  		<td><input type="button" value="登录" onclick="login()"></td>
  	</tr>
  </table>
  </body>
</html>
