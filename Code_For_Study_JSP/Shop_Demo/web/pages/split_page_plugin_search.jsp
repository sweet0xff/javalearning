<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>

<%--<div id="splitSearchDiv">--%>
<%--<jsp:include page="split_page_plugin_search.jsp">--%>
<%--<jsp:param name="columnDate" value="${columnDate%>"/>--%>
<%--<jsp:param name="column" value="${column%>"/>--%>
<%--<jsp:param name="keyWord" value="${keyWord%>"/>--%>
<%--<jsp:param name="allRecorders" value="${allRecorders%>"/>--%>
<%--</jsp:include>--%>
<%--</div>--%>
<%
    String column = null;
    String columnDate = null;
    String keyWord = null; // 默认查询关键字，不设置表示查询全部
    int allRecorders = 0;
%>
<%
    try {
        allRecorders = Integer.parseInt(request.getParameter("allRecorders"));
    } catch (Exception e) {
    }
    columnDate = (String) request.getAttribute("columnDate");
    keyWord = (String)request.getAttribute("keyword");
    column = (String)request.getAttribute("column");
%>
<%
    if (columnDate != null) {
%>
请输入查询关键字:<select id="colSel">
<%
    String result[] = columnDate.split("\\|");
    for (int x = 0; x < result.length; x++) {
        String temp[] = result[x].split(":");
%>
<option value="<%=temp[1]%>"  <%=column.equals(temp[1]) ? "selected" : ""%>><%=temp[0]%>
</option>
<%
    }
%>
</select>
<%
    }
%>
<input type="text" name="kw" id="kw" value="${keyword}">
<input type="button" value="检索" onclick="goSplit(1)">
<span>一共有${allRecorders}条记录</span><br><br>