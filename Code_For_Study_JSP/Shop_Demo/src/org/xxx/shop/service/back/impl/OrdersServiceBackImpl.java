package cn.mldn.shop.service.back.impl;

import cn.mldn.shop.dbc.DatabaseConnection;
import cn.mldn.shop.factory.DAOFactory;
import cn.mldn.shop.service.back.IOrdersServiceBack;
import cn.mldn.shop.vo.Orders;

import java.util.HashMap;
import java.util.Map;


public class OrdersServiceBackImpl implements IOrdersServiceBack {
    public DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allOrders", DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).findAll(column, keyWord, currentPage, lineSize));
            map.put("ordersCount", DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).getAllCount(column, keyWord));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Orders show(int oid) throws Exception {
        try {
            Orders vo = DAOFactory.getIOrdersDAOInstance(this.dbc.getConnection()).findById(oid);
            if (vo != null) {
                vo.setAllDetails(DAOFactory.getIDetailsDAOInstance(this.dbc.getConnection()).findAllByOrders(oid));
            }
            return vo;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

}
