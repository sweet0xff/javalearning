package org.xxx.model.service.back;

import java.util.List;

import org.xxx.model.entity.User;

public interface IUserServiceBack {
    /**
     * 实现全部用户的分页显示，会调用IUserDAO接口中的如下方法:
     *  <li>调用IUserDAO接口中的findAllSplit()方法</li>
     *  <li>调用IUserDAO接口中的getAllCount()方法</li>
     * @param currentPage 表示当前页
     * @param lineSize 表示每页显示记录数
     * @return
     * @throws Exception
     */
    public List<User> listSplit(Integer currentPage, Integer lineSize) throws Exception;

    /**
     * 根据id查询数据,查询一个人员的完整信息
     * @param uid 要查询用户的编号
     * @return
     * @throws Exception
     */
    public User show(Integer uid)throws Exception;
    
    /**
     * 统计用户数量
     * @return
     * @throws Exception
     */
    public Integer findAllCount()throws Exception;
    
    /**
     * 返回所有员工的集合
     * @return
     * @throws Exception
     */
    public List<User> findAll() throws Exception;

    
}
