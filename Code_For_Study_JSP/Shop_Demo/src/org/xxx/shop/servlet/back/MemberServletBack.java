package cn.mldn.shop.servlet.back;


import cn.mldn.shop.factory.ServiceBackFactory;
import cn.mldn.shop.vo.Member;
import cn.mldn.util.BasePath;
import cn.mldn.util.validate.ValidateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "MemberServletBack", urlPatterns = "/pages/back/admin/MemberServletBack/*")
public class MemberServletBack extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 程序错误跳转页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        if (status != null || "".equals(status)) {
            if ("list".equals(status)) {
                path = this.list(request);
            } else if ("listStatus".equals(status)) {
                path = this.listStatus(request);
            } else if ("updateStatus".equals(status)) {
                path = this.updateStatus(request);
            } else if ("show".equals(status)) {
                path = this.show(request);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        String mid = request.getParameter("mid");
        String referer = request.getHeader("referer");// 取得发送前路径
        String msg = null;
        String url = null;
        if (ValidateUtil.validatEmpty(mid)) {
            try {
                request.setAttribute("member", ServiceBackFactory.getIMemberServiceBackInstance().show(mid));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "/pages/back/admin/member/member_show.jsp";
        } else {
            msg = "你还未选择任何要查看的数据！";
            url = "/pages/back/admin/MemberServletBack" + referer.substring(referer.lastIndexOf("/"));
            request.setAttribute("msg", msg);
            request.setAttribute("url", url);
            return "/pages/forward.jsp";
        }
    }

    public String updateStatus(HttpServletRequest request) {
//        Enumeration<String> enu = request.getHeaderNames();
//        while (enu.hasMoreElements()){
//            String name = enu.nextElement();
//            System.out.println("name =" +name+", value="+request.getHeader(name));
//        }
        String type = request.getParameter("type");
        String referer = request.getHeader("referer");// 取得发送前路径
        String msg = null;
        String url = null;
        String ids = request.getParameter("ids");
        if (ValidateUtil.validatEmpty(ids)) {
            String result[] = ids.split("\\|");
            Set<String> mid = new HashSet<>();
            for (int x = 0; x < result.length; x++) {
                mid.add(result[x]);
            }
            try {
                boolean flag = false;
                if ("active".equalsIgnoreCase(type)) {
                    flag = ServiceBackFactory.getIMemberServiceBackInstance().updateActive(mid);
                }
                if ("lock".equalsIgnoreCase(type)) {
                    flag = ServiceBackFactory.getIMemberServiceBackInstance().updateLock(mid);
                }
                if (flag) {
                    msg = "用户状态修改成功！";
                } else {
                    msg = "用户状态修改失败！";
                }
//               if ("active".equalsIgnoreCase(type)){
//                   if (ServiceBackFactory.getIMemberServiceBackInstance().updateActive(mid)) {
//                       msg = "用户状态更新成功！";
//                   } else {
//                       msg = "用户状态更新失败！";
//                   }
//               }
//                if ("lock".equalsIgnoreCase(type)){
//                    if (ServiceBackFactory.getIMemberServiceBackInstance().updateLock(mid)) {
//                        msg = "用户状态锁定成功！";
//                    } else {
//                        msg = "用户状态锁定失败！";
//                    }
//                }
                url = "/pages/back/admin/MemberServletBack" + referer.substring(referer.lastIndexOf("/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "你还未选择删除数据！";
            url = "/pages/back/admin/MemberServletBack" + referer.substring(referer.lastIndexOf("/"));
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String list(HttpServletRequest request) {
        int currentPage = 1;
        int lineSize = 15;
        String column = null;
        String keyword = null;
        String columnDate = "用户ID:mid|真实姓名:name|联系电话:phone|地址:address";
        try {
            currentPage = Integer.parseInt(request.getParameter("cp"));
        } catch (Exception e) {
        }
        try {
            lineSize = Integer.parseInt(request.getParameter("ls"));
        } catch (Exception e) {
        }

        column = request.getParameter("col");
        keyword = request.getParameter("kw");
        if (column == null) {
            column = "mid";
        }
        if (keyword == null) {
            keyword = "";
        }
        try {
            Map<String, Object> map = ServiceBackFactory.getIMemberServiceBackInstance().list(column, keyword, currentPage, lineSize);
            request.setAttribute("allMembers", map.get("allMembers"));
            request.setAttribute("allRecorders", map.get("allCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyword", keyword);
        request.setAttribute("columnDate", columnDate);
        request.setAttribute("url", "/pages/back/admin/MemberServletBack/list");
        return "/pages/back/admin/member/member_list.jsp";
    }

    public String listStatus(HttpServletRequest request) {
        int status = 0;
        int currentPage = 1;
        int lineSize = 15;
        String column = null;
        String keyword = null;
        String columnDate = "用户ID:mid|真实姓名:name|联系电话:phone|地址:address";
        try {
            status = Integer.parseInt(request.getParameter("status"));
        } catch (Exception e) {
        }
        try {
            currentPage = Integer.parseInt(request.getParameter("cp"));
        } catch (Exception e) {
        }
        try {
            lineSize = Integer.parseInt(request.getParameter("ls"));
        } catch (Exception e) {
        }

        column = request.getParameter("col");
        keyword = request.getParameter("kw");
        if (column == null) {
            column = "mid";
        }
        if (keyword == null) {
            keyword = "";
        }
        try {
            Map<String, Object> map = ServiceBackFactory.getIMemberServiceBackInstance().listByStatus(status, column, keyword, currentPage, lineSize);
            request.setAttribute("allMembers", map.get("allMembers"));
            request.setAttribute("allRecorders", map.get("allCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyword", keyword);
        request.setAttribute("columnDate", columnDate);
        request.setAttribute("paramName", "status"); // 查询状态使用参数
        request.setAttribute("paramValue", String.valueOf(status));
        request.setAttribute("url", "/pages/back/admin/MemberServletBack/list");
        return "/pages/back/admin/member/member_list.jsp";
    }
}
