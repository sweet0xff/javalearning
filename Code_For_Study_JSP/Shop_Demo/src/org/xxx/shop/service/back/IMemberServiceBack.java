package cn.mldn.shop.service.back;

import cn.mldn.shop.vo.Member;

import java.util.Map;
import java.util.Set;

public interface IMemberServiceBack {
    /**
     * 实现全部数据分页显示，会调用IMemberDAO接口中的如下方法:
     *  <li>调用IMemberDAO接口中的findAllBySplit()方法</li>
     *  <li>调用IMemberDAO接口中的getAllCount()方法</li>
     * @param column 表示要查询的列
     * @param keyWord 表示要查询的关键字
     * @param currentPage 表示当前页
     * @param lineSize 表示每页显示记录数
     * @return
     * @throws Exception
     */
    public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception;

    /**
     *  实现用户状态数据分页显示，会调用IMemberDAO接口中的如下方法:
     * @param status
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws Exception
     */
    public Map<String, Object> listByStatus(int status,String column, String keyWord, int currentPage, int lineSize) throws Exception;

    /**
     * 将用户状态更新为激活状态（status =1）
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean updateActive(Set<String> ids)throws Exception;

    /**
     * 将用户状态更新为锁定状态（status =0）
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean updateLock(Set<String> ids)throws Exception;

    /**
     * 根据id查询数据,查询一个人员的完整信息
     * @param id 要查询人员的编号
     * @return
     * @throws Exception
     */
    public Member show(String id)throws Exception;
}
