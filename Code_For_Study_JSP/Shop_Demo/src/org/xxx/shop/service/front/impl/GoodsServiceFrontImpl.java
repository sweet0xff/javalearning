package cn.mldn.shop.service.front.impl;

import cn.mldn.shop.dbc.DatabaseConnection;
import cn.mldn.shop.factory.DAOFactory;
import cn.mldn.shop.service.front.IGoodsServiceFront;
import cn.mldn.shop.vo.Goods;

import java.util.HashMap;
import java.util.Map;


public class GoodsServiceFrontImpl implements IGoodsServiceFront {
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public Map<String, Object> list(String column, String keyword, int currentPage, int lineSize) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allItems", DAOFactory.getIItemDAOInstance(this.dbc.getConnection()).findAll());
            map.put("allGoods", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAllByStatus(1, column, keyword, currentPage, lineSize));
            map.put("goodsCount", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).getAllCountByStatus(1, column, keyword));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listByItem(int iid, String column, String keyword, int currentPage, int lineSize) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allItems", DAOFactory.getIItemDAOInstance(this.dbc.getConnection()).findAll());
            map.put("allGoods", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAllByItem(iid, 1, column, keyword, currentPage, lineSize));
            map.put("goodsCount", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).getAllByItem(iid, 1, column, keyword));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Goods show(int gid) throws Exception {
        try {
            // 首先要查询出商品的信息，如果有编号内容，可以查询类别信息
            Goods vo = DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findById(gid);
            if (vo != null) { // 有商品数据
                vo.setItem(DAOFactory.getIItemDAOInstance(this.dbc.getConnection()).findById(vo.getItem().getIid()));
                DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doUpdateBow(vo.getGid());
            }
            return vo;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
