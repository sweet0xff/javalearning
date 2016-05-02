<%@ page pageEncoding="GBK"%>
<%@ page import="java.sql.*"%>
<%!	// �������ݿ����ӵĳ�����Ϣ
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	public static final String DBUSER = "scott" ;
	public static final String PASSWORD = "tiger" ;
%>
<%
	request.setCharacterEncoding("GBK") ;
%>
<%	// �����ҳ�Ŀ��Ʊ���
	int currentPage = 1 ;	// ���浱ǰ����ҳ
	int lineSize = 5 ;		// ÿҳ��ʾ��������
	String actionUrl = "emp_list.jsp" ;	// �����Ĵ���·��
	int allRecorders = 0 ;	// �ܼ�¼��
	String columnData = "��Ա���:empno|��Ա����:ename|��Աְλ:job" ;
	String column = null ;	// ����ģ����ѯ����
	String keyWord = null ;	// ����ģ����ѯ�Ĺؼ���
%>
<%
	column = request.getParameter("col") ;
	keyWord = request.getParameter("kw") ;
	if (column == null || "".equals(column)) {	// û������
		column = "empno" ;	// Ĭ�ϰ���empno��ѯ
	}
	if (keyWord == null || "".equals(keyWord)) {
		keyWord = "" ;	// ��ʾ��ѯȫ��
	}
	try {
		currentPage = Integer.parseInt(request.getParameter("cp")) ;
	} catch (Exception e) {}
	try {
		lineSize = Integer.parseInt(request.getParameter("ls")) ;
	} catch (Exception e) {}
%>
<%	// ��������Ҫ�Ķ���
	Connection conn ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>
<%	// �������ݿ�����Ӳ���
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
		<td>��Ա���</td>
		<td>����</td>
		<td>ְλ</td>
		<td>��Ӷ����</td>
		<td>����</td>
		<td>Ӷ��</td>
	</tr>
<%	// ��ȡ���ݿ�֮�е�����
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
<%	// �ر����ݿ�����
	conn.close() ;
%>