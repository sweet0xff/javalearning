<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//以下作用域范围由小到大
	pageContext.setAttribute("username","wangwu");
	request.setAttribute("username", "zhangsan");//字符串要用双引号
	session.setAttribute("username","lisi");
	
	application.setAttribute("username","zhaoliu");
	
%>
<!-- 输出wangwu -->
	${username}  
	</br>
<!-- 指定作用域范围 ,输出zhaoliu -->
	${applicationScope.username }
</body>

</html>