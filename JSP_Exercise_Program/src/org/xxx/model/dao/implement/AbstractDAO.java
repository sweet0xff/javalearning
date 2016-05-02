package org.xxx.model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractDAO {
	protected Connection conn;
	protected PreparedStatement pstmt;
	
	public AbstractDAO(Connection conn){
		this.conn= conn;
	}

	/**
	 * 实现数据的批量删除
	 * @param tabName 要删除的表名称
	 * @param column 要删除的列
	 * @param ids 要删除的集合数据
	 * @return
	 * @throws Exception
	 */
	 public boolean removeHandle(String tabName, String column, Set<?> ids) throws SQLException {
	        if (ids.size() == 0) { // 表示没有数据
	            return false;
	        }
	        StringBuffer buf = new StringBuffer();
	        buf.append(" DELETE FROM ").append(tabName).append(" WHERE ").append(column).append(" IN (");
	        Iterator<?> iter = ids.iterator();
	        while (iter.hasNext()) {
	            buf.append(iter.next()).append(",");
	        }
	        buf.delete(buf.length() - 1, buf.length()).append(")");
	        this.pstmt = this.conn.prepareStatement(buf.toString());
	        return this.pstmt.executeUpdate() == ids.size();
	    }

}
