package org.xxx.model.service.back;

import org.xxx.model.entity.Order;

public interface IOrdersServiceBack {
    /**
     * ����Աȫ�������鿴
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
   // public Map<String,Object> list(Integer currentPage,Integer lineSize)throws Exception;
    
   /**
    * �鿴�������� 
    * @param oid
    * @return
    * @throws Exception
    */
    public Order show(Integer oid)throws Exception;
}
