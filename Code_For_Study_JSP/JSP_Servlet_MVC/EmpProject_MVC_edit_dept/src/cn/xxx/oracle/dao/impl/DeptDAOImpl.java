package cn.mldn.oracle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.oracle.dao.IDeptDAO;
import cn.mldn.oracle.exception.MethodNotFinishException;
import cn.mldn.oracle.vo.Dept;

public class DeptDAOImpl implements IDeptDAO {
	private Connection conn ;
	private PreparedStatement pstmt ;
	public DeptDAOImpl(Connection conn) {
		this.conn = conn ;
	}
	@Override
	public boolean doCreate(Dept vo) throws Exception {
		String sql = "INSERT INTO dept(deptno,dname,loc) VALUES (?,?,?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, vo.getDeptno());
		this.pstmt.setString(2, vo.getDname());
		this.pstmt.setString(3, vo.getLoc());
		if (this.pstmt.executeUpdate() > 0) {
			return true ;
		}
		return false;
	}

	@Override
	public boolean doUpdate(Dept vo) throws Exception {
		String sql = "UPDATE dept SET dname=?,loc=? WHERE deptno=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, vo.getDname());
		this.pstmt.setString(2, vo.getLoc());
		this.pstmt.setInt(3, vo.getDeptno());
		if (this.pstmt.executeUpdate() > 0) {
			return true ;
		}
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		String sql = "DELETE FROM dept WHERE deptno=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			return true ;
		}
		return false;
	}

	@Override
	public Dept findById(Integer id) throws Exception {
		Dept vo = null ;
		String sql = "SELECT deptno,dname,loc FROM dept WHERE deptno=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2)); 
			vo.setLoc(rs.getString(3));
		}
		return vo;
	}

	@Override
	public List<Dept> findAll() throws Exception {
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "SELECT deptno,dname,loc FROM dept" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Dept vo = new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2)); 
			vo.setLoc(rs.getString(3));
			all.add(vo) ;
		}
		return all;
	}

	@Override
	public List<Dept> findAll(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws Exception {
		throw new MethodNotFinishException("此方法未实现！") ;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		throw new MethodNotFinishException("此方法未实现！") ;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		String sql = "DELETE FROM dept WHERE deptno=?";
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
	public Dept findByIdDetails(Integer id) throws Exception {
		Dept vo = null ;
		String sql = "SELECT d.deptno,d.dname,d.loc,temp.count,temp.sum,temp.avg,temp.max,temp.min,temp.avgyear "
				+ " FROM dept d,"
				+ " (SELECT deptno dno,COUNT(empno) count,SUM(sal+NVL(comm,0)) sum,"
				+ " ROUND(AVG(sal+NVL(comm,0)),2) avg,MAX(sal) max,"
				+ " MIN(sal) min,ROUND(AVG(MONTHS_BETWEEN(SYSDATE,hiredate)/12),2) avgyear"
				+ " FROM emp "
				+ " GROUP BY deptno) temp "
				+ " WHERE deptno=? AND d.deptno=temp.dno(+) ";
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery() ;
		if (rs.next()) {
			vo = new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2)); 
			vo.setLoc(rs.getString(3));
			vo.setStat(new HashMap<String,Object>());
			vo.getStat().put("count", rs.getInt(4)) ;
			vo.getStat().put("sum", rs.getDouble(5)) ;
			vo.getStat().put("avg", rs.getDouble(6)) ;
			vo.getStat().put("max", rs.getDouble(7)) ;
			vo.getStat().put("min", rs.getDouble(8)) ;
			vo.getStat().put("avgyear", rs.getDouble(9)) ;
		}
		return vo;
	}
	@Override
	public List<Dept> findAllDetails() throws Exception {
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = "SELECT d.deptno,d.dname,d.loc, "
				+ " temp.count,temp.sum,temp.avg,temp.max,temp.min,temp.avgyear "
				+ " FROM dept d,"
				+ " (SELECT deptno dno,COUNT(empno) count,SUM(sal+NVL(comm,0)) sum,"
				+ " ROUND(AVG(sal+NVL(comm,0)),2) avg,MAX(sal) max,"
				+ " MIN(sal) min,ROUND(AVG(MONTHS_BETWEEN(SYSDATE,hiredate)/12),2) avgyear"
				+ " FROM emp "
				+ " GROUP BY deptno) temp "
				+ " WHERE d.deptno=temp.dno(+) ";
		this.pstmt = this.conn.prepareStatement(sql) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		while (rs.next()) {
			Dept vo = new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2)); 
			vo.setLoc(rs.getString(3));
			vo.setStat(new HashMap<String,Object>());
			vo.getStat().put("count", rs.getInt(4)) ;
			vo.getStat().put("sum", rs.getDouble(5)) ;
			vo.getStat().put("avg", rs.getDouble(6)) ;
			vo.getStat().put("max", rs.getDouble(7)) ;
			vo.getStat().put("min", rs.getDouble(8)) ;
			vo.getStat().put("avgyear", rs.getDouble(9)) ;
			all.add(vo) ;
		}
		return all;
	}

}
