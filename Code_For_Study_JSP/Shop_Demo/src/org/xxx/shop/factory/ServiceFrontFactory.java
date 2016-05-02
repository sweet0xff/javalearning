package cn.mldn.shop.factory;


import cn.mldn.shop.service.back.IAdminServiceBack;
import cn.mldn.shop.service.back.impl.AdminServiceBackImpl;
import cn.mldn.shop.service.front.IGoodsServiceFront;
import cn.mldn.shop.service.front.IMemberServiceFront;
import cn.mldn.shop.service.front.IOrdersServiceFront;
import cn.mldn.shop.service.front.IShopcarServiceFront;
import cn.mldn.shop.service.front.impl.GoodsServiceFrontImpl;
import cn.mldn.shop.service.front.impl.MemberFrontServiceImpl;
import cn.mldn.shop.service.front.impl.OrdersServiceFrontImpl;
import cn.mldn.shop.service.front.impl.ShopcarServiceFrontImpl;
import cn.mldn.shop.servlet.back.AdminLoginServletBack;

public class ServiceFrontFactory {
    public static IMemberServiceFront getIMemberServiceFrontInstance() {
        return new MemberFrontServiceImpl();
    }

    public static IGoodsServiceFront getIGoodsServiceFrontInstance() {
        return new GoodsServiceFrontImpl();
    }

    public static IShopcarServiceFront getIShopcarServiceFrontInstance() {
        return new ShopcarServiceFrontImpl();
    }
    public static IOrdersServiceFront getIOrdersServiceFrontInstance() {
        return new OrdersServiceFrontImpl();
    }
}

