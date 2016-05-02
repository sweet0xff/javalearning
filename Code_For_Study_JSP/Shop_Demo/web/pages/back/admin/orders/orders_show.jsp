<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String showUrl = basePath + "/pages/back/admin/orders/OrdersServletBack/show";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>微商城综合实战</title>
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
</head>
<body>
<div class="mainDiv">
    <c:if test="${orders != null}" var="res">
        <table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2">
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td>订单编号</td>
                <td>${orders.oid}</td>
                <td>订单金额</td>
                <td>${orders.pay}</td>
                <td>下单时间</td>
                <td>${orders.credate}</td>
            </tr>
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td>收件人</td>
                <td>${orders.name}</td>
                <td>联系电话</td>
                <td>${orders.phone}</td>
                <td>收件地址</td>
                <td>${orders.address}</td>
            </tr>
        </table>
        <hr>
        <table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2">
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td>商品名称</td>
                <td>商品单价</td>
                <td>购买数量</td>
            </tr>
            <c:forEach items="${orders.allDetails}" var="orders">
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><a href="<%=showUrl%>?gid=${orders.goods.gid}">${orders.title}</a></td>
                    <td>${details.price}</td>
                    <td>${details.amount}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
