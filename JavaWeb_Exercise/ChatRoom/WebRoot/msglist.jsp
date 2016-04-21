<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="refresh" content="1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<ul>
	<c:forEach items = "${MSG}" var = "messagelist">
		<li>${messagelist }</li>
	</c:forEach>
		<li>暂无消息</li>
	</ul>
</body>
</html>