package cn.mldn.shop.servlet.back;


import cn.mldn.shop.factory.ServiceBackFactory;
import cn.mldn.shop.service.front.IMemberServiceFront;
import cn.mldn.shop.vo.Admin;
import cn.mldn.shop.vo.Goods;
import cn.mldn.shop.vo.Item;
import cn.mldn.util.BasePath;
import cn.mldn.util.validate.ValidateUtil;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "GoodsServletBack", urlPatterns = "/pages/back/admin/goods/GoodsServletBack/*")
public class GoodsServletBack extends HttpServlet {
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
            } else if ("insertPre".equals(status)) {
                path = this.insertPre(request);
            } else if ("list".equals(status)) {
                path = this.list(request);
            } else if ("listStatus".equals(status)) {
                path = this.listStatus(request);
            } else if ("updateStatus".equals(status)) {
                path = this.updateStatus(request);
            } else if ("updatePre".equals(status)) {
                path = this.updatePre(request);
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
        String url = null;
        String referer = request.getHeader("referer");
        String ids = request.getParameter("ids"); // 包含有id:photo信息
        if (ValidateUtil.validatEmpty(ids)) {
            Set<Integer> allIds = new HashSet<Integer>();
            Set<String> allPhotos = new HashSet<String>();
            String result[] = ids.split("\\|"); // 拆分
            for (int x = 0; x < result.length; x++) {
                String[] temp = result[x].split(":");
                allIds.add(Integer.parseInt(temp[0]));
                if (!"nophoto.jpg".equals(temp[1])) {
                    allPhotos.add(temp[1]);
                }
            }
            try {
                if (ServiceBackFactory.getIGoodsServiceBackInstance().delete(allIds)) {
                    if (allPhotos.size() > 0) {
                        Iterator<String> iter = allPhotos.iterator();
                        while (iter.hasNext()) {
                            String filePath = super.getServletContext().getRealPath("/upload/goods/") + iter.next();
                            File file = new File(filePath);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    msg = "商品信息删除成功！";
                } else {
                    msg = "商品信息删除失败！";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "删除的数据错误，请重新输入！";
        }
        url = "/pages/back/admin/goods/GoodsServletBack" + referer.substring(referer.lastIndexOf("/"));
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        String msg = null;
        String url = null;
        SmartUpload smart = new SmartUpload();
        try {
            smart.initialize(super.getServletConfig(), request, response);
            smart.upload();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String oldpic = smart.getRequest().getParameter("oldpic");
        String gid = smart.getRequest().getParameter("gid");
        String iid = smart.getRequest().getParameter("iid");
        String title = smart.getRequest().getParameter("title");
        String price = smart.getRequest().getParameter("price");
        String amount = smart.getRequest().getParameter("amount");
        String note = smart.getRequest().getParameter("note");
        String status = smart.getRequest().getParameter("status");
        if (ValidateUtil.validatEmpty(gid)
                && ValidateUtil.validatEmpty(title)
                && ValidateUtil.validateRegex(price, "\\d+(\\.\\d{1,2})?")
                && ValidateUtil.validateRegex(amount, "\\d+")
                && ValidateUtil.validatEmpty(note)
                && ValidateUtil.validateRegex(status, "\\d")
                && ValidateUtil.validateRegex(iid, "\\d")) {
            Goods vo = new Goods();
            vo.setGid(Integer.parseInt(gid));
            vo.setTitle(title);
            vo.setPrice(Double.parseDouble(price));
            vo.setAmount(Integer.parseInt(amount));
            vo.setNote(note);
            vo.setStatus(Integer.parseInt(status));
            Item item = new Item();
            item.setIid(Integer.parseInt(iid));
            vo.setItem(item); // 保存分类编号
            try {
                if (smart.getFiles().getSize() > 0) {
                    if (smart.getFiles().getFile(0).getContentType().contains("image")) {
                        if (!"nophoto.jpg".equals(oldpic)) { // 之前没有上传图片，需要重新生成名称
                        vo.setPhoto(UUID.randomUUID().toString().replace("-", "") + "." + smart.getFiles().getFile(0).getFileExt());
                        }
                    } else {
                        vo.setPhoto(oldpic);
                    }
                } else {
                    vo.setPhoto(oldpic);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ServiceBackFactory.getIGoodsServiceBackInstance().update(vo)) {
                    String filePath = super.getServletContext().getRealPath("/upload/goods/") + vo.getPhoto();
                    if (smart.getFiles().getSize() > 0) {
                        if (smart.getFiles().getFile(0).getContentType().contains("image")) {
                            smart.getFiles().getFile(0).saveAs(filePath);
                        }
                    }
                    msg = "商品数据增修改成功！";
                } else {
                    msg = "商品数据增修改失败！";
                }
                url = smart.getRequest().getParameter("back"); // 取得之前路径
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "商品数据修改出错，无法进行商品的信息修改！";
            url = smart.getRequest().getParameter("back"); // 取得之前路径
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String updatePre(HttpServletRequest request) {
        String gid = request.getParameter("gid");
        String referer = request.getHeader("referer");
        if (ValidateUtil.validatEmpty(gid)) {
            try {
                Map<String, Object> map = ServiceBackFactory.getIGoodsServiceBackInstance().updatePre(Integer.parseInt(gid));
                request.setAttribute("allItems", map.get("allItems"));
                request.setAttribute("goods", map.get("goods"));
                request.setAttribute("back", "/pages/back/admin/goods/GoodsServletBack" + referer.substring(referer.lastIndexOf("/")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "/pages/back/admin/goods/goods_update.jsp";
        } else {
            request.setAttribute("msg", "你还未选择任何数据！");
            request.setAttribute("url", "/pages/back/admin/goods/GoodsServletBack" + referer.substring(referer.lastIndexOf("/")));
            return "/pages/forward.jsp";
        }
    }

    public String updateStatus(HttpServletRequest request) {
        String referer = request.getHeader("referer");
        String msg = null;
        String url = null;
        String ids = request.getParameter("ids");
        String type = request.getParameter("type"); // 区分类型
        if (ValidateUtil.validatEmpty(ids)) {
            String result[] = ids.split("\\|");
            Set<Integer> all = new HashSet<>();
            for (int x = 0; x < result.length; x++) {
                String temp[] = result[x].split(":");
                all.add(Integer.parseInt(temp[0]));
            }
            boolean flag = false;// 保存最终操作状态
            try {
                if ("up".equals(type)) {
                    flag = ServiceBackFactory.getIGoodsServiceBackInstance().updateUp(all);
                }
                if ("down".equals(type)) {
                    flag = ServiceBackFactory.getIGoodsServiceBackInstance().updateDown(all);
                }
                if ("delete".equals(type)) {
                    flag = ServiceBackFactory.getIGoodsServiceBackInstance().updateDelete(all);
                }
                if (flag) {
                    msg = "商品状态更新成功！";
                } else {
                    msg = "商品状态更新失败！";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "更新的数据错误，请重新输入！";
        }
        url = "/pages/back/admin/goods/GoodsServletBack" + referer.substring(referer.lastIndexOf("/"));
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }

    public String listStatus(HttpServletRequest request) {
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
        int status = Integer.parseInt(request.getParameter("status"));
        try {
            Map<String, Object> map = ServiceBackFactory.getIGoodsServiceBackInstance().listSatus(status, column, keyword, currentPage, lineSize);
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
        request.setAttribute("paramName", "status");
        request.setAttribute("paramValue", String.valueOf(status));
        request.setAttribute("url", "/pages/back/admin/good/GoodsServletBack/listStatus");
        return "/pages/back/admin/goods/goods_list.jsp";
    }

    public String list(HttpServletRequest request) {
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
            Map<String, Object> map = ServiceBackFactory.getIGoodsServiceBackInstance().list(column, keyword, currentPage, lineSize);
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
        request.setAttribute("url", "/pages/back/admin/good/GoodsServletBack/list");
        return "/pages/back/admin/goods/goods_list.jsp";
    }

    public String insertPre(HttpServletRequest request) {
        try {
            Map<String, Object> map = ServiceBackFactory.getIGoodsServiceBackInstance().insertPre();
            request.setAttribute("allItems", map.get("allItems"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/admin/goods/goods_insert.jsp";
    }

    public String insert(HttpServletRequest request, HttpServletResponse response) {
        String msg = null;
        String url = null;
        SmartUpload smart = new SmartUpload();
        try {
            smart.initialize(super.getServletConfig(), request, response);
            smart.upload();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String iid = smart.getRequest().getParameter("iid");
        String title = smart.getRequest().getParameter("title");
        String price = smart.getRequest().getParameter("price");
        String amount = smart.getRequest().getParameter("amount");
        String note = smart.getRequest().getParameter("note");
        String status = smart.getRequest().getParameter("status");
        if (ValidateUtil.validatEmpty(title)
                && ValidateUtil.validateRegex(price, "\\d+(\\.\\d{1,2})?")
                && ValidateUtil.validateRegex(amount, "\\d+")
                && ValidateUtil.validatEmpty(note)
                && ValidateUtil.validateRegex(status, "\\d")
                && ValidateUtil.validateRegex(iid, "\\d")) {
            Goods vo = new Goods();
            vo.setTitle(title);
            vo.setPrice(Double.parseDouble(price));
            vo.setAmount(Integer.parseInt(amount));
            vo.setBow(0);
            vo.setNote(note);
            vo.setPubdate(new Date());
            Item item = new Item();
            item.setIid(Integer.parseInt(iid));
            vo.setItem(item); // 保存分类编号
            String aid = (String) request.getSession().getAttribute("aid");
            Admin admin = new Admin();
            admin.setAid(aid);
            vo.setAdmin(admin); // 保存管理员编号
            vo.setStatus(Integer.parseInt(status));
            try {
                if (smart.getFiles().getSize() > 0) {
                    if (smart.getFiles().getFile(0).getContentType().contains("image")) {
                        vo.setPhoto(UUID.randomUUID().toString().replace("-", "") + "." + smart.getFiles().getFile(0).getFileExt());
                    } else {
                        vo.setPhoto("nophoto.jpg");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ServiceBackFactory.getIGoodsServiceBackInstance().insert(vo)) {
                    String filePath = super.getServletContext().getRealPath("/upload/goods/") + vo.getPhoto();
                    if (smart.getFiles().getSize() > 0) {
                        if (smart.getFiles().getFile(0).getContentType().contains("image")) {
                            smart.getFiles().getFile(0).saveAs(filePath);
                        }
                    }
                    msg = "商品数据增加成功！";
                } else {
                    msg = "商品数据增加失败！";
                }
                url = "/pages/back/admin/goods/GoodsServletBack/insertPre";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg = "商品数据增加出错，请重新输入信息！";
            url = "/pages/back/admin/goods/GoodsServletBack/insertPre";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        return "/pages/forward.jsp";
    }
}
