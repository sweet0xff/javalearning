package cn.mldn.oracle.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 此类专门负责数据库的连接与关闭，只要一实例化此类对象则表示自动连接数据库 
 * 每一个DatabaseConnection对象里面只包含有一个Connection连接
 */
public class DatabaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:MLDN" ;
	private static final String DBUSER = "scott" ;
	private static final String PASSWORD = "tiger" ;
	private Connection conn ;	// 准备出一个数据库连接对象
	/**
	 * 实例化此类对象时会自动的进行数据库的连接，为conn属性实例化
	 * 如果此时数据库连接出现了错误，那么就意味着所有的操作都无法进行了
	 */
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回的是一个Connection接口的实例化对象
	 * @return conn
	 */
	public Connection getConnection() {
		return this.conn ;
	}
	/**
	 * 关闭当前连接对象
	 */
	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
	}
}
