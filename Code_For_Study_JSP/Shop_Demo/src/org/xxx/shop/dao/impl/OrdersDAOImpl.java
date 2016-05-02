package cn.mldn.shop.dao.impl;

import cn.mldn.shop.dao.IOrdersDAO;
import cn.mldn.shop.vo.Member;
import cn.mldn.shop.vo.Orders;
import cn.mldn.util.dao.AbstractDAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrdersDAOImpl extends AbstractDAOImpl implements IOrdersDAO {
    public OrdersDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public Integer findLastInsertId() throws SQLException {
        String sql = "SELECT LAST_INSERT_ID()";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doCreateOrders(Orders vo) throws SQLException {
        String sql = "INSERT INTO orders(mid,name,phone,address,credate,pay) VALUES (?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMember().getMid());
        super.pstmt.setString(2, vo.getName());
        super.pstmt.setString(3, vo.getPhone());
        super.pstmt.setString(4, vo.getAddress());
        super.pstmt.setTimestamp(5, new Timestamp(vo.getCredate().getTime()));
        super.pstmt.setDouble(6, vo.getPay());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public List<Orders> findAllByMember(String mid, Integer curentPage, Integer lineSize) throws SQLException {
        List<Orders> all = new ArrayList<>();
        String sql = "SELECT oid,mid,name,phone,address,credate,pay FROM orders WHERE mid=? LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        super.pstmt.setInt(2, (curentPage - 1) * lineSize);
        super.pstmt.setInt(3, lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Orders vo = new Orders();
            vo.setOid(rs.getInt(1));
            Member member = new Member();
            member.setMid(rs.getString(2));
            vo.setMember(member);
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCredate(rs.getDate(6));
            vo.setPay(rs.getDouble(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCountByMember(String mid) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public Orders findByIdAndMember(String mid, Integer oid) throws SQLException {
        Orders vo = null;
        String sql = "SELECT oid,mid,name,phone,address,credate,pay FROM orders WHERE mid=? AND oid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        super.pstmt.setInt(2, oid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Orders();
            vo.setOid(rs.getInt(1));
            Member member = new Member();
            member.setMid(rs.getString(2));
            vo.setMember(member);
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCredate(rs.getDate(6));
            vo.setPay(rs.getDouble(7));
        }
        return vo;
    }

    @Override
    public boolean doCreate(Orders vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doUpdate(Orders vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
        return false;
    }

    @Override
    public Orders findById(Integer id) throws SQLException {
        Orders vo = null;
        String sql = "SELECT oid,mid,name,phone,address,credate,pay FROM orders WHERE oid=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Orders();
            vo.setOid(rs.getInt(1));
            Member member = new Member();
            member.setMid(rs.getString(2));
            vo.setMember(member);
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCredate(rs.getDate(6));
            vo.setPay(rs.getDouble(7));
        }
        return vo;
    }

    @Override
    public List<Orders> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Orders> all = new ArrayList<>();
        String sql = "SELECT oid,mid,name,phone,address,credate,pay FROM orders WHERE " + column + " LIKE ?  LIMIT ?,?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        super.pstmt.setInt(2, (currentPage - 1) * lineSize);
        super.pstmt.setInt(3, lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Orders vo = new Orders();
            vo.setOid(rs.getInt(1));
            Member member = new Member();
            member.setMid(rs.getString(2));
            vo.setMember(member);
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCredate(rs.getDate(6));
            vo.setPay(rs.getDouble(7));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders WHERE " + column + " LIKE ? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
