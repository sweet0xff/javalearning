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
</head>

<body>
<%	// 接收要删除数据的编号 
	String empno [] = request.getParameterValues("empno") ;
	Set<Integer> set = new HashSet<Integer>() ;
	List<String> all = new ArrayList<String>() ;	// 保存要删除的图片名称
	for (int x = 0 ; x < empno.length ; x ++) {
		String temp [] = empno[x].split("\\|") ;
		set.add(Integer.parseInt(temp[0])) ;
		if (!"nophoto.jpg".equals(temp[1])) {	// 不是nophoto.jpg
			all.add(temp[1]) ;	// 要删除的图片名称
		}
	}
%>
<%
	String msg = "雇员信息删除失败！" ;
	if (ServiceBackFactory.getIEmpServiceBackInstance().deleteBatch(set)) {
		Iterator<String> iter = all.iterator() ;
		while (iter.hasNext()) {
			String photoPath = this.getServletContext().getRealPath(
					"/photo")
				+ java.io.File.separator + iter.next() ;
			java.io.File file = new java.io.File(photoPath) ;
			if (file.exists()) {	// 文件存在
				file.delete() ;
			}
		}
		msg = "雇员信息删除成功！" ;
	}
	StringBuffer buf = new StringBuffer() ;
	buf.append(request.getParameter("backUrl")).append("?") ;
	buf.append("cp=").append(request.getParameter("cp")).append("&") ;
	buf.append("ls=").append(request.getParameter("ls")).append("&") ;
	buf.append("col=").append(request.getParameter("col")).append("&") ;
	buf.append("kw=").append(request.getParameter("kw"));
%>
<script type="text/javascript">
	alert("<%=msg%>") ;
	window.location = "<%=buf%>" ;
</script>
</body>
</html>
