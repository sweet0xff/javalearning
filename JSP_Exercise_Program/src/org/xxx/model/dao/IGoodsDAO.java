package org.xxx.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.xxx.model.entity.Goods;

public interface IGoodsDAO extends IDAO<Integer, Goods> {
	
    /**
     * 根据状态实现分页
     * @param status
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByStatus(Integer status,Integer currentPage, Integer lineSize) throws SQLException;

    /**
     * 根据状态统计数据量
     * @param status
     * @param column
     * @param keyWord
     * @return
     * @throws SQLException
     */
    public Integer getAllCountByStatus(Integer status) throws SQLException;

    /**
     * 根据商品编号修改状态
     * @param status
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(Integer status, Integer gid)throws SQLException;

    /**
     * 更新访问次数，每次调用访问次数加1
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doUpdateBow(Integer gid)throws SQLException;

    /**
     * 查询指定编号的商品信息
     * @param gid
     * @return
     * @throws SQLException
     */
    public Goods findById(Integer gid)throws SQLException;

    /**
     * 要进行商品库存量的更改
     * @param gid 商品编号
     * @param num
     * @return
     * @throws SQLException
     */
     public boolean doUpdateByAmount(Integer gid,Integer num)throws SQLException;

     /**
      * 统计所有商品的总数
      * @return
      * @throws SQLException
      */
	public Integer getAllCount() throws SQLException;
	
	
    /**
     * 根据商品编号修改状态
     *
     * @param status
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(Integer status, Set<Integer> id)throws SQLException;

    /**
     * 根据商品的分类与状态进行商品的列表显示
     * @param iid 商品的所属类型
     * @param status 商品的当前状态
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByItem(Integer iid,Integer status, Integer currentPage, Integer lineSize) throws SQLException;
    /**
     * 根据Item查询商品总数
     * @param iid
     * @param status
     * @return
     * @throws SQLException
     */
    public Integer getAllByItem(Integer iid,Integer status) throws SQLException;

}
