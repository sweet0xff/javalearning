<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + 
					request.getServerName() + ":" +
					request.getServerPort() + path + "/";
%>
<html>
<head>
	<base href = "<%=basePath %>">
    <title>轻奢潮流购物网后台登录界面</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,inital-scale=1">
    <%-- 由于Bootstrap要基于jQuery完成，所以需要先导入jQuery的开发包 --%>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/adminlogin.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>

<body>
<div class="container">
    <%-- 由于本次的编写需要基于表单，同时还需要考虑到数据验证的问题，那么就可以不写row样式 --%>
    <form id="loginForm" action="AdminLoginServlet" method="post" class="form-horizontal">
        <fieldset>
            <legend ><label><span class="glyphicon glyphicon-user"></span>&nbsp;管理员登录界面</label></legend>
            <%-- 描述mid输入信息的内容 --%>
            <div class="form-group" id="midDiv">
                <label class="col-md-3 control-label" for="mid">账号：</label>
                <div class="col-md-5">
                    <%-- id是为JavaScript服务的，而name是为了JSP的接收数据服务的 --%>
                    <input type="text" id="mid" name="mid" class="form-control" placeholder="请输入登录名">
                </div>
                <div class="col-md-4" id="midSpan"></div>
            </div>
            <div class="form-group" id="passwordDiv">
                <label class="col-md-3 control-label" for="password">密码：</label>
                <div class="col-md-5">
                    <%-- id是为JavaScript服务的，而name是为了JSP的接收数据服务的 --%>
                    <input type="password" id="password" name="password" class="form-control" placeholder="请输入登录密码">
                </div>
                <div class="col-md-4" id="passwordSpan"></div>
            </div>
            <div class="form-group" id="butDiv">
                <div class="col-md-5 col-md-offset-3">
                    <button type="submit" id="subBut" class="btn btn-xs btn-primary">登录</button>
                    <button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<div>
	<h1>${message }</h1>
</div>
</body>
</html>
