<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String showUrl = basePath + "pages/front/goods/GoodsServletFront/show";
    String listUrl = basePath + "pages/front/goods/GoodsServletFront/list";
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
    <h1>商品列表</h1>
    <select onchange="goList('<%=listUrl%>',this.value)">
        <option value="0">======查看全部商品======</option>
        <c:forEach items="${allItems}" var="item">
            <option value="${item.iid}" ${item.iid==paramValue ? "selected" : ""}>${item.title}</option>
        </c:forEach>
    </select><br>
    <c:if test="${allGoods != null}" var="res">
        <div class="splitSearchDiv">
            <jsp:include page="/pages/split_page_plugin_search.jsp"/>
        </div>
        <c:forEach items="${allGoods}" var="goods">
            <table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2">
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td rowspan="4">
                        <a href="<%=showUrl%>?gid=${goods.gid}">
                            <img src="upload/goods/${goods.photo}" style="width: 100px">
                        </a>
                    </td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>商品名称:</strong></td>
                    <td><strong><a href="<%=showUrl%>?gid=${goods.gid}">${goods.title}</a></strong></td>
                    <td><strong>上架日期:</strong></td>
                    <td><strong>${goods.pubdate}</strong></td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>商品价格:</strong></td>
                    <td><strong>${goods.price}</strong></td>
                    <td><strong>浏览次数:</strong></td>
                    <td><strong>${goods.bow}</strong></td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td colspan="3">
                            ${goods.note}
                    </td>
                    <td>
                        <a href="<%=addCarUrl%>?gid=${goods.gid}">加入购物车</a>
                    </td>
                </tr>
            </table>
        </c:forEach>
        <div id="splitBarDiv" style="float: right;padding: 10px">
            <jsp:include page="/pages/split_page_plugin_bars.jsp"/>
        </div>
    </c:if>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>
