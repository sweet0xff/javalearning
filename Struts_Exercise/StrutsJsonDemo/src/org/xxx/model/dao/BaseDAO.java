package org.xxx.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {
	private static final String DRIVER ="com.mysql.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/test";
	private static final String USER ="root";
	private static final String PASSWORD ="root";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		return conn;
	}
	
	public void closeAll(ResultSet rs,PreparedStatement ps,Connection conn) throws SQLException{
		if(rs !=null){
			rs.close();
		}
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			conn.close();
		}
	}

}
