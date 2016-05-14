package org.xxx.model.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.xxx.model.dao.IAdminDAO;
import org.xxx.model.dao.entity.Admin;


public class AdminDAO implements IAdminDAO {
	PreparedStatement ps = null;
	Connection conn = null;

	public AdminDAO(Connection conn){
		this.conn=conn;
	}

	@Override
	public boolean doLogin(Admin vo)throws Exception {
		String sql="select * from admin where aname=? and apassword = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getAname());
		ps.setString(2, vo.getApassword());		
		ResultSet rs= ps.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}


}
