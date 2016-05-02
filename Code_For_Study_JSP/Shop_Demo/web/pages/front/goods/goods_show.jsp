<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateUrl = basePath + "pages/back/admin/goods/GoodsServletBack/update";
    String addCarUrl  = basePath + "pages/front/shopcar/ShopcarServletFront/insert";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>微商城综合实战</title>
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<div class="mainDiv">
    <c:if test="${goods != null}" var="res">
        <form action="<%=updateUrl%>" method="post" onsubmit="return validateGoods()" enctype="multipart/form-data">
            <table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2">
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td style="width: 10%"><strong>商品名称:</strong></td>
                    <td style="width: 30%">${goods.title}</td>
                    <td style="width: 20%" rowspan="8">
                        <div><img src="upload/goods/${goods.photo}"></div>
                    </td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>所属分类:</strong></td>
                    <td>
                            ${goods.item.title}
                    </td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>商品价格:</strong></td>
                    <td>${goods.price}</td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>上架日期:</strong></td>
                    <td>${goods.pubdate}</td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>库存数量:</strong></td>
                    <td>${goods.amount}</td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>浏览次数:</strong></td>
                    <td>${goods.bow}</td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td colspan="2">
                            ${goods.note}
                    </td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td colspan="2">
                        <a href="<%=addCarUrl%>?gid=${goods.gid}">加入购物车</a>
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>
