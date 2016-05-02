package cn.mldn.oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.mldn.oracle.dao.IAdminDAO;
import cn.mldn.oracle.vo.Admin;

public class AdminDAOImpl implements IAdminDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null ;
	public AdminDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Admin vo) throws Exception {
		String sql = "INSERT INTO admin(aid,password) VALUES (?,?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getAid());
		this.pstmt.setString(2, vo.getPassword());
		if (this.pstmt.executeUpdate() > 0) {
			return true ;
		}
		return false;
	}

	@Override
	public boolean doUpdate(Admin vo) throws Exception {
		throw new Exception("此方法未实现！") ;
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		throw new Exception("此方法未实现！") ;
	}

	@Override
	public Admin findById(String id) throws Exception {
		throw new Exception("此方法未实现！") ;
	}

	@Override
	public List<Admin> findAll() throws Exception {
		throw new Exception("此方法未实现！") ;
	}

	@Override
	public List<Admin> findAll(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		throw new Exception("此方法未实现！") ;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		throw new Exception("此方法未实现！") ;
	}

	@Override
	public boolean findLogin(Admin vo) throws Exception {
		String sql = "SELECT COUNT(aid) FROM admin WHERE aid=? AND password=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getAid());
		this.pstmt.setString(2, vo.getPassword());
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			if (rs.getInt(1) > 0) {
				return true ;
			}
		}
		return false;
	}

}
