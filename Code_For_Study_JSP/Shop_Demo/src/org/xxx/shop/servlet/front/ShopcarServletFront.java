package cn.mldn.shop.servlet.front;


import cn.mldn.shop.factory.ServiceFrontFactory;
import cn.mldn.shop.util.ShopcarCookieUtil;
import cn.mldn.shop.vo.Goods;
import cn.mldn.shop.vo.Member;
import cn.mldn.shop.vo.Shopcar;
import cn.mldn.util.validate.ValidateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ShopcarServletFront", urlPatterns = "/pages/front/shopcar/ShopcarServletFront/*")
public class ShopcarServletFront extends HttpServlet {
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
                path = this.insert(request, response);
            } else if ("list".equals(status)) {
                path = this.list(request);
            } else if ("update".equals(status)) {
                path = this.update(request, response);
            } else if ("delete".equals(status)) {
                path = this.delete(request, response);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String msg = null;
        String mid = (String) request.getSession().getAttribute("mid");  // 取得用户id
        String ids = request.getParameter("ids");
        String result[] = ids.split("\\|");
        Set<Integer> set = new HashSet<>();
        for (int x = 0; x < result.length; x++) {
            set.add(Integer.parseInt(result[x]));
        }
        try {
            if (ServiceFrontFactory.getIShopcarServiceFrontInstance().delectCar(mid, set)) {
                msg = "购物车商品删除成功！";
            } else {
                msg = "购物车商品删除成功！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", "/pages/front/shopcar/ShopcarServletFront/list");
        return "/pages/forward.jsp";
    }

    public String list(HttpServletRequest request) {
        String mid = (String) request.getSession().getAttribute("mid");  // 取得用户id
        try {
            Map<String, Object> map = ServiceFrontFactory.getIShopcarServiceFrontInstance().listCar(mid);
            request.setAttribute("allGoods", map.get("allGoods"));
            request.setAttribute("allCars", map.get("allShopcars"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/front/shopcar/car_list.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        String msg = null;
        String mid = (String) request.getSession().getAttribute("mid");  // 取得用户id
        ShopcarCookieUtil.clearCar(request, response);
        Map<Integer, Integer> map = new HashMap<>();
        Enumeration<String> enu = request.getParameterNames();
        Set<Shopcar> all = new HashSet<>();
        while (enu.hasMoreElements()) {
            String temp = enu.nextElement();
            int gid = Integer.parseInt(temp);
            int count = Integer.parseInt(request.getParameter(temp));
            Shopcar vo = new Shopcar();
            Member member = new Member();
            member.setMid(mid);
            vo.setMember(member);
            Goods goods = new Goods();
            goods.setGid(gid);
            vo.setGoods(goods);
            vo.setAmount(count); // 设置数量
            all.add(vo);
        }
        try {
            if (ServiceFrontFactory.getIShopcarServiceFrontInstance().update(mid, all)) {
                msg = "购物车更新成功！";
            } else {
                msg = "购物车更新失败！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String referer = request.getHeader("referer");
        String url = "/pages/front/goods/GoodsServletFront" + referer.substring(referer.lastIndexOf("/"));
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String insert(HttpServletRequest request, HttpServletResponse response) {
        String msg = null;
        int gid = Integer.parseInt(request.getParameter("gid"));
        String mid = (String) request.getSession().getAttribute("mid");  // 取得用户id
        Shopcar vo = new Shopcar();
        Member member = new Member();
        member.setMid(mid);
        vo.setMember(member);
        Goods goods = new Goods();
        goods.setGid(gid);
        vo.setGoods(goods);
        try {
            if (ServiceFrontFactory.getIShopcarServiceFrontInstance().addCar(vo)) {
                msg = "购物车添加成功！";
            } else {
                msg = "购物车添加失败！";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String referer = request.getHeader("referer");
        String url = "/pages/front/goods/GoodsServletFront" + referer.substring(referer.lastIndexOf("/"));
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }
}
