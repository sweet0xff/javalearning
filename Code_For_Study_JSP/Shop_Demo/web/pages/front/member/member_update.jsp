<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updateUrl = basePath + "pages/front/member/MemberInfoServletFront/update";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>微商城综合实战</title>
    <link type="text/css" rel="stylesheet" href="css/mldn.css">
    <script type="text/javascript" src="js/mldn.js"></script>
    <script type="text/javascript" src="js/member.js"></script>
    <style type="text/css">
        #preview, .img, img  {
            width:200px;
            height:200px;
        }
        #preview {
            border:1px solid #000;
        }
    </style>
    <script type="text/javascript">
        function preview(file) {
            var prevDiv = document.getElementById('preview');
            if (file.files && file.files[0]) {
                var reader = new FileReader();
                reader.onload = function(evt) {
                    prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
                }
                reader.readAsDataURL(file.files[0]);
            } else {
                prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
            }
        }
    </script>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<div class="mainDiv">
    ${member.name}
    <c:if test="${member != null}">
        <form action="<%=updateUrl%>" method="post" enctype="multipart/form-data" onsubmit="return validateUpdate()">
            <table border="1" width="100%" cellpadding="5" cellspacing="0" bgcolor="#F2F2F2">
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td colspan="4">用户个人信息</td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td style="width: 10%"><strong>用户ID:</strong></td>
                    <td style="width: 40%">${member.mid}</td>
                    <td style="width: 50%"><span id="midMsg"></span></td>
                    <td rowspan="5"><div id="preview"><img src="upload/member/${member.photo}" style="width: 100px;"></div></td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>真实姓名:</strong></td>
                    <td><input type="text" name="name" id="name" value="${member.name}" onblur="validateName()"></td>
                    <td><span id="nameMsg"></span></td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>联系电话:</strong></td>
                    <td><input type="text" name="phone" id="phone" value="${member.phone}" onblur="validatePhone()"></td>
                    <td><span id="phoneMsg"></span></td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>联系地址:</strong></td>
                    <td><input type="text" name="address" id="address" value="${member.address}" onblur="validateAddress()"></td>
                    <td><span id="addressMsg"></span></td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td><strong>个人靓照:</strong></td>
                    <td><input type="file" name="photo" id="regdate" value="${member.photo}"></td>
                    <td><span id="photoMsg"></span></td>
                </tr>
                <tr onmouseover="changeColor(this,'white')" onmouseout="changeColor(this,'#F2F2F2')">
                    <td colspan="4">
                        <input type="hidden" name="oldpic" id="oldpic" value="${member.photo}">
                        <input type="submit" value="更新">
                        <input type="reset" value="重置">
                    </td>
                </tr>
            </table>
        </form>
    </c:if>
</div>
<jsp:include page="/pages/footer.jsp"/>
</body>
</html>
