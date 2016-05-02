package org.xxx.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.xxx.model.entity.Goods;

public interface IGoodsDAO extends IDAO<Integer, Goods> {
	
    /**
     * ����״̬ʵ�ַ�ҳ
     * @param status
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByStatus(Integer status,Integer currentPage, Integer lineSize) throws SQLException;

    /**
     * ����״̬ͳ��������
     * @param status
     * @param column
     * @param keyWord
     * @return
     * @throws SQLException
     */
    public Integer getAllCountByStatus(Integer status) throws SQLException;

    /**
     * ������Ʒ����޸�״̬
     * @param status
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(Integer status, Integer gid)throws SQLException;

    /**
     * ���·��ʴ�����ÿ�ε��÷��ʴ�����1
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doUpdateBow(Integer gid)throws SQLException;

    /**
     * ��ѯָ����ŵ���Ʒ��Ϣ
     * @param gid
     * @return
     * @throws SQLException
     */
    public Goods findById(Integer gid)throws SQLException;

    /**
     * Ҫ������Ʒ������ĸ���
     * @param gid ��Ʒ���
     * @param num
     * @return
     * @throws SQLException
     */
     public boolean doUpdateByAmount(Integer gid,Integer num)throws SQLException;

     /**
      * ͳ��������Ʒ������
      * @return
      * @throws SQLException
      */
	public Integer getAllCount() throws SQLException;
	
	
    /**
     * ������Ʒ����޸�״̬
     *
     * @param status
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(Integer status, Set<Integer> id)throws SQLException;

    /**
     * ������Ʒ�ķ�����״̬������Ʒ���б���ʾ
     * @param iid ��Ʒ����������
     * @param status ��Ʒ�ĵ�ǰ״̬
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Goods> findAllByItem(Integer iid,Integer status, Integer currentPage, Integer lineSize) throws SQLException;
    /**
     * ����Item��ѯ��Ʒ����
     * @param iid
     * @param status
     * @return
     * @throws SQLException
     */
    public Integer getAllByItem(Integer iid,Integer status) throws SQLException;

}
