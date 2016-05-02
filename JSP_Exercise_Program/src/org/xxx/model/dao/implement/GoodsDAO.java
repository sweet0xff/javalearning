package org.xxx.model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.xxx.model.dao.IGoodsDAO;
import org.xxx.model.entity.Goods;

public class GoodsDAO  implements IGoodsDAO {
	Connection conn= null;
	PreparedStatement pstmt = null;

	public GoodsDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Goods vo) throws Exception {
		String sql ="INSERT INTO goods (gname,price,amount,note,status,gphoto) VALUES (?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getGname());
        pstmt.setDouble(2, vo.getPrice());
        pstmt.setInt(3, vo.getAmount());
        pstmt.setString(4, vo.getNote());
        pstmt.setInt(5, vo.getStatus());
        pstmt.setString(6, vo.getGphoto());
        return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doDelete(Set<Integer> ids) throws Exception {

		return false;
	}
	
	@Override
	public boolean doUpdate(Goods vo) throws Exception {
		String sql = "UPDATE goods SET gname=?,price=?,amount = ?,note = ?,status = ?,gphoto = ? where gid = ?";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, vo.getGname());;
	    pstmt.setDouble(2, vo.getPrice());
	    pstmt.setInt(3, vo.getAmount());
	    pstmt.setString(4, vo.getNote());
	    pstmt.setInt(5, vo.getAmount());
	    pstmt.setString(6,vo.getGphoto());
	    return pstmt.executeUpdate() > 0;
	}
	
	@Override
	public Goods findById(Integer gid) throws SQLException {
		Goods vo = new Goods();
		String sql = "SELECT gid,gname,price,amount,note,status,photo FROM Goods WHERE gid = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, gid);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
        	vo.setGname(rs.getString("gname"));
        	vo.setPrice(rs.getDouble("price"));
        	vo.setAmount(rs.getInt("amount"));
        	vo.setNote(rs.getString("note"));
        	vo.setStatus(rs.getInt("status"));
        	vo.setGphoto(rs.getString("gphoto"));
        }
        return vo;
	}

//	@Override
//	public List<Goods> findAll() throws Exception {
		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean doUpdateStatus(Integer status, Integer gid) throws SQLException {
		String sql = "UPDATE goods SET status = ? WHRER gid = ?";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setInt(1, status);
	    pstmt.setInt(2, gid);
	    return pstmt.executeUpdate() > 0;
	}
	

	public boolean doUpdateAmount(Integer gid, Integer num) throws SQLException {
		String sql = "UPDATE goods SET amount = ? Where gid = ?";
        pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		pstmt.setInt(2, gid);
        return pstmt.executeUpdate() > 0;
	}

	@Override
	public List<Goods> findAllSplit(Integer currentPage, Integer lineSize)throws SQLException {
		return null;
	}

	@Override
	public Integer getAllCount() {
		return null;
	}

	@Override
	public List<Goods> findAll() throws Exception {
		return null;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Goods> findAllByStatus(Integer status, Integer currentPage,
			Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCountByStatus(Integer status) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doUpdateBow(Integer gid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdateByAmount(Integer gid, Integer num)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdateStatus(Integer status, Set<Integer> id)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Goods> findAllByItem(Integer iid, Integer status,
			Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllByItem(Integer iid, Integer status)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
