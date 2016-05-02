<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String insertUrl = basePath +"pages/back/admin/item/ItemServletBack/insert";
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
    <form action="<%=insertUrl%>" method="post" onsubmit="return validateItem()">
        <table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2">
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td colspan="3">增加商品类别</td>
            </tr>
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td style="width: 10%"><strong>标题:</strong></td>
                <td style="width: 50%"><input type="text" name="title" id="title" onblur="validateTitle()"></td>
                <td style="width: 40%"><span id="titleMsg"></span></td>
            </tr>
            <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                <td colspan="3">
                    <input type="submit" value="增加">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
