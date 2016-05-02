package cn.mldn.oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.oracle.dao.IEmpDAO;
import cn.mldn.oracle.vo.Emp;

public class EmpDAOImpl implements IEmpDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	public EmpDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Emp vo) throws Exception {
		String sql = "INSERT INTO emp(empno,ename,job,hiredate,sal,comm) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getEmpno());
		this.pstmt.setString(2, vo.getEname());
		this.pstmt.setString(3, vo.getJob());
		this.pstmt.setDate(4, new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(5, vo.getSal());
		this.pstmt.setDouble(6, vo.getComm());
		if (this.pstmt.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdate(Emp vo) throws Exception {
		String sql = "UPDATE emp SET ename=?,job=?,hiredate=?,sal=?,comm=? WHERE empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getEname());
		this.pstmt.setString(2, vo.getJob());
		this.pstmt.setDate(3, new java.sql.Date(vo.getHiredate().getTime()));
		this.pstmt.setDouble(4, vo.getSal());
		this.pstmt.setDouble(5, vo.getComm());
		this.pstmt.setInt(6, vo.getEmpno());
		if (this.pstmt.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		String sql = "DELETE FROM emp WHERE empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Emp findById(Integer id) throws Exception {
		Emp vo = null;
		String sql = "SELECT empno,ename,job,hiredate,sal,comm FROM emp WHERE empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
		}
		return vo;
	}

	@Override
	public List<Emp> findAll() throws Exception {
		List<Emp> all = new ArrayList<Emp>();
		String sql = "SELECT empno,ename,job,hiredate,sal,comm FROM emp";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Emp> findAll(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		List<Emp> all = new ArrayList<Emp>();
		String sql = " SELECT * FROM ( "
				+ " SELECT empno,ename,job,hiredate,sal,comm,ROWNUM rn "
				+ " FROM emp WHERE " + column + " LIKE ? AND ROWNUM<=?) temp "
				+ " WHERE temp.rn>? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setInt(2, currentPage * lineSize);
		this.pstmt.setInt(3, (currentPage - 1) * lineSize);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Emp vo = new Emp();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getDouble(5));
			vo.setComm(rs.getDouble(6));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String sql = "SELECT COUNT(empno) count FROM emp WHERE " + column + " LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			return rs.getInt(1) ;
		}
		return 0 ;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		String sql = "DELETE FROM emp WHERE empno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		Iterator<Integer> iter = ids.iterator() ;
		while(iter.hasNext()) {
			this.pstmt.setInt(1, iter.next());
			this.pstmt.addBatch();// 加入批处理，等待执行
		}
		int result [] = this.pstmt.executeBatch() ;
		for (int x = 0; x < result.length; x++) {
			if (result[x] == 0) {	// 没有影响的行数
				return false ; 
			}
		}
		return true ;
	}
	@Override
	public boolean doRemoveByDeptno(Set<Integer> ids) throws Exception {
		StringBuffer buf = new StringBuffer() ;	// 由于需要拼凑SQL
		buf.append("DELETE FROM emp WHERE deptno IN (") ;
		Iterator<Integer> iter = ids.iterator() ;
		while (iter.hasNext()) {
			buf.append(iter.next()).append(",") ;
		}
		buf.delete(buf.length() - 1, buf.length()); // 删掉多余的“,”
		buf.append(")") ;
		this.pstmt = this.conn.prepareStatement(buf.toString()) ;
		if (this.pstmt.executeUpdate() > 0) {
			return true ; 
		}
		return false;
	}

	@Override
	public Integer getAllCountByDeptno(Integer deptno) throws Exception {
		String sql = "SELECT COUNT(empno) count FROM emp WHERE deptno=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, deptno);
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			return rs.getInt(1) ;
		}
		return 0 ;
	}
}
