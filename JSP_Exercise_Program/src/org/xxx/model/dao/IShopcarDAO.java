package org.xxx.model.dao;

import java.sql.SQLException;
import java.util.Map;

import org.xxx.model.entity.Goods;
import org.xxx.model.entity.Shopcar;

public interface IShopcarDAO extends IDAO<Integer,Shopcar> {
    /**
     * ʵ���ظ�����ʱ��Ӧ�ý��������ݽ�������
     * @param uid
     * @param gid
     * @return
     * @throws SQLException
     */
    public boolean doUpdateAmount(Integer uid,Integer gid)throws SQLException;

    /**
     * �����û����,��ѯ�����ﳵ����Ϣ
     * @param uid �û����
     * @param gid ��Ʒ���
     * @return
     * @throws SQLException
     */
    public Shopcar findById(Integer uid)throws SQLException;

    /**
     * ����û����ﳵ��������Ʒ��Ϣ
     * @param uid �û����
     * @return
     * @throws SQLException
     */
    public boolean doDeleteByUid(Integer uid)throws SQLException;

    /**
     * һ���û������������Ʒ����Ϣ
     * @param uid
     * @return
     * @throws SQLException
     */
    public Map<Integer,Goods> findGoodsByUid(Integer uid)throws SQLException;

}
