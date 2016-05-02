<%@ page pageEncoding="GBK"%>
<%@ page import="java.sql.*"%>
<%!	// 定义数据库连接的常量信息
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	public static final String DBUSER = "scott" ;
	public static final String PASSWORD = "tiger" ;
%>
<%	// 定义分页的控制变量
	int currentPage = 1 ;	// 保存当前所在页
	int lineSize = 5 ;		// 每页显示的数据行
	String actionUrl = "emp_list.jsp" ;	// 参数的传递路径
	int allRecorders = 0 ;	// 总记录数
	int pageSize = 0 ;	// 总页数，需要计算得来
	int lineSizeData [] = new int [] {1,2,5,10,20,30,50,80,100} ;
%>
<%
	try {
		currentPage = Integer.parseInt(request.getParameter("cp")) ;
	} catch (Exception e) {}
	try {
		lineSize = Integer.parseInt(request.getParameter("ls")) ;
	} catch (Exception e) {}
%>
<%	// 定义所需要的对象
	Connection conn ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>
<%	// 进行数据库的连接操作
	Class.forName(DBDRIVER) ;
	conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD) ;

	String sql = "SELECT COUNT(empno) FROM emp " ;
	pstmt = conn.prepareStatement(sql) ;
	rs = pstmt.executeQuery() ;
	if (rs.next()) {
		allRecorders = rs.getInt(1) ;
	}
	if (allRecorders == 0) {	// 没有任何的记录
		pageSize = 1 ;	// 总页数设置为第一页
	}  else {
		pageSize = (allRecorders + lineSize - 1) / lineSize ;
	}
	
	sql = "SELECT * FROM (SELECT empno,ename,job,hiredate,sal,comm,ROWNUM rn FROM emp WHERE ROWNUM<=?) temp WHERE temp.rn>?" ;
	pstmt = conn.prepareStatement(sql) ;
	pstmt.setInt(1,currentPage * lineSize) ;
	pstmt.setInt(2,(currentPage - 1) * lineSize) ;
	rs = pstmt.executeQuery() ;
%>
<center>
<script type="text/javascript">
	function goPage(val) {	// 设置cp参数同时提交表单
		// 将传递进来的val的内容设置给cp参数
		document.getElementById("cp").value = val ;
		// 参数设置完成之后直接提交表单
		document.getElementById("splitForm").submit() ;
	}
</script>
<form action="<%=actionUrl%>" method="post" id="splitForm">
	<input type="button" value="首页" onclick="goPage(1)" <%=currentPage == 1?"disabled":""%>>
	<input type="button" value="上一页" onclick="goPage(<%=currentPage - 1%>)" <%=currentPage == 1?"disabled":""%>>
	<input type="button" value="下一页" onclick="goPage(<%=currentPage + 1%>)" <%=currentPage == pageSize?"disabled":""%>>
	<input type="button" value="尾页" onclick="goPage(<%=pageSize%>)" <%=currentPage == pageSize?"disabled":""%>>
	跳转到<select onchange="goPage(this.value)">
	<%
		for (int x = 1 ; x <= pageSize ; x ++) {
	%>
			<option value="<%=x%>" <%=currentPage==x?"selected":""%>><%=x%></option>
	<%
		}
	%>
	</select>页
	每页显示<select name="ls" onchange="goPage(1)">
	<%
		for (int x = 0 ; x < lineSizeData.length ; x ++) {
	%>
			<option value="<%=lineSizeData[x]%>" <%=lineSizeData[x]==lineSize?"selected":""%>><%=lineSizeData[x]%></option>
	<%
		}
	%>
	</select>条
	<input type="hidden" id="cp" name="cp" value="">
</form>
<table border="1" width="90%">
	<tr>
		<td>雇员编号</td>
		<td>姓名</td>
		<td>职位</td>
		<td>雇佣日期</td>
		<td>工资</td>
		<td>佣金</td>
	</tr>
<%	// 读取数据库之中的数据
	while (rs.next()) {
		int empno = rs.getInt(1) ;
		String ename = rs.getString(2) ;
		String job = rs.getString(3) ;
		Date hiredate = rs.getDate(4) ;
		double sal = rs.getDouble(5) ;
		double comm = rs.getDouble(6) ;
%>
		<tr>
			<td><%=empno%></td>
			<td><%=ename%></td>
			<td><%=job%></td>
			<td><%=hiredate%></td>
			<td><%=sal%></td>
			<td><%=comm%></td>
		</tr>
<%
	}
%>
</table>
</center>
<%	// 关闭数据库连接
	conn.close() ;
%>