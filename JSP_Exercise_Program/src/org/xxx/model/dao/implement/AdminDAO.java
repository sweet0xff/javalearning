package org.xxx.model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.xxx.model.dao.IAdminDAO;
import org.xxx.model.entity.Admin;

public class AdminDAO  implements IAdminDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public AdminDAO(Connection conn) {
		this.conn=conn;
	}
	
	 @Override
	public boolean findLogin(Admin vo) throws SQLException {
	    String sql = "SELECT aname,apassword FROM admin WHERE aname=? AND apassword=?";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, vo.getAname());
	    pstmt.setString(2, vo.getApassword());
	    ResultSet rs = pstmt.executeQuery();
	    if (rs.next()) {
	        return true;
	    }
	    return false;
	}

	@Override
	public boolean doCreate(Admin vo) throws Exception {
		return false;
	}

	@Override
	public boolean doUpdate(Admin vo) throws Exception {
		return false;
	}

	@Override
	public Admin findById(String id) throws Exception {
		return null;
	}

	@Override
	public List<Admin> findAllSplit(Integer currentPage, Integer lineSize)
			throws Exception {
		return null;
	}

	@Override
	public List<Admin> findAll() throws Exception {
		return null;
	}

	@Override
	public boolean doDelete(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
