package cn.mldn.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractDAOImpl {
    protected Connection conn;
    protected PreparedStatement pstmt;

    public AbstractDAOImpl(Connection conn) {
        this.conn = conn;
    }

    /**
     * 实现数据的批量删除，但是这个时候的批量删除属于彻底删除功能
     *
     * @param tabName 要删除的表名称
     * @param column  要删除的列
     * @param ids     要删除的集合数据
     * @return 成功返回true, 失败返回false
     * @throws SQLException
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

    /**
     * 实现数据模糊统计操作
     *
     * @param tabName 统计的表名称
     * @param column  统计的表字段
     * @param keyWord 统计的关键字
     * @return 成功返回数据行，失败返回0
     * @throws SQLException
     */
    public Integer countHandel(String tabName, String column, String keyWord) throws SQLException {
        StringBuffer buf = new StringBuffer();
        buf.append(" SELECT COUNT(*) FROM ").append(tabName).append(" WHERE ").append(column).append(" LIKE ? ");
        this.pstmt = this.conn.prepareStatement(buf.toString());
        this.pstmt.setString(1, "%" + keyWord + "%");
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public Set<String> photoHandle(String table, String column, Set<?> ids, String photoColumn) throws SQLException {
        Set<String> all = new HashSet<>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ").append(column).append(" FROM ").append(table).append(" WHERE ").append(column).append(" IN ( ");
        Iterator<?> iter = ids.iterator();
        while (iter.hasNext()) {
            sql.append(iter.next()).append(",");
        }
        sql.delete(sql.length() - 1, sql.length()).append(")");
        sql.append(" AND ").append(photoColumn).append("<>'nophoto.jpg'");
        this.pstmt = this.conn.prepareStatement(sql.toString());
        ResultSet rs = this.pstmt.executeQuery();
        while (rs.next()) {
            all.add(rs.getString(1));
        }
        return all;
    }
}
