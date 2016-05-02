<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/mldn.css">
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
    int pageSize = 0;
    String url = null;
    int seed = 2;// 种子数
    String paramName = (String) request.getAttribute("paramName");
    String paramValue = (String) request.getAttribute("paramValue");
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
        allRecorders =(Integer)request.getAttribute("allRecorders");
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
<script type="text/javascript">
    function goSplit(vcp) { // 根据外表传递的cp内容进行操作
//        var eleLs = document.getElementById("lsSel").value;
        try {
            var eleKw = document.getElementById("kw").value;
            var eleCol = document.getElementById("colSel").value;
            window.location = "<%=url%>?cp=" + vcp + "&ls=" + <%=lineSize%> +"&kw=" + eleKw + "&col=" + eleCol + "&<%=paramName%>=<%=paramValue%>";
        } catch (Exception) {
            window.location = "<%=url%>?cp=" + vcp + "&ls=" + <%=lineSize%>+"&<%=paramName%>=<%=paramValue%>";
        }
    }
</script>
<ul class="pagination">
    <%
        if (pageSize > seed * 3) {
    %>
    <li class="<%=currentPage == 1?"active":""%>"><a onclick="goSplit(1)">1
    </a></li>
    <%
        if (currentPage > seed * 2) {
    %>
    <li><span>...</span></li>
    <%
        int startPage = currentPage - seed;
        int endPage = currentPage + seed;
        for (int x = startPage; x < endPage; x++) {
            if (x < pageSize) {
    %>
    <li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%>
    </a></li>
    <%
            }
        }
        if (currentPage + seed * 2 < pageSize) {
    %>
    <li><span>...</span></li>
    <%
        }
    } else {
        for (int x = 2; x < currentPage + seed; x++) {
    %>
    <li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%>
    </a></li>
    <%
        if (currentPage + seed * 2 < pageSize) {
    %>
    <li><span>...</span></li>
    <%
                }
            }
        }
    %>
    <li class="<%=currentPage == pageSize?"active":""%>"><a onclick="goSplit(<%=pageSize%>)"><%=pageSize%>
    </a></li>
    <%
    } else {
        for (int x = 1; x <= pageSize; x++) {
    %>
    <li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%>
    </a></li>
    <%
            }
        }
    %>
</ul>