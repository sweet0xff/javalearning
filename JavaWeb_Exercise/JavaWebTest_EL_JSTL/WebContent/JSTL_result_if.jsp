<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 判断前一个页面的url(JSTL_login.jsp)中是否有 username 的参数-->
<c:if test="${empty param.username }" var="result">
	<form>
		<input type="text" name="username"> <input type="submit"
			value="请登录">
	</form>
</c:if>
	
<c:if test= "${!result }">
	welcome:${param.username }
</c:if>
</body>
</html>