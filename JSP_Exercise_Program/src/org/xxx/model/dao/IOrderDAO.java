package org.xxx.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.xxx.model.entity.Order;

public interface IOrderDAO extends IDAO<Integer, Order> {

    /**
     * �����û�����г������û�������Ϣ
     * @param uid
     * @param curentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Order> findAllByUserId(Integer gid,Integer curentPage,Integer lineSize) throws SQLException;
    
    /**
     * ��ѯĳ���û�����Ʒ��������
     * @param uid
     * @return
     * @throws SQLException
     */
    public Integer getAllCountByUserId(Integer gid)throws  SQLException;

    /**
     * ��ѯһ���û���һ��������Ϣ
     * @param uid
     * @param oid
     * @return
     * @throws SQLException
     */
    public Order findByOid(Integer uid,Integer oid)throws SQLException;
}
