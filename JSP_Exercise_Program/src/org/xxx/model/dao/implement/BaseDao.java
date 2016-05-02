package org.xxx.model.dao.implement;

import java.sql.DriverManager;
import java.sql.Connection;


public class BaseDao {
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=JSP_WEB";
	private static final String DBUSER = "sa";
	private static final String PASSWORD = "sa";

	private Connection conn; //准备一个数据库连接对象；
	/**
	 * 实例化此类对象时会自动进行数据库的连接，为conn实例化
	 */
	public BaseDao(){
		try {
			Class.forName(DRIVER);
			this.conn = DriverManager.getConnection(URL, DBUSER, PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回的是一个Connection接口的实例化对象
	 * @return
	 */
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

