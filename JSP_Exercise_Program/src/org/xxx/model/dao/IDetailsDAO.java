package org.xxx.model.dao;

import java.util.List;

import org.xxx.model.entity.Details;

public interface IDetailsDAO extends IDAO<Integer, Details> {
    /**
     * 根据订单编号查询出一个订单的完整详情内容
     * @param oid
     * @return
     * @throws Exception
     */
    public List<Details> findAllByOrders(Integer oid)throws Exception;
}
