package cn.mldn.shop.service.back.impl;

import cn.mldn.shop.dao.IGoodsDAO;
import cn.mldn.shop.dbc.DatabaseConnection;
import cn.mldn.shop.factory.DAOFactory;
import cn.mldn.shop.service.back.IGoodsServiceBack;
import cn.mldn.shop.vo.Goods;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GoodsServiceBackImpl implements IGoodsServiceBack {

    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public Map<String, Object> insertPre() throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allItems", DAOFactory.getIItemDAOInstance(this.dbc.getConnection()).findAll());
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean insert(Goods vo) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doCreate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSiez) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allGoods", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAll(column, keyWord, currentPage, lineSiez));
            map.put("goodsCount", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).getAllCount(column, keyWord));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> listSatus(int status, String column, String keyWord, int currentPage, int lineSiez) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allGoods", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAllByStatus(status, column, keyWord, currentPage, lineSiez));
            map.put("goodsCount", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).getAllCountByStatus(status, column, keyWord));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateUp(Set<Integer> gid) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doUpdateStatus(1, gid);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateDown(Set<Integer> gid) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doUpdateStatus(0, gid);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean updateDelete(Set<Integer> gid) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doUpdateStatus(2, gid);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> updatePre(int gid) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allItems", DAOFactory.getIItemDAOInstance(this.dbc.getConnection()).findAll());
            map.put("goods", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findById(gid));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Goods vo) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> deleteAll(Set<Integer> ids) throws Exception {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("allPhotos", DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).findAllByPhoto(ids));
            map.put("flag", DAOFactory.getIItemDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids));
            return map;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getIGoodsDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
