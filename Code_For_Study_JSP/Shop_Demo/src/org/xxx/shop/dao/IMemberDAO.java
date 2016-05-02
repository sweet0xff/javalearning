package cn.mldn.shop.dao;

import cn.mldn.shop.vo.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IMemberDAO extends IDAO<String, Member> {
    /**
     * 判断给出的mid和code是否相同，如果相同则可以改变用户状态W为正常状态‘1’
     * @param mid 用户ID
     * @param code 激活码
     * @return
     * @throws SQLException
     */
    public boolean findByCode(String mid, String code) throws SQLException;

    /**
     * 更新用户状态
     * @param mid 用户ID
     * @param status 状态
     * @return
     * @throws SQLException
     */
    public boolean doUpdateStatus(String mid, Integer status) throws SQLException;

    /**
     * 用户登录检查
     * @param vo 包含要进行检查的用户ID和密码信息
     * @return 成功返回true,失败返回false
     * @throws SQLException
     */
    public boolean findLogin(Member vo)throws SQLException;

    /**
     * 根据用户状态列出
     * @param status
     * @param column
     * @param keyWord
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Member> findByStatus(Integer status,String column, String keyWord,
                                     Integer currentPage, Integer lineSize)throws SQLException;

    /**
     * 统计状态数据量
     * @param status
     * @param column
     * @param keyWord
     * @return
     * @throws SQLException
     */
    public Integer getAllCountByStatus(Integer status,String column, String keyWord)throws SQLException;

    /**
     * 进行数据的批量更新，状态用户外部设置
     * @param ids
     * @param status
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByStatus(Set<String> ids,Integer status)throws SQLException;

    /**
     * 更新用户个人信息
     * @param vo
     * @return
     * @throws SQLException
     */
    public boolean doUpdateByMember(Member vo)throws SQLException;
}
