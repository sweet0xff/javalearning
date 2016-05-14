package org.xxx.model.dao;

import java.sql.*;

public class BaseDAO {
	private final static String DRIVER="com.mysql.jdbc.Driver";
	private final static String URL="jdbc:mysql://127.0.0.1:3306/struts_curd";
	private final static String USER="root";
	private final static String PASSWORD="root";
	private Connection conn;
	
	public BaseDAO(){
		 try{
			 Class.forName(DRIVER);
			 this.conn=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return this.conn;
	}

	public void closeAll(){
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
