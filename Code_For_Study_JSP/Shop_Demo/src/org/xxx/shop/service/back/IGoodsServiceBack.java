package cn.mldn.shop.service.back;

import cn.mldn.shop.vo.Goods;

import java.util.Map;
import java.util.Set;

public interface IGoodsServiceBack {
    /**
     * 商品增加前的数据查询操作，要查询出所有的栏目信息：
     * <li>调用ItemDAO.findAll()方法，查询出全部的分类</li>
     *
     * @return 数据以Map集合返回，包含以下内容：<br>
     * <li>key = allItems、value = IItemDAO.findAll()返回值</li>
     * @throws Exception
     */
    public Map<String, Object> insertPre() throws Exception;

    /**
     * 商品增加操作，增加的时候调用IGoodsDAO.doCredate()方法
     *
     * @param vo 包含有要增加的商品信息
     * @return 成功返回true, 失败返回false
     * @throws Exception
     */
    public boolean insert(Goods vo) throws Exception;

    /**
     * 实现数据的分页显示功能,调用如下方法：
     * <li>调用IGoodsDAO接口中的findAll()方法,查询全部数据列</li>
     * <li>调用IGoodsDAO接口中的getAllCount()方法，统计全部数据量</li>
     *
     * @param column      表示要模糊查询的列字段
     * @param keyWord     表示要查询的关键字
     * @param currentPage 表示当前页
     * @param lineSiez    表示每页显示记录数
     * @return 以Map集合返回，包括如下内容：
     * <li>key = allGoods 、 value = IGoodsDAO.findAll()</li>
     * <li>key = goodsCount 、 value = IGoodsDAO.getAllCount()</li>
     * @throws Exception
     */
    public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSiez) throws Exception;

    /**
     * 根据状态查询视频谢谢
     *
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSiez
     * @return
     * @throws Exception
     */
    public Map<String, Object> listSatus(int status, String column, String keyWord, int currentPage, int lineSiez) throws Exception;

    public boolean updateUp(Set<Integer> gid) throws Exception;

    public boolean updateDown(Set<Integer> gid) throws Exception;

    public boolean updateDelete(Set<Integer> gid) throws Exception;

    /**
     * 商品修改前的数据查询操作，要查询出所有的栏目信息：
     * <li>调用ItemDAO.findAll()方法，查询出全部的分类</li>
     * <li>调用IGoodsDAO.findById()方法，查询出商品名称是否存在</li>
     *
     * @return 数据以Map集合返回，包含以下内容：<br>
     * <li>key = allItems、value = IItemDAO.findAll()返回值</li>
     * <li>key = allGoods、value = IGoodsDAO.findById()返回值</li>
     * @throws Exception
     */
    public Map<String, Object> updatePre(int gid) throws Exception;

    public boolean update(Goods vo) throws Exception;

    /**
     * 执行数据的批量删除操作，但是在执行之后要清除对应的商品图片信息
     *
     * @param ids
     * @return 返回数据包含有两项内容：<br>
     * <li>key=flag 、 value=IGoodsDAO.doRemoveBatch()</li>
     * <li>key=allPhotos 、 value=IGoodsDAO.findAllByPhoto()</li>
     * @throws Exception
     */
    public Map<String, Object> deleteAll(Set<Integer> ids) throws Exception;

    /**
     * 根据id删除商品信息
     *
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean delete(Set<Integer> ids) throws Exception;
}
