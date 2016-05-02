package org.xxx.model.service.front;

import java.util.Map;

import org.xxx.model.entity.Goods;

public interface IGoodsServiceFront {
    /**
     * �˽ӿ�������ݵķ�ҳ��ʾ���ܣ�������Ʒ�ķ����ѯ����������·�����<br>
     *     <li>Ҫ����IItemDAO.findAll()������ѯ��ȫ������Ʒ����</li>
     *     <li>Ҫ����IGoodsDAO.findAllByStatus()������ѯ��ȫ������Ʒ����</li>
     *     <li>Ҫ����IGoodsDAO.getAllCountByStatus()������ѯ��ȫ������Ʒ������</li>
     *     <li>���õ�ʱ��status���õ�����Ϊ1����ʾ�ϼ���Ʒ</li>
     * @param column
     * @param keyword
     * @param currentPage
     * @param lineSize
     * @return ���ص�����һ���������������ݣ�<br>
     *     <li>key=allItems��value= IItemDAO.findAll(),�������List<Item></li>
     *     <li>key=allGoods��value= IGoodsDAO.findAllByStatus()</li>
     *     <li>key=goodsCount��value= IGoodsDAO.getAllCountByStatus()</li>
     * @throws Exception
     */
    public Map<String, Object> list(int currentPage, int lineSize) throws Exception;

    /**
     * �˽ӿ�������ݵķ�ҳ��ʾ���ܣ�������Ʒ�ķ����ѯ����������·�����<br>
     *     <li>Ҫ����IItemDAO.findAll()������ѯ��ȫ������Ʒ����</li>
     *     <li>Ҫ����IGoodsDAO.findAllByItem()������ѯ��ȫ������Ʒ����</li>
     *     <li>Ҫ����IGoodsDAO.getAllCountByItem()������ѯ��ȫ������Ʒ������</li>
     *     <li>���õ�ʱ��status���õ�����Ϊ1����ʾ�ϼ���Ʒ</li>
     * @param iid
     * @param column
     * @param keyword
     * @param currentPage
     * @param lineSize
     * @return ���ص�����һ���������������ݣ�<br>
     *     <li>key=allItems��value= IItemDAO.findAll(),�������List<Item></li>
     *     <li>key=allGoods��value= IGoodsDAO.findAllByItem()</li>
     *     <li>key=goodsCount��value= IGoodsDAO.getAllCountByItem()</li>
     * @throws Exception
     */
    public Map<String,Object> listByItem(int iid, String column, String keyword, int currentPage, int lineSize)throws Exception;

    /**
     * ������Ҫ��ʾ��Ʒ��������Ϣ�������Ĳ������£�<br>
     *     <li>����IGoodsDAO.findById()�������Ը�����Ʒ��Ų�ѯ��������Ϣ</li>
     *     <li>����IGoodsDAO.doUpdateBow()���������������</li>
     *     <li>����IItemDAO.findById()����,��ѯ���������������</li>
     * @param gid
     * @return ��Ʒ������������Ʒ�����з��أ���������ݷ���ʵ�������󣬷��򷵻�null.
     * @throws Exception
     */
    public Goods show(int gid)throws Exception;
}
