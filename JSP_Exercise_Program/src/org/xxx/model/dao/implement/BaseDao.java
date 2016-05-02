package org.xxx.model.dao.implement;

import java.sql.DriverManager;
import java.sql.Connection;


public class BaseDao {
	
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=JSP_WEB";
	private static final String DBUSER = "sa";
	private static final String PASSWORD = "sa";

	private Connection conn; //׼��һ�����ݿ����Ӷ���
	/**
	 * ʵ�����������ʱ���Զ��������ݿ�����ӣ�Ϊconnʵ����
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
	 * ���ص���һ��Connection�ӿڵ�ʵ��������
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

