package cn.mldn.shop.dao.impl;

import cn.mldn.shop.dao.IMemberDAO;
import cn.mldn.shop.vo.Member;
import cn.mldn.util.dao.AbstractDAOImpl;

import javax.swing.text.html.HTMLDocument;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MemberDAOImpl extends AbstractDAOImpl implements IMemberDAO {

    public MemberDAOImpl(Connection conn) {
        super(conn);
    }

    @Override
    public boolean doCreate(Member vo) throws SQLException {
        String sql = "INSERT INTO member (mid,password,code,regdate,status,photo) VALUES(?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, vo.getMid());
        this.pstmt.setString(2, vo.getPassword());
        this.pstmt.setString(3, vo.getCode());
        this.pstmt.setTimestamp(4, new Timestamp(vo.getRegdate().getTime()));
        this.pstmt.setInt(5, vo.getStatus());
        this.pstmt.setString(6, vo.getPhoto());
        return this.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doUpdate(Member vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemoveBatch(Set<String> ids) throws SQLException {
        return false;
    }


    @Override
    public Member findById(String id) throws SQLException {
        Member vo = null;
        String sql = "SELECT mid,password,name,phone,address,code,regdate,photo,status FROM member WHERE mid=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, id);
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCode(rs.getString(6));
            vo.setRegdate(rs.getDate(7));
            vo.setPhoto(rs.getString(8));
            vo.setStatus(rs.getInt(9));
        }
        return vo;
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Member> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Member> all = new ArrayList<Member>();
        String sql = " SELECT mid,password,name,phone,address,code,regdate,photo,status FROM member WHERE " + column + " LIKE ? LIMIT ?,? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        super.pstmt.setInt(2, (currentPage - 1) * lineSize);
        super.pstmt.setInt(3, lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Member vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCode(rs.getString(6));
            vo.setRegdate(rs.getDate(7));
            vo.setPhoto(rs.getString(8));
            vo.setStatus(rs.getInt(9));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return super.countHandel("member", column, keyWord);
    }

    @Override
    public boolean findByCode(String mid, String code) throws SQLException {
        String sql = "SELECT COUNT(*) FROM member WHERE mid=? AND code=?";
        super.pstmt = this.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        super.pstmt.setString(2, code);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            if (rs.getInt(1) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doUpdateStatus(String mid, Integer status) throws SQLException {
        String sql = "UPDATE member SET status=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setInt(1, status);
        super.pstmt.setString(2, mid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean findLogin(Member vo) throws SQLException {
        boolean flag = false;
        String sql = "SELECT photo FROM member WHERE mid=? AND password=? AND status=1";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getPassword());
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            flag = true;
            vo.setPhoto(rs.getString(1));
        }
        return flag;
    }

    @Override
    public List<Member> findByStatus(Integer status, String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        List<Member> all = new ArrayList<Member>();
        String sql = " SELECT mid,password,name,phone,address,code,regdate,photo,status FROM member WHERE " + column + " LIKE ? AND status=? LIMIT ?,? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        super.pstmt.setInt(2, status);
        super.pstmt.setInt(3, (currentPage - 1) * lineSize);
        super.pstmt.setInt(4, lineSize);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            Member vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setPhone(rs.getString(4));
            vo.setAddress(rs.getString(5));
            vo.setCode(rs.getString(6));
            vo.setRegdate(rs.getDate(7));
            vo.setPhoto(rs.getString(8));
            vo.setStatus(rs.getInt(9));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCountByStatus(Integer status, String column, String keyWord) throws SQLException {
        String sql = " SELECT COUNT(*) FROM member WHERE " + column + " LIKE ?  AND status=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        super.pstmt.setInt(2, status);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doUpdateByStatus(Set<String> ids, Integer status) throws SQLException {
        if (ids.size() == 0) {
            return false;
        }
        boolean flag = true;
        String sql = " UPDATE member SET status=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        Iterator<String> iter = ids.iterator();
        while (iter.hasNext()) {
            super.pstmt.setInt(1, status);
            super.pstmt.setString(2, iter.next());
            super.pstmt.addBatch(); // 增加到批处理
        }
        int result[] = super.pstmt.executeBatch(); // 执行批处理
        for (int x = 0; x < result.length; x++) {
            if (result[x] == 0) {
                flag = false;
            }
        }
        return true;
    }

    @Override
    public boolean doUpdateByMember(Member vo) throws SQLException {
        String sql = "UPDATE member SET name=?,phone=?,address=?,photo=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getName());
        super.pstmt.setString(2, vo.getPhone());
        super.pstmt.setString(3, vo.getAddress());
        super.pstmt.setString(4, vo.getPhoto());
        super.pstmt.setString(5, vo.getMid());
        return super.pstmt.executeUpdate() > 0;
    }
}
