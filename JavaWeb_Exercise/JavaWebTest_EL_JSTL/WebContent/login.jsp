<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "index_2.jsp" method = "post">
	<table border = "1">
		<tr>
			<td>用户名</td>
			<td><input type = "text" name = "username" ></td>
		</tr>
		<tr>
			<td>密码</td>
			<td align = "center"><input type = "password" name = "password"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="checkbox" name="game" value="lol">lol
				<input type="checkbox" name="game" value="dnf">dnf	
			</td>
		</tr>
		<tr>
			<td></td>
			<td align = "center"><input type = "submit" value = "提交"></td>
		</tr>
	</table>
</form>

</body>
</html>