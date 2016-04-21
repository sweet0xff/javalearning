<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="example" value ="${100+3 }" scope = "session" />
<br/>
<c:out value="${example }" />
<c:remove var= "example" scope= "session" />
刪除之後的值:
<c:out value = "${example }"/>
</body>
</html>