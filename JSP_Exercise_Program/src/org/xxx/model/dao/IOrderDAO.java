package org.xxx.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.xxx.model.entity.Order;

public interface IOrderDAO extends IDAO<Integer, Order> {

    /**
     * 根据用户编号列出所有用户订单信息
     * @param uid
     * @param curentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Order> findAllByUserId(Integer gid,Integer curentPage,Integer lineSize) throws SQLException;
    
    /**
     * 查询某个用户的商品购买总数
     * @param uid
     * @return
     * @throws SQLException
     */
    public Integer getAllCountByUserId(Integer gid)throws  SQLException;

    /**
     * 查询一个用户的一个订单信息
     * @param uid
     * @param oid
     * @return
     * @throws SQLException
     */
    public Order findByOid(Integer uid,Integer oid)throws SQLException;
}
