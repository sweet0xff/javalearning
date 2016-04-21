<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>商品编号</th>
			<th>购买数量</th>
		</tr>

		<%
			if (session.getAttribute("cart") != null) {
				Map<String, Object> cartMap = (Map<String, Object>) session
						.getAttribute("cart");

				Set<String> keys = cartMap.keySet();
				if (keys.size() > 0) {
					//遍历
					for (String k : keys) {
						//获取每个商品的编号（map中的键）
						//商品的购买数量 （map 中的值）
						String gid = k;
						//通过键获取 map中的值
						int count = (Integer) cartMap.get(gid);
		%>
		<tr>
			<td><%=gid%></td>
			<td><%=count%></td>
		</tr>
		<%
			}
				}
			} else {
		%>
		<tr>
			<td colspan="2">暂无商品信息</td>
		</tr>
		<%
			}
		%>



	</table>
	<a href="index.jsp">继续购买</a>
</body>

</html>