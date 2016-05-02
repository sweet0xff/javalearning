<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    int currentPage = 1;
    int lineSize = 5;
    String column = null;
    String keyWord = null;
    int allRecorders = 0;
    int lsDate[] = new int[]{1,5, 10, 15, 20, 25, 35, 50, 100};
    int pageSize = 0;  // 表示总页数
    String url = null;
    String paramName = request.getParameter("paramName");
    String paramValue = request.getParameter("paramValue");
%>
<%
    // 接受传递的参数
    try {
        currentPage = (Integer)request.getAttribute("currentPage");
    } catch (Exception e) {
    }
    try {
        lineSize = (Integer)request.getAttribute("lineSize");
    } catch (Exception e) {
    }
    try {
        allRecorders = (Integer)request.getAttribute("allRecorders");
    } catch (Exception e) {
    }
    column = (String) request.getAttribute("column");
    keyWord = (String) request.getAttribute("keyword");
    url = basePath + (String) request.getAttribute("url");
%>
<%
    //     对数据进行处理
    if (currentPage <= 0) {
        currentPage = 1;
    }
    if (allRecorders > 0) {
        pageSize = (allRecorders + lineSize - 1) / lineSize;
    } else {
        pageSize = 1;
    }
%>
<input type="button" value="首页" onclick="goSplit(1)" <%=currentPage == 1?"disabled":""%>>
<input type="button" value="上一页" onclick="goSplit(<%=currentPage%> -1)" <%=currentPage == 1?"disabled":""%>>
<input type="button" value="下一页" onclick="goSplit(<%=currentPage%> + 1)" <%=currentPage == pageSize?"disabled":""%> >
<input type="button" value="尾页" onclick="goSplit(<%=pageSize%>)" <%=currentPage == pageSize?"disabled":""%>>
跳转到<select id="cpSel" onchange="goSplit(this.value)">
<%
    for (int x = 1; x <= pageSize; x++) {
%>
<option value="<%=x%>" <%=currentPage == x ? "selected" : ""%>><%=x%>
</option>
<%
    }
%>
</select>页
每页显示<select id="lsSel" onchange="goSplit(1)">
<%
    for (int x = 0; x < lsDate.length; x++) {
%>
<option value="<%=lsDate[x]%>" <%=lsDate[x] == lineSize ? "selected" : ""%>><%=lsDate[x]%>
</option>
<%
    }
%>
</select>条
<script type="text/javascript">
    function goSplit(vcp) { // 根据外表传递的cp内容进行操作
        var eleLs = document.getElementById("lsSel").value;
        try {
            var eleKw = document.getElementById("kw").value;
            var eleCol = document.getElementById("colSel").value;
            window.location = "${url}?cp=" + vcp + "&ls=" + eleLs + "&kw=" + eleKw + "&col=" + eleCol + "&<%=paramName%>=<%=paramValue%>";
        } catch (Exception) {
            window.location = "${url}?cp=" + vcp + "&ls=" + eleLs + "&<%=paramName%>=<%=paramValue%>";
        }
    }
</script>