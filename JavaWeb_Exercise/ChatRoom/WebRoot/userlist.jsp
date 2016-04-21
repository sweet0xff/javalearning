<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="refresh" content="1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<c:forEach items="${userlist }" var="ulist">
		<li>
			${ulist }	
		</li>		
	</c:forEach>

</ul>
</body>
</html>