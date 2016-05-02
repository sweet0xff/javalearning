package cn.mldn.shop.servlet.back;


import cn.mldn.shop.factory.ServiceBackFactory;
import cn.mldn.shop.factory.ServiceFrontFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "OrdersServletBack", urlPatterns = "/pages/back/admin/orders/OrdersServletBack/*")
public class OrdersServletBack extends HttpServlet {
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
            } else if ("show".equals(status)) {
                path = this.show(request);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        int oid = Integer.parseInt(request.getParameter("oid"));
        try {
            request.setAttribute("orders", ServiceBackFactory.getIOrdersServiceBackInstance().show(oid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/admin/orders/orders_show.jsp";
    }


    public String list(HttpServletRequest request) {
        String iid = request.getParameter("iid"); // 先接收iid数据
        int currentPage = 1;
        int lineSize = 15;
        String column = null;
        String keyword = null;
        String columnData = "购买用户:title";
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
            Map<String, Object> map = ServiceBackFactory.getIOrdersServiceBackInstance().list(column,keyword,currentPage, lineSize);

            request.setAttribute("allOrders", map.get("allOrders"));
            request.setAttribute("allRecorders", map.get("ordersCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyword", keyword);
        request.setAttribute("columnData", columnData);
        request.setAttribute("url", "/pages/back/admin/orders/OrdersServletBack/list");
        return "/pages/back/admin/orders/orders_list.jsp";
    }
}
