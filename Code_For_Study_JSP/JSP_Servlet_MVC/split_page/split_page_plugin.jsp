<%@ page pageEncoding="GBK"%>
<%--	���ò�����ʽ
<jsp:include page="split_page_plugin.jsp">
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="actionUrl" value="<%=actionUrl%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="columnData" value="<%=columnData%>"/>
	<jsp:param name="column" value="<%=column%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
</jsp:include>

���������columnData���ʾ��ʹ�ü�������
--%>
<%
	request.setCharacterEncoding("GBK") ;
%>
<%	// �����ҳ�Ŀ��Ʊ���
	int currentPage = 1 ;	// ���浱ǰ����ҳ
	int lineSize = 5 ;		// ÿҳ��ʾ��������
	String actionUrl = null ;	// �����Ĵ���·��
	int allRecorders = 0 ;	// �ܼ�¼��
	int pageSize = 0 ;	// ��ҳ������Ҫ�������
	int lineSizeData [] = new int [] {1,2,5,10,20,30,50,80,100} ;
	String columnData = null ;
	String column = null ;	// ����ģ����ѯ����
	String keyWord = null ;	// ����ģ����ѯ�Ĺؼ���
%>
<%
	column = request.getParameter("column") ;
	keyWord = request.getParameter("keyWord") ;
	actionUrl = request.getParameter("actionUrl") ;
	columnData = request.getParameter("columnData") ;
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
	} catch (Exception e) {}
	try {
		lineSize = Integer.parseInt(request.getParameter("lineSize")) ;
	} catch (Exception e) {}
	try {
		allRecorders = Integer.parseInt(request.getParameter("allRecorders")) ;
	} catch (Exception e) {}
%>
<%
	if (allRecorders == 0) {	// û���κεļ�¼
		pageSize = 1 ;	// ��ҳ������Ϊ��һҳ
	}  else {
		pageSize = (allRecorders + lineSize - 1) / lineSize ;
	}
%>
<script type="text/javascript">
	function goPage(val) {	// ����cp����ͬʱ�ύ��
		// �����ݽ�����val���������ø�cp����
		document.getElementById("cp").value = val ;
		// �����������֮��ֱ���ύ��
		document.getElementById("splitForm").submit() ;
	}
</script>
<form action="<%=actionUrl%>" method="post" id="splitForm">
<%
	if (columnData != null) {	// �в�ѯҪ��
%>
	�������ѯ�ؼ��֣�
	<select name="col" id="col">
	<%
		String result [] = columnData.split("\\|") ;
		for (int x = 0 ; x < result.length ; x ++) {
			String temp[] = result[x].split(":") ;
	%>
			<option value="<%=temp[1]%>" <%=column.equals(temp[1])?"selected":""%>><%=temp[0]%></option>
	<%
		}
	%>
	</select>
	<input type="text" name="kw" id="kw" value="<%=keyWord%>">
	<input type="submit" value="����"><br>
<%
	}
%>
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
