<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
</head>
  
<body>

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
