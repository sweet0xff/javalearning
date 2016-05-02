package cn.mldn.shop.factory;


import cn.mldn.shop.service.back.*;
import cn.mldn.shop.service.back.impl.*;
import cn.mldn.shop.service.front.IMemberServiceFront;
import cn.mldn.shop.service.front.impl.MemberFrontServiceImpl;

public class ServiceBackFactory {

    public static IAdminServiceBack getIAdminServiceBacktInstance() {
        return new AdminServiceBackImpl();
    }

    public static IMemberServiceBack getIMemberServiceBackInstance() {
        return new MemberServiceBackImpl();
    }

    public static IItemServiceBack getIItemServiceBackInstance() {
        return new ItemServiceBackImpl();
    }

    public static IGoodsServiceBack getIGoodsServiceBackInstance() {
        return new GoodsServiceBackImpl();
    }
    public static IOrdersServiceBack getIOrdersServiceBackInstance() {
        return new OrdersServiceBackImpl();
    }
}
