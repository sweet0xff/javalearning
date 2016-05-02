<%@ page pageEncoding="GBK"%>
<%@ page import="java.sql.*"%>
<%!	// 定义数据库连接的常量信息
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	public static final String DBUSER = "scott" ;
	public static final String PASSWORD = "tiger" ;
%>
<%
	request.setCharacterEncoding("GBK") ;
%>
<%	// 定义分页的控制变量
	int currentPage = 1 ;	// 保存当前所在页
	int lineSize = 5 ;		// 每页显示的数据行
	String actionUrl = "emp_list.jsp" ;	// 参数的传递路径
	int allRecorders = 0 ;	// 总记录数
	String columnData = "雇员编号:empno|雇员姓名:ename|雇员职位:job" ;
	String column = null ;	// 定义模糊查询的列
	String keyWord = null ;	// 定义模糊查询的关键字
%>
<%
	column = request.getParameter("col") ;
	keyWord = request.getParameter("kw") ;
	if (column == null || "".equals(column)) {	// 没有内容
		column = "empno" ;	// 默认按照empno查询
	}
	if (keyWord == null || "".equals(keyWord)) {
		keyWord = "" ;	// 表示查询全部
	}
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

	String sql = "SELECT COUNT(empno) FROM emp WHERE " + column + " LIKE ?" ;
	pstmt = conn.prepareStatement(sql) ;
	pstmt.setString(1,"%"+keyWord+"%") ;
	rs = pstmt.executeQuery() ;
	if (rs.next()) {
		allRecorders = rs.getInt(1) ;
	}
	sql = "SELECT * FROM (SELECT empno,ename,job,hiredate,sal,comm,ROWNUM rn FROM emp WHERE " + column + " LIKE ? AND ROWNUM<=?) temp WHERE temp.rn>?" ;
	pstmt = conn.prepareStatement(sql) ;
	pstmt.setString(1,"%"+keyWord+"%") ;
	pstmt.setInt(2,currentPage * lineSize) ;
	pstmt.setInt(3,(currentPage - 1) * lineSize) ;
	rs = pstmt.executeQuery() ;
%>
<center>
<jsp:include page="split_page_plugin.jsp">
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="actionUrl" value="<%=actionUrl%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="columnData" value="<%=columnData%>"/>
	<jsp:param name="column" value="<%=column%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
</jsp:include>
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