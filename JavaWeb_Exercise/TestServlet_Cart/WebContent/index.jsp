<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>操作</th>
		</tr>

		<tr>
			<td>1</td>
			<td>苹果</td>
			<td>3.5</td>
			<td><a href="AddCartServlet?gid=1">加入购物车</a></td>
		</tr>
		<tr>
			<td>2</td>
			<td>梨子</td>
			<td>5.5</td>
			<td><a href="AddCartServlet?gid=2">加入购物车</a></td>
		</tr>
		<tr>
			<td>3</td>
			<td>香蕉</td>
			<td>6</td>
			<td><a href="AddCartServlet?gid=3">加入购物车</a></td>
		</tr>
		<tr>
			<td>4</td>
			<td>桔子</td>
			<td>2.4</td>
			<td><a href="AddCartServlet?gid=4">加入购物车</a></td>
		</tr>
	</table>

	<a href="show.jsp">查看购物车</a>
</body>
</html>