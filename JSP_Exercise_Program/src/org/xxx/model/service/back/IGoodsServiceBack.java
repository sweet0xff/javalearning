package org.xxx.model.service.back;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xxx.model.entity.Goods;

public interface IGoodsServiceBack<V> {

    /**
     * 商品增加操作
     * @param vo 包含有要增加的商品信息
     * @return 成功返回true, 失败返回false
     * @throws Exception
     */
    public boolean insert(Goods vo) throws Exception;
    
    /**
     * 执行数据的批量删除操作
     * @param ids
     * @return 
     * <li>key=flag value=IGoodsDAO.doDelete()</li>
     * @throws Exception
     */
    public Map<String, Goods> deleteAll(Set<Integer> gids) throws Exception;

    /**
     * 实现数据的分页显示功能,调用如下方法：
     * <li>调用IGoodsDAO接口中的getAllCount()方法，统计全部数据量</li>
     * @param currentPage 表示当前页
     * @param lineSize    表示每页显示记录数
     * @return 以List集合返回
     * @throws Exception
     */
    
    public List<Goods> goodsListSplit( Integer currentPage, Integer lineSize) throws Exception;


 
}
