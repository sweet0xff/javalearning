<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("test_2","script src = xxx.js");
	session.setAttribute("test_1","<h1>hello,world</h1>");
%>
<!-- test_1输出文本内容 -->
<c:out value ="${test_1 }" default = "hehe" escapeXml = "fasle">
</c:out>

<!-- test_2解析成标签 -->
<c:out value ="${test_2 }" default = "hehe" escapeXml = "ture">
<br/>
<br/>
<br/>
<br/>


</c:out>
</body>
</html>