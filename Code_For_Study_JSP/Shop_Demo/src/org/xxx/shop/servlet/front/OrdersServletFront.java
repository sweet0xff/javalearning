package cn.mldn.shop.servlet.front;


import cn.mldn.exception.EmptyShopcarException;
import cn.mldn.exception.UnCompleteMemberInfomrationException;
import cn.mldn.exception.UnEnoughAmountException;
import cn.mldn.shop.factory.DAOFactory;
import cn.mldn.shop.factory.ServiceBackFactory;
import cn.mldn.shop.factory.ServiceFrontFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "OrdersServletFront", urlPatterns = "/pages/front/orders/OrdersServletFront/*")
public class OrdersServletFront extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 程序错误跳转页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        if (status != null || "".equals(status)) {
            if ("insert".equals(status)) {
                path = this.insert(request);
            } else if ("list".equals(status)) {
                path = this.list(request);
            } else if ("show".equals(status)) {
                path = this.show(request);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    public String show(HttpServletRequest request) {
        String mid = (String) request.getSession().getAttribute("mid");
        int oid = Integer.parseInt(request.getParameter("oid"));
        try {
            request.setAttribute("orders", ServiceFrontFactory.getIOrdersServiceFrontInstance().show(mid, oid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/front/orders/orders_show.jsp";
    }

    public String list(HttpServletRequest request) {
        String iid = request.getParameter("iid"); // 先接收iid数据
        String mid = (String) request.getSession().getAttribute("mid");
        int currentPage = 1;
        int lineSize = 15;
        String column = null;
        String keyword = null;

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
            Map<String, Object> map = ServiceFrontFactory.getIOrdersServiceFrontInstance().listByMember(mid, currentPage, lineSize);

            request.setAttribute("allOrders", map.get("allOrders"));
            request.setAttribute("allRecorders", map.get("ordersCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyword", keyword);
        request.setAttribute("url", "/pages/front/orders/OrdersServletFront/list");
        return "/pages/front/orders/orders_list.jsp";
    }

    public String insert(HttpServletRequest request) {
        String msg = null;
        String url = null;
        String mid = (String) request.getSession().getAttribute("mid"); // 取得登录用户id
        try {
            if (ServiceFrontFactory.getIOrdersServiceFrontInstance().insert(mid)) {
                msg = "订单创建成功！";
                url = "/index.jsp";
            }
        } catch (UnCompleteMemberInfomrationException e) {
            msg = "个人信息不完整";
            url = "/pages/front/member/MemberInfoServletFront/updatePre";
            e.printStackTrace();
        } catch (UnEnoughAmountException e) {
            msg = "商品库存数量不足";
            url = "/pages/front/shopcar/ShopcarServletFront/list";
            e.printStackTrace();
        } catch (EmptyShopcarException e) {
            msg = "购物车中没有商品";
            url = "/pages/front/goods/GoodsServletFront/list";
            e.printStackTrace();
        } catch (SQLException e) {
            msg = "订单创建失败";
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }
}
