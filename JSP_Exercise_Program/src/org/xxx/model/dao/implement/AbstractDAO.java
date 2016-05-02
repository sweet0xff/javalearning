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
	 * ʵ�����ݵ�����ɾ��
	 * @param tabName Ҫɾ���ı�����
	 * @param column Ҫɾ������
	 * @param ids Ҫɾ���ļ�������
	 * @return
	 * @throws Exception
	 */
	 public boolean removeHandle(String tabName, String column, Set<?> ids) throws SQLException {
	        if (ids.size() == 0) { // ��ʾû������
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
