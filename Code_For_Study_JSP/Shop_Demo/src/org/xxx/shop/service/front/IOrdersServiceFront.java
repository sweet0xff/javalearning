package cn.mldn.shop.service.front;

import cn.mldn.exception.EmptyShopcarException;
import cn.mldn.exception.UnCompleteMemberInfomrationException;
import cn.mldn.exception.UnEnoughAmountException;
import cn.mldn.shop.vo.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IOrdersServiceFront {
    /**
     *
     * @param mid 要创建订单的用户ID
     * @return 如果订单创建成功返回true,否则返回false
     * @throws UnCompleteMemberInfomrationException 个人信息不完整是抛出异常
     * @throws UnEnoughAmountException 商品库存量不足抛出异常
     * @throws EmptyShopcarException 购物车没有数据抛出异常
     * @throws SQLException JDBC错误造成的异常
     */
    public boolean insert(String mid) throws UnCompleteMemberInfomrationException, UnEnoughAmountException, EmptyShopcarException,SQLException;

    /**
     * 查看一个用户的所有订单信息
     * @param mid
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
    public Map<String,Object> listByMember(String mid,int currentPage,int lineSize)throws Exception;

    /**
     * 查询一个订单信息已经对应的所有详情信息
     * @param mid
     * @param oid
     * @return
     * @throws Exception
     */
    public Orders show(String mid,int oid)throws Exception;
}
