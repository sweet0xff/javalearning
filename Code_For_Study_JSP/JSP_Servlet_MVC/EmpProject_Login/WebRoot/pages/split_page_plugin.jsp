<%@ page pageEncoding="UTF-8"%>
<%--	引用操作形式
<jsp:include page="split_page_plugin.jsp">
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="actionUrl" value="<%=actionUrl%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="columnData" value="<%=columnData%>"/>
	<jsp:param name="column" value="<%=column%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
</jsp:include>

如果不传递columnData则表示不使用检索功能
--%>
<%
	request.setCharacterEncoding("UTF-8") ;
%>
<%	// 定义分页的控制变量
	int currentPage = 1 ;	// 保存当前所在页
	int lineSize = 5 ;		// 每页显示的数据行
	String actionUrl = null ;	// 参数的传递路径
	int allRecorders = 0 ;	// 总记录数
	int pageSize = 0 ;	// 总页数，需要计算得来
	int lineSizeData [] = new int [] {1,2,5,10,20,30,50,80,100} ;
	String columnData = null ;
	String column = null ;	// 定义模糊查询的列
	String keyWord = null ;	// 定义模糊查询的关键字
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
	if (allRecorders == 0) {	// 没有任何的记录
		pageSize = 1 ;	// 总页数设置为第一页
	}  else {
		pageSize = (allRecorders + lineSize - 1) / lineSize ;
	}
%>
<script type="text/javascript">
	function goPage(val) {	// 设置cp参数同时提交表单
		// 将传递进来的val的内容设置给cp参数
		document.getElementById("cp").value = val ;
		// 参数设置完成之后直接提交表单
		document.getElementById("splitForm").submit() ;
	}
</script>
<form action="<%=actionUrl%>" method="post" id="splitForm">
<%
	if (columnData != null) {	// 有查询要求
%>
	请输入查询关键字：
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
	<input type="submit" value="检索"><br>
<%
	}
%>
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
	<input type="hidden" id="deptno" name="deptno" value="<%=request.getParameter("deptno")%>">
</form>
