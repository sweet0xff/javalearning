package org.xxx.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDAO {
	private String DRIVER="com.mysql.jdbc.Driver";
	private String URL="jdbc:mysql://localhost:3306/strutsdemo";
	private String UID="root";
	private String UPASSWORD="root";
	

	// 获取连接
	public Connection getConn() throws Exception {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, UID, UPASSWORD);
		return conn;
	}

	// 关闭资源
	public void closeResoures(ResultSet rs, PreparedStatement ps,
			Connection conn) throws Exception {
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

}
