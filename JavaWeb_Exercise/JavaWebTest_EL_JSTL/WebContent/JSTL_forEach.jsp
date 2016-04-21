<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "org.xxx.model.entify.Products" %>
<%@ page import = "java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Products p1 = new Products();
	Products p2 = new Products();
	Products p3 = new Products();
	Products p4 = new Products();
	Products p5 = new Products();
	p1.setName("a");
	p2.setName("b");
	p3.setName("c");
	p4.setName("b");
	p5.setName("e");
	p1.setPrice(1.1);
	p2.setPrice(5.1);
	p3.setPrice(4.1);
	p4.setPrice(3.1);
	p5.setPrice(2.1);
	
//创建商品一个商品类型集合
 	List<Products> plist = new ArrayList<Products>();
	plist.add(p1);
	plist.add(p2);
	plist.add(p3);
	plist.add(p4);
	plist.add(p5);
	
	request.setAttribute("plist",plist); 
%>

<!-- 遍历List -->
<table border="1">
	<tr>
		<th>index</th>
		<th>name</th>
		<th>price</th>
	</tr>
	<c:forEach var="g" items="${plist }" varStatus="row">
		<tr <c:if test = "${row.index %2 == 1}"> style = "background:red"</c:if> 
			<c:if test = "${row.index %2 == 1}"> style = "background:blue"</c:if>>
			<td>${row.index }</td>
			<td>${row.name }</td>
			<td>${row.price }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>