package cn.mldn.shop.dao;

import cn.mldn.shop.vo.Shopcar;

import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public interface IShopcarDAO extends IDAO<Integer,Shopcar> {
    /**
     * 实现重复增加时，应该将已有数据进行自增
     * @param mid
     * @param gid
     * @return
     * @throws SQLException
     */
    public boolean doUpdateAmount(String mid,Integer gid)throws SQLException;

    /**
     * 根据用户编号和商品编号，查询出购物车的信息
     * @param mid 用户编号
     * @param gid 商品编号
     * @return
     * @throws SQLException
     */
    public Shopcar findByMemberAndGoods(String mid,Integer gid)throws SQLException;

    /**
     * 清除用户的所有购物车信息
     * @param mid 用户编号
     * @return
     * @throws SQLException
     */
    public boolean doRemoveByMember(String mid)throws SQLException;

    /**
     * 批量保存新的购物车数据操作
     * @param vos
     * @return
     * @throws SQLException
     */
    public boolean doCreateBatch(Set<Shopcar> vos)throws SQLException;

    /**
     * 删除一个用户一种商品的购买记录
     * @param mid
     * @param gid
     * @return
     * @throws SQLException
     */
    public boolean doRemoveByMemberAndGoods(String mid,Set<Integer> gid)throws SQLException;

    /**
     * 一个用户购买的所有商品的信息
     * @param mid
     * @return
     * @throws SQLException
     */
    public Map<Integer,Integer> findAllByMember(String mid)throws SQLException;
}
