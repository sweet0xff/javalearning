<%@ page pageEncoding="GBK"%>
<%@ page import="java.sql.*"%>
<%!	// �������ݿ����ӵĳ�����Ϣ
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	public static final String DBUSER = "scott" ;
	public static final String PASSWORD = "tiger" ;
%>
<%	// �����ҳ�Ŀ��Ʊ���
	int currentPage = 1 ;	// ���浱ǰ����ҳ
	int lineSize = 5 ;		// ÿҳ��ʾ��������
	String actionUrl = "emp_list.jsp" ;	// �����Ĵ���·��
	int allRecorders = 0 ;	// �ܼ�¼��
	int pageSize = 0 ;	// ��ҳ������Ҫ�������
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
<%	// ��������Ҫ�Ķ���
	Connection conn ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>
<%	// �������ݿ�����Ӳ���
	Class.forName(DBDRIVER) ;
	conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD) ;

	String sql = "SELECT COUNT(empno) FROM emp " ;
	pstmt = conn.prepareStatement(sql) ;
	rs = pstmt.executeQuery() ;
	if (rs.next()) {
		allRecorders = rs.getInt(1) ;
	}
	if (allRecorders == 0) {	// û���κεļ�¼
		pageSize = 1 ;	// ��ҳ������Ϊ��һҳ
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
	function goPage(val) {	// ����cp����ͬʱ�ύ��
		// �����ݽ�����val���������ø�cp����
		document.getElementById("cp").value = val ;
		// �����������֮��ֱ���ύ��
		document.getElementById("splitForm").submit() ;
	}
</script>
<form action="<%=actionUrl%>" method="post" id="splitForm">
	<input type="button" value="��ҳ" onclick="goPage(1)" <%=currentPage == 1?"disabled":""%>>
	<input type="button" value="��һҳ" onclick="goPage(<%=currentPage - 1%>)" <%=currentPage == 1?"disabled":""%>>
	<input type="button" value="��һҳ" onclick="goPage(<%=currentPage + 1%>)" <%=currentPage == pageSize?"disabled":""%>>
	<input type="button" value="βҳ" onclick="goPage(<%=pageSize%>)" <%=currentPage == pageSize?"disabled":""%>>
	��ת��<select onchange="goPage(this.value)">
	<%
		for (int x = 1 ; x <= pageSize ; x ++) {
	%>
			<option value="<%=x%>" <%=currentPage==x?"selected":""%>><%=x%></option>
	<%
		}
	%>
	</select>ҳ
	ÿҳ��ʾ<select name="ls" onchange="goPage(1)">
	<%
		for (int x = 0 ; x < lineSizeData.length ; x ++) {
	%>
			<option value="<%=lineSizeData[x]%>" <%=lineSizeData[x]==lineSize?"selected":""%>><%=lineSizeData[x]%></option>
	<%
		}
	%>
	</select>��
	<input type="hidden" id="cp" name="cp" value="">
</form>
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