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
<link type="text/css" href="<%=basePath%>css/form_css.jsp" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/util.js"></script>
<script type="text/javascript" src="<%=basePath%>js/dept.js"></script>
<script type="text/javascript">
	var backUrl = "<%=basePath%>/pages/back/admin/dept/dept_list_details.jsp" ;
</script>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<body>
<%	// 查询表中的全部数据，返回的是List集合，所以一定使用Iterator输出
	List<Dept> all = ServiceBackFactory.getIDeptServiceBackInstance().listDetails() ;
	Iterator<Dept> iter = all.iterator() ;
%>
<center>
<h1>部门详细列表</h1>
<table border="1" width="100%" cellpadding="5" cellspacing="0"
				bgcolor="F2F2F2">
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input type="checkbox" name="all" id="all" onClick="selectAll('all','deptno')">		</td>
		<td align="center" valign="middle"><strong>编号</strong></td>
		<td align="center" valign="middle"><strong>名称</strong></td>
		<td align="center" valign="middle"><strong>位置</strong></td>
		<td align="center" valign="middle"><strong>人数</strong></td>
		<td align="center" valign="middle"><strong>总工资</strong></td>
		<td align="center" valign="middle"><strong>平均工资</strong></td>
		<td align="center" valign="middle"><strong>最高工资</strong></td>
		<td align="center" valign="middle"><strong>最低工资</strong></td>
		<td align="center" valign="middle"><strong>平均服务年限</strong></td>
		<td align="center" valign="middle"><strong>操作</strong></td>
	</tr>
<%
	while (iter.hasNext()) {
		Dept vo = iter.next() ;
%>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td align="center" valign="middle">
			<input name="deptno" type="checkbox" id="deptno" value="<%=vo.getDeptno()%>">		</td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getDeptno()%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a href="#" onclick="openWindow('<%=basePath%>/pages/back/admin/dept/dept_show.jsp?deptno=<%=vo.getDeptno()%>','部门信息',1000,600)"><%=vo.getDname()%></a>
		</span></td> 
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getLoc()%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getStat().get("count")%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getStat().get("sum")%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getStat().get("avg")%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a onclick="openWindow('<%=basePath%>/pages/back/admin/emp/emp_sal_list.jsp?deptno=<%=vo.getDeptno()%>&sal=<%=vo.getStat().get("max")%>','部门信息',1000,600)" href="#"><%=vo.getStat().get("max")%></a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<a onclick="openWindow('<%=basePath%>/pages/back/admin/emp/emp_sal_list.jsp?deptno=<%=vo.getDeptno()%>&sal=<%=vo.getStat().get("min")%>','部门信息',1000,600)" href="#"><%=vo.getStat().get("min")%></a>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2">
			<%=vo.getStat().get("avgyear")%>
		</span></td>
		<td align="center" valign="middle"><span class="STYLE2"> 
			<a href="<%=basePath%>/pages/back/admin/emp/emp_insert.jsp?deptno=<%=vo.getDeptno()%>">增加新雇员</a> 
		</span></td>
	</tr>
<%
	}
%>
	<tr onMouseOver="changeColor(this,'white')"
		onMouseOut="changeColor(this,'F2F2F2')">
		<td colspan="11" align="right">
			<input type="button" value="批量删除" onclick="deleteBatchHandle('deptno','<%=basePath%>/pages/back/admin/dept/dept_delete_batch_do.jsp')">		
		</td>
	</tr>
</table>
</center>
</body>
</html>
