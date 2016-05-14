package org.xxx.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.xxx.model.entity.User;

public class UserDAO extends BaseDAO{
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection conn = null;
	
	public User doLogin(User vo) throws SQLException{
		User returnUser = new User();
		String sql = "select * from users where name = ? and password = ?";
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				returnUser.setName(rs.getString("name"));
				returnUser.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeAll(rs, ps, conn);
		}
		return returnUser;
		
	}

}
