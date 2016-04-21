<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	request.setAttribute("username",username);
	request.setAttribute("password" ,password);
%>
密码是否为空:${empty username }
<!-- 内容来自作用域 -->
${username }
密码:${password == "" ? "暂无密码":password }


<!-- param获取表单中的一个元素 -->
<!-- paramValues 获取表单中的一组元素中的内容 -->
${param.username} ${param.password }

<!-- 通过jstl遍历过来的字符串数组然后打印结果 -->

<c:forEach items="${paramValues.game }" var ="g">
 ${g }
</c:forEach>

</body>
</html>