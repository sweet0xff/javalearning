package cn.mldn.shop.dao;

import cn.mldn.shop.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IGoodsDAO extends IDAO<Integer, Goods> {
    /**
     * 根据状态实现分页
     *
     * @param status
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByStatus(Integer status, String column, String keyWord,
                                       Integer currentPage, Integer lineSize) throws SQLException;

    /**
     * 根据状态统计数据量
     *
     * @param status
     * @param column
     * @param keyWord
     * @return
     * @throws SQLException
     */
    public Integer getAllCountByStatus(Integer status, String column, String keyWord) throws SQLException;

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
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Set<String> findAllByPhoto(Set<Integer> id)throws SQLException;

    /**
     * 根据商品的分类与状态进行商品的列表显示
     * @param iid 商品的所属类型
     * @param status 商品的当前状态
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByItem(Integer iid,Integer status, String column, String keyWord,
                                       Integer currentPage, Integer lineSize) throws SQLException;
    public Integer getAllByItem(Integer iid,Integer status, String column, String keyWord) throws SQLException;

    /**
     * 更新访问次数，每次调用访问次数加1
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doUpdateBow(Integer id)throws SQLException;

    /**
     * 查询指定编号的所有商品信息
     * @param ids
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByGid(Set<Integer> ids)throws SQLException;

    /**
     * 要进行商品库存量的更改
     * @param gid
     * @param num
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByAmount(Integer gid,Integer num)throws SQLException;
}
