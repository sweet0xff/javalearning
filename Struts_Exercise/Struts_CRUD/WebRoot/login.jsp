<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
</head>

<body>
<div class="container">

    <form id="loginForm" action="admin_login.action" method="post" class="form-horizontal">
        <fieldset>
            <legend><label><span class="glyphicon glyphicon-user"></span>&nbsp;管理员登录</label></legend>

            <div class="form-group" id="midDiv">
                <label class="col-md-3 control-label" for="mid">用户名：</label>
                <div class="col-md-5">

                    <input type="text" id="mid" name="admin.aname" class="form-control" placeholder="请输入登录名">
                </div>
                <div class="col-md-4" id="midSpan"></div>
            </div>
            <div class="form-group" id="passwordDiv">
                <label class="col-md-3 control-label" for="password">密码：</label>
                <div class="col-md-5">

                    <input type="password" id="password" name="admin.apassword" class="form-control" placeholder="请输入登录密码">
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
</body>
</html>