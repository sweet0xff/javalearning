package org.xxx.model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.xxx.model.dao.IUserDAO;
import org.xxx.model.entity.User;

public class UserDAO implements IUserDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;

	public UserDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(User vo) throws SQLException {
		String sql = "INSERT INTO users (uname,uaccount,upassword) VALUES(?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getUname());
		pstmt.setString(2, vo.getUaccount());
		pstmt.setString(3, vo.getUpassword());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doDelete(Set<Integer> ids) throws Exception {
		return false;
	}

	@Override
	public boolean doUpdate(User vo) throws SQLException {
		String sql = "UPDATE User SET uname=?,phone=?,address=?,uphoto=? WHERE uaccount=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getUname());
		pstmt.setString(2, vo.getPhone());
		pstmt.setString(3, vo.getAddress());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public User findById(Integer id) throws SQLException {
		User vo = new User();
		String sql = "SELECT uname, uaccount, upassword, address, phone FROM users where uid =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new User();
			vo.setUname(rs.getString("uname"));
			vo.setUaccount(rs.getString("uaccount"));
			vo.setUpassword(rs.getString("upassword"));
			vo.setAddress(rs.getString("address"));
			vo.setPhone(rs.getString("phone"));
		}
		return vo;
	}

	@Override
	public List<User> findAll() throws SQLException {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			User vo = new User();
			vo.setUid(rs.getInt("uid"));
			vo.setUname(rs.getNString("uname"));
			vo.setUaccount(rs.getNString("uaccount"));
			vo.setUpassword(rs.getString("upassword"));
			vo.setAddress(rs.getString("address"));
			vo.setPhone(rs.getString("phone"));
			users.add(vo);
		}
		return users;
	}

	@Override
	public boolean findLogin(User vo) throws SQLException {
		boolean flag = false;
		String sql = "SELECT uaccount,upassword FROM users WHERE uaccount=? AND upassword=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getUaccount());
		pstmt.setString(2, vo.getUpassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doUpdateInfo(User vo) throws SQLException {
		return false;
	}

	@Override
	public List<User> findAllSplit(Integer currentPage, Integer lineSize)
			throws Exception {
		List<User> ulist = new ArrayList<User>();

		String sql = "select top " + lineSize
				+ " * from users where uid not in (select top ((" + currentPage
				+ "-1)*" + lineSize + ") uid from users)";

		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			User vo = new User();
			vo.setUid(rs.getInt("uid"));
			vo.setUname(rs.getString("uname"));
			vo.setUaccount(rs.getString("uaccount"));
			vo.setUpassword(rs.getString("upassword"));
			vo.setAddress(rs.getString("address"));
			vo.setPhone(rs.getString("phone"));

			ulist.add(vo);
		}
		return ulist;
	}

	@Override
	public Integer doGetAllCount() throws SQLException {
		int count = 0;
		String sql = "SELECT count(*) count FROM users";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("count");
		}
		return count;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdateStatus(String uid, Integer status)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
