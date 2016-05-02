package org.xxx.model.service.back;

import org.xxx.model.entity.Order;

public interface IOrdersServiceBack {
    /**
     * 管理员全部订单查看
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
   // public Map<String,Object> list(Integer currentPage,Integer lineSize)throws Exception;
    
   /**
    * 查看订单详情 
    * @param oid
    * @return
    * @throws Exception
    */
    public Order show(Integer oid)throws Exception;
}
