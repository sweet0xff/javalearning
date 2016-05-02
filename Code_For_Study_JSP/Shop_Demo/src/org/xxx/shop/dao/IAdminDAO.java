package cn.mldn.shop.dao;


import cn.mldn.shop.vo.Admin;

import java.sql.SQLException;
import java.util.Date;

public interface IAdminDAO extends IDAO<String,Admin> {
    /**
     * 用户登录验证
     * @param vo 包含要验证的用户名和密码
     * @return 成功返回true，失败返回false
     * @throws SQLException
     */
    public boolean findLogin(Admin vo)throws SQLException;

    /**
     * 本操作是更新最后一次登录日期，只需要传入管理员编号即可
     * @param aid
     * @return
     * @throws SQLException
     */
    public boolean doUpdatelastdate(String aid)throws SQLException;
}
