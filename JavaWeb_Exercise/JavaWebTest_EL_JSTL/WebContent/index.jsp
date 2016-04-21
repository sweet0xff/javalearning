<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="org.xxx.model.entify.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	//取对象里面的值
	User u = new User();
	u.setName("zhangsan");
	Pet p = new Pet();
	
	//设置该用户所拥有的宠物
	u.setP(p);
	p.setPname("hehe");
	
	//在请求作用域中存放相关信息
	request.setAttribute("x",u);
	
	//常规写法
	User user = (User)request.getAttribute("x");
%> 
	<%=user.getP().getPname() %>

	<br/>
<!-- EL写法 -->	
	${x.name}
	<br/>
	${x.p.pname}
	

		
</body>
</html>