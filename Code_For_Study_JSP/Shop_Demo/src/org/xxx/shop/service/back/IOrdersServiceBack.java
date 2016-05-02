package cn.mldn.shop.service.back;

import cn.mldn.shop.vo.Orders;

import java.util.Map;

public interface IOrdersServiceBack {
    /**
     * 管理员全部订单查看
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
    public Map<String,Object> list(String column,String keyWord,int currentPage,int lineSize)throws Exception;
    public Orders show(int oid)throws Exception;
}
