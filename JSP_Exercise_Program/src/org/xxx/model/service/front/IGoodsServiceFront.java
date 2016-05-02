package org.xxx.model.service.front;

import java.util.Map;

import org.xxx.model.entity.Goods;

public interface IGoodsServiceFront {
    /**
     * 此接口完成数据的分页显示功能，根据商品的分类查询，会调用如下方法：<br>
     *     <li>要调用IItemDAO.findAll()方法查询出全部的商品分类</li>
     *     <li>要调用IGoodsDAO.findAllByStatus()方法查询出全部的商品数据</li>
     *     <li>要调用IGoodsDAO.getAllCountByStatus()方法查询出全部的商品数据量</li>
     *     <li>调用的时候status设置的内容为1，表示上架商品</li>
     * @param column
     * @param keyword
     * @param currentPage
     * @param lineSize
     * @return 返回的数据一个包含有三类内容：<br>
     *     <li>key=allItems、value= IItemDAO.findAll(),保存的是List<Item></li>
     *     <li>key=allGoods、value= IGoodsDAO.findAllByStatus()</li>
     *     <li>key=goodsCount、value= IGoodsDAO.getAllCountByStatus()</li>
     * @throws Exception
     */
    public Map<String, Object> list(int currentPage, int lineSize) throws Exception;

    /**
     * 此接口完成数据的分页显示功能，根据商品的分类查询，会调用如下方法：<br>
     *     <li>要调用IItemDAO.findAll()方法查询出全部的商品分类</li>
     *     <li>要调用IGoodsDAO.findAllByItem()方法查询出全部的商品数据</li>
     *     <li>要调用IGoodsDAO.getAllCountByItem()方法查询出全部的商品数据量</li>
     *     <li>调用的时候status设置的内容为1，表示上架商品</li>
     * @param iid
     * @param column
     * @param keyword
     * @param currentPage
     * @param lineSize
     * @return 返回的数据一个包含有三类内容：<br>
     *     <li>key=allItems、value= IItemDAO.findAll(),保存的是List<Item></li>
     *     <li>key=allGoods、value= IGoodsDAO.findAllByItem()</li>
     *     <li>key=goodsCount、value= IGoodsDAO.getAllCountByItem()</li>
     * @throws Exception
     */
    public Map<String,Object> listByItem(int iid, String column, String keyword, int currentPage, int lineSize)throws Exception;

    /**
     * 本操作要显示商品的完整信息，包含的操作如下：<br>
     *     <li>调用IGoodsDAO.findById()方法可以根据商品编号查询出完整信息</li>
     *     <li>调用IGoodsDAO.doUpdateBow()方法更新浏览次数</li>
     *     <li>调用IItemDAO.findById()方法,查询出所属分类的名称</li>
     * @param gid
     * @return 商品分类设置在商品对象中返回，如果有数据返回实例化对象，否则返回null.
     * @throws Exception
     */
    public Goods show(int gid)throws Exception;
}
