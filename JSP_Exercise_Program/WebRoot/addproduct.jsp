<%@page import="org.xxx.model.entity.*"%>
<%@page import="org.xxx.model.service.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title></title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<script type="application/javascript">
	
	
	
			$(function() {
				$("nav ul li").each(function() {
					$(this).children().click(function() {
						$(this).parent().addClass("active");
						$(this).parent().siblings().removeClass("active");
					});
				});
			});
		


</script>
</head>
<body>

	<!--导航栏-->
	<div class="row">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="nav-header">
					<a class="navbar-brand" href="storePage.jsp">商家的主页</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav" id="nav">
						<li class="active"><a href="#productManage">添加商品</a></li>
						<!--<li><a href="#orderManage">订单管理</a></li>-->
					</ul>
					<p class="navbar-text navbar-right">
						Signed in as <a href="#" class="navbar-link">${currentStore.sName
							}</a>
					</p>
				</div>
			</div>
		</nav>
	</div>
	<!--导航栏-->
	<!--内容-->
	<div class="container" style="margin-top:100px;">
		<div class="row">
			<div>
				<div class="panel panel-primary" name="productManage">
					<div class="panel-heading">
						<h3 class="panel-title">添加商品</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal col-md-12" action="AddProductServlet"
							method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label class="col-sm-2 control-label">商品名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="pname">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">价格</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="price">
									<span class="input-group-addon">￥</span>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">折扣</label>
								<div class="col-sm-10">
									<div class="input-group">
										<input type="text" class="form-control" name="discount">
										<span class="input-group-addon">%</span>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">商品描述</label>
								<div class="col-sm-10">
									<textarea class="form-control" rows="3" name="describe"></textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">商品类型</label>
								<div class="col-sm-10">
									<select class="form-control" name="type">
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">图片上传</label>
								<div class="col-sm-10">
									<input type="file" name="image" class="form-control">
								</div>
							</div>

							<div class="col-sm-2 col-md-offset-4">
								<input type="submit" class="btn btn-primary" value="Submit">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>