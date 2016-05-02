package org.xxx.model.dao;

import java.util.List;

import org.xxx.model.entity.Details;

public interface IDetailsDAO extends IDAO<Integer, Details> {
    /**
     * ���ݶ�����Ų�ѯ��һ��������������������
     * @param oid
     * @return
     * @throws Exception
     */
    public List<Details> findAllByOrders(Integer oid)throws Exception;
}
