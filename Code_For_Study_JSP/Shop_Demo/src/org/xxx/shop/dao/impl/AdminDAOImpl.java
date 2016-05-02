package cn.mldn.shop.dao.impl;

import cn.mldn.shop.dao.IAdminDAO;
import cn.mldn.shop.vo.Admin;
import cn.mldn.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;


public class AdminDAOImpl extends AbstractDAOImpl implements IAdminDAO {

    public AdminDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean findLogin(Admin vo) throws SQLException {
        String sql = "SELECT lastdate FROM admin WHERE aid=? AND password=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getAid());
        super.pstmt.setString(2, vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo.setLastdate(rs.getTimestamp(1));
            return true;
        }
        return false;
    }

    @Override
    public boolean doUpdatelastdate(String aid) throws SQLException {
        String sql = "UPDATE admin SET lastdate=? WHERE aid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setTimestamp(1, new Timestamp(new Date().getTime()));
        super.pstmt.setString(2, aid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doCreate(Admin vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doUpdate(Admin vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<String> ids) throws SQLException {
        return false;
    }


    @Override
    public Admin findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Admin> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
