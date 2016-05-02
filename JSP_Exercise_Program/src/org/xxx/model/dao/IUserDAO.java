package org.xxx.model.dao;

import java.sql.SQLException;
import org.xxx.model.entity.User;

public interface IUserDAO extends IDAO<Integer, User> {

    /**
     * 用户登录检查
     * @param vo 包含要进行检查的用户ID和密码信息
     * @return 成功返回true,失败返回false
     * @throws SQLException
     */
    public boolean findLogin(User vo)throws SQLException;

    /**
     * 更新用户个人信息
     * @param vo
     * @return 成功返回true 失败返回fasle
     * @throws SQLException
     */
    public boolean doUpdateInfo(User vo)throws SQLException;
    
    /**
     * 查询用户总数
     * @param vo
     * @return
     * @throws SQLException
     */
    public Integer doGetAllCount()throws SQLException;
    

    /**
     * 更新用户状态
     * @param mid 用户ID
     * @param status 状态
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(String uid, Integer status) throws SQLException;

    
}
