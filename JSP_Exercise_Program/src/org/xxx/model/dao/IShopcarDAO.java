package org.xxx.model.dao;

import java.sql.SQLException;
import java.util.Map;

import org.xxx.model.entity.Goods;
import org.xxx.model.entity.Shopcar;

public interface IShopcarDAO extends IDAO<Integer,Shopcar> {
    /**
     * 实现重复增加时，应该将已有数据进行自增
     * @param uid
     * @param gid
     * @return
     * @throws SQLException
     */
    public boolean doUpdateAmount(Integer uid,Integer gid)throws SQLException;

    /**
     * 根据用户编号,查询出购物车的信息
     * @param uid 用户编号
     * @param gid 商品编号
     * @return
     * @throws SQLException
     */
    public Shopcar findById(Integer uid)throws SQLException;

    /**
     * 清除用户购物车中所有商品信息
     * @param uid 用户编号
     * @return
     * @throws SQLException
     */
    public boolean doDeleteByUid(Integer uid)throws SQLException;

    /**
     * 一个用户购买的所有商品的信息
     * @param uid
     * @return
     * @throws SQLException
     */
    public Map<Integer,Goods> findGoodsByUid(Integer uid)throws SQLException;

}
