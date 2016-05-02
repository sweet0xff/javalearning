<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.oracle.vo.*"%>
<%@ page import="cn.mldn.oracle.factory.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%	// 解决POST请求的乱码
	request.setCharacterEncoding("UTF-8") ;
%>
<html>
<head>
<title>雇员管理程序</title>
<script type="text/javascript" src="<%=basePath%>js/util.js"></script>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<body>
<%	// 定义分页的控制变量
	int currentPage = 1 ;	// 保存当前所在页
	int lineSize = 5 ;		// 每页显示的数据行
	String actionUrl = "emp_list_details.jsp" ;	// 参数的传递路径
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
	if("GET".equalsIgnoreCase(request.getMethod())) {	// 判断请求方式
		keyWord = java.net.URLDecoder.decode(keyWord, "UTF-8") ;
	}
	try {
		currentPage = Integer.parseInt(request.getParameter("cp")) ;
	} catch (Exception e) {}
	try {
		lineSize = Integer.parseInt(request.getParameter("ls")) ;
	} catch (Exception e) {}
%>
<%	// 查询表中的全部数据，返回的是List集合，所以一定使用Iterator输出
	Map<String,Object> map = ServiceBackFactory.getIEmpServiceBackInstance().listDetails(column,keyWord,currentPage,lineSize) ;
	List<Emp> all = (List<Emp>) map.get("allEmps") ;
	allRecorders = (Integer) map.get("empCount") ;
	Iterator<Emp> iter = all.iterator() ;
%>
<%String backUrl = basePath + "/pages/back/admin/emp/" + actionUrl ;%>
<center>
<h1>雇员基本列表</h1>
<jsp:include page="/pages/split_page_plugin.jsp">
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="actionUrl" value="<%=actionUrl%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="columnData" value="<%=columnData%>"/>
	<jsp:param name="column" value="<%=column%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
</jsp:include>
<form action="emp_delete_batch_do.jsp" method="post" onsubmit="return deleteBatchConfirm('empno')">
<table border="1" width="90%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input type="checkbox" name="all" id="all" onClick="selectAll('all','empno')">		</td>
		<td align="center" valign="middle"><strong>雇员编号</strong></td>
		<td align="center" valign="middle"><strong>姓名</strong></td>
		<td align="center" valign="middle"><strong>职位</strong></td>
		<td align="center" valign="middle"><strong>领导</strong></td>
		<td align="center" valign="middle"><strong>部门</strong></td>
		<td align="center" valign="middle"><strong>雇佣日期</strong></td>
		<td align="center" valign="middle"><strong>基本工资</strong></td>
		<td align="center" valign="middle"><strong>佣金</strong></td>
		<td colspan="2" align="center" valign="middle"><strong>操作</strong></td>
	</tr>
<%
	while (iter.hasNext()) {
		Emp vo = iter.next() ;
%>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input name="empno" type="checkbox" id="empno" value="<%=vo.getEmpno()%>|<%=vo.getPhoto()%>">		</td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getEmpno()%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/emp/emp_show.jsp?empno=<%=vo.getEmpno()%>','雇员信息',800,600)"><%=vo.getEname()%></a>
		</span></td> 
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getJob()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/emp/emp_show.jsp?empno=<%=vo.getMgr().getEmpno()%>','雇员信息',800,600)"><%=vo.getMgr().getEname()==null?"":vo.getMgr().getEname()%></a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/dept/dept_show.jsp?deptno=<%=vo.getDept().getDeptno()%>','部门信息',1200,800)"><%=vo.getDept().getDname()%></a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getHiredate()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getSal()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2"><%=vo.getComm()%></span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="<%=basePath%>/pages/back/admin/emp/emp_update.jsp?empno=<%=vo.getEmpno()%>&backUrl=<%=backUrl%>&cp=<%=currentPage%>&ls=<%=lineSize%>&col=<%=column%>&kw=<%=keyWord%>">修改</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a href="<%=basePath%>/pages/back/admin/emp/emp_delete_do.jsp?empno=<%=vo.getEmpno()%>&backUrl=<%=backUrl%>&cp=<%=currentPage%>&ls=<%=lineSize%>&col=<%=column%>&kw=<%=keyWord%>&pic=<%=vo.getPhoto()%>" onclick="return deleteConfirm()">删除</a> 
		</span></td>
	</tr> 
<%
	}
%>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="11" align="right">
			<input type="hidden" name="cp" value="<%=currentPage%>">
			<input type="hidden" name="ls" value="<%=lineSize%>">
			<input type="hidden" name="col" value="<%=column%>">
			<input type="hidden" name="kw" value="<%=keyWord%>">
			<input type="hidden" name="backUrl" value="<%=basePath%>/pages/back/admin/emp/<%=actionUrl%>">
			<input type="submit" value="批量删除">		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>
