package cn.mldn.shop.service.back;

import cn.mldn.shop.vo.Admin;

public interface IAdminServiceBack {
    /**
     * 用户登录验证，验证成功取出最后一次登录日期
     * @param vo 包含用户名和密码信息
     * @return
     * @throws Exception
     */
    public boolean login(Admin vo)throws Exception;
}
