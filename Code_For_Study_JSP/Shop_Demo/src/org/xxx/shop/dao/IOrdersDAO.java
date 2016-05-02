package cn.mldn.shop.dao;

import cn.mldn.shop.vo.Orders;

import java.sql.SQLException;
import java.util.List;

public interface IOrdersDAO extends IDAO<Integer, Orders> {
    /**
     * 调用last_insert_id()函数取得当前增长后的订单编号，为订单详情准备
     *
     * @return 返回最后自动增长编号
     * @throws SQLException
     */
    public Integer findLastInsertId() throws SQLException;

    public boolean doCreateOrders(Orders vo) throws SQLException;

    /**
     * 根据用户编号列出所有用户订单信息
     * @param mid
     * @param curentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Orders> findAllByMember(String mid,Integer curentPage,Integer lineSize) throws SQLException;
    public Integer getAllCountByMember(String mid)throws  SQLException;

    /**
     * 查询一个用户的一个订单信息
     * @param mid
     * @param oid
     * @return
     * @throws SQLException
     */
    public Orders findByIdAndMember(String mid,Integer oid)throws SQLException;
}
