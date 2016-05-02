<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateUrl = basePath + "pages/back/admin/item/ItemServletBack/update";
    String deleteUrl = basePath + "pages/back/admin/item/ItemServletBack/delete?p=p";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>微商城综合实战</title>
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/item.js"></script>
</head>
<body>
<div class="mainDiv">
    <c:if test="${allItems !=null}" var="item">
        <table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2">
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td colspan="4"><span class="title">商品分类列表</span></td>
            </tr>
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td style="width: 20%"><input type="checkbox" onclick="checkboxSelect(this,'tiid')"></td>
                <td style="width: 70%"><strong>标题:</strong></td>
                <td style="width: 10%;text-align: center"><strong>操作</strong></td>
            </tr>
            <c:forEach items="${allItems}" var="item">
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><input type="checkbox" name="tiid" id="tiid" value="${item.iid}"></td>
                    <td>
                        <input type="text" name="title-${item.iid}" id="title-${item.iid}" value="${item.title}">
                        <span id="title-${item.iid}Msg"></span>
                    </td>
                    <td><input type="button" value="修改" onclick="goUpdate(${item.iid})"></td>
                </tr>
            </c:forEach>
        </table>
        <input type="button" value="删除商品分类信息" onclick="deleteAll('<%=deleteUrl%>','ids','tiid')">
    </c:if>
</div>
<form id="itemForm" method="post" action="<%=updateUrl%>">
    <input type="hidden" name="iid" id="iid">
    <input type="hidden" name="title" id="title">
</form>
</body>
</html>
