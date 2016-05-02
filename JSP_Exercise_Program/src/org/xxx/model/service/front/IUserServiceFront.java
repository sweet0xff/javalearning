package org.xxx.model.service.front;

import org.xxx.model.entity.User;

public interface IUserServiceFront {
    /**
     * 此方法是完成用户注册操作操作：
     * <li>在增加数据前先要判断要增加的数据是否存在，使用IMemberDAO接口中的findById()方法，查询要增加的数据是否存在，如果存在表示不可以增加</li>
     * @param vo 要增加数据的vo对象
     * @return 成功返回true,失败返回false
     * @throws Exception
     */
    public boolean regist(User vo)throws Exception;

    /**
     * 用户登录操作，调用IMemberDAO接口中的findLogin()方法，
     * @param vo 包含有用户的mid和密码信息
     * @return 成功返回首页，失败返回登陆页面
     * @throws Exception
     */
    public boolean login(User vo)throws Exception;

    /**
     * 根据编号查询数据行中的全部记录
     * @param mid
     * @return
     * @throws Exception
     */
    public User updatePre(String mid)throws Exception;

    /**
     * 用户数据更新操作
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean update(User vo)throws Exception;
}
