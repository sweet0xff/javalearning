<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String loginUrl = basePath + "pages/MemberServletFront/login";

%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>微商城综合实战</title>
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/member.js"></script>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<div class="mainDiv">

    <form action="<%=loginUrl%>" method="post" onsubmit="return validateLogin()">
        <table border="1" width="100%" bgcolor="#F2F2F2" cellspacing="0" cellpadding="5">
            <tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
                <td colspan="3">用户登录</td>
            </tr>
            <tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
                <td style="width: 20%;">用户名</td>
                <td style="width: 50%;"><input type="text" name="mid" id="mid" onblur="validateMid()"></td>
                <td><span id="midMsg"></span></td>
            </tr>
            <tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
                <td style="width: 20%;">密&nbsp;&nbsp;码</td>
                <td style="width: 50%;"><input type="password" name="password" id="password"
                                               onblur="validatePassword()"></td>
                <td><span id="passwordMsg"></span></td>
            </tr>
            <tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
                <td style="width: 20%;">验证码</td>
                <td style="width: 50%;"><input type="text" name="code" id="code" maxlength="4" size="4"
                                               onblur="validateCode()"> <img src="pages/image.jsp"></td>
                <td><span id="codeMsg"></span></td>
            </tr>
            <tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
                <td colspan="3">
                    <input type="checkbox" name="reme" id="reme" value="7760000">&nbsp;记住密码
                </td>
            </tr>
            <tr onmouseover="changeColor(this,'#FFFFFF')" onmouseout="changeColor(this,'#F2F2F2')">
                <td colspan="3">
                    <input type="submit" value="登录">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>
