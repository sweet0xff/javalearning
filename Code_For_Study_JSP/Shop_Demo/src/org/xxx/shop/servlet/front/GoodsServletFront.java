package cn.mldn.shop.servlet.front;


import cn.mldn.shop.factory.ServiceBackFactory;
import cn.mldn.shop.factory.ServiceFrontFactory;
import cn.mldn.shop.vo.Goods;
import cn.mldn.util.validate.ValidateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "GoodsServletFront", urlPatterns = "/pages/front/goods/GoodsServletFront/*")
public class GoodsServletFront extends HttpServlet {
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
        String msg = null;
        String url = null;
        String gid = request.getParameter("gid");
        if (ValidateUtil.validateRegex(gid, "\\d+")) {
            try {
                request.setAttribute("goods", ServiceFrontFactory.getIGoodsServiceFrontInstance().show(Integer.parseInt(gid)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "/pages/front/goods/goods_show.jsp";

        } else {
            msg = "你还未选择任何商品信息!";
            url = request.getHeader("referer");
            return "/pages/forward.jsp";

        }
    }

    public String list(HttpServletRequest request) {

        String iid = request.getParameter("iid"); // 先接收iid数据

        int currentPage = 1;
        int lineSize = 15;
        String column = null;
        String keyword = null;
        String columnDate = "商品名称:title|商品价格:price";

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
            column = "gid";
        }
        if (keyword == null) {
            keyword = "";
        }
        try {
            Map<String, Object> map = null;
            if (iid == null || "0".equals(iid)) { // 属于查询全部
                map = ServiceFrontFactory.getIGoodsServiceFrontInstance().list(column, keyword, currentPage, lineSize);
            } else { // 根据Item查询数据
                map = ServiceFrontFactory.getIGoodsServiceFrontInstance().listByItem(Integer.parseInt(iid), column, keyword, currentPage, lineSize);
            }
            request.setAttribute("allItems", map.get("allItems"));
            request.setAttribute("allGoods", map.get("allGoods"));
            request.setAttribute("allRecorders", map.get("goodsCount"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("lineSize", lineSize);
        request.setAttribute("column", column);
        request.setAttribute("keyword", keyword);
        request.setAttribute("columnDate", columnDate);
        request.setAttribute("paramName", "iid");
        request.setAttribute("paramValue", iid);
        request.setAttribute("url", "/pages/front/goods/GoodsServletFront/list");
        return "/pages/front/goods/goods_list.jsp";
    }
}
