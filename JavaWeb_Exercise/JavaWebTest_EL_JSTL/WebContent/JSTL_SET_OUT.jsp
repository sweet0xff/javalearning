<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 定义了一个User对象,并取名为 u -->
<jsp:useBean id = "u" class="org.xxx.model.entify.User"></jsp:useBean>
<!-- 使用JSTL中的set标签.设置该对象的某些属性 -->
<c:set target ="${u }" property = "name" value = "admin" />
<c:set target ="${u }" property = "password" value = "123" />

<c:set value = "${u }" var = "userinfo" scope = "page"></c:set>
<c:out value = "${userinfo.name }"></c:out>
<c:out value = "${userinfo.password }"></c:out>

<br/>
-- 删除以后的userinfo --
<c:remove var= "userinfo" scope = "page"/>
<c:out value = "${userinfo.name }" ></c:out>
<c:out value = "${userinfo.password }"></c:out>
<br/>

</body>
</html>