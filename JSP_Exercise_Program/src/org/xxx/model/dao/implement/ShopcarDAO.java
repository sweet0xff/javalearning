package org.xxx.model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xxx.model.dao.IShopcarDAO;
import org.xxx.model.entity.Goods;
import org.xxx.model.entity.Shopcar;

public class ShopcarDAO implements IShopcarDAO {
	Connection conn= null;
	PreparedStatement pstmt = null;

	public ShopcarDAO(Connection conn) {
		this.conn= conn;
	}

	@Override
    public boolean doUpdateAmount(Integer uid, Integer gid) throws SQLException {
        String sql = "UPDATE shopcar SET amount=amount+1 WHERE uid=? AND gid=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, uid);
        pstmt.setInt(2, gid);
        return pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doDelete(Set<Integer> ids) throws Exception {
    	return false;
    }

    @Override
    public Map<Integer, Goods> findGoodsByUid(Integer uid) throws SQLException {
        Map<Integer, Goods> map = new HashMap<Integer, Goods>();
        String sql = "SELECT gid,count FROM shopcar WHERE uid=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, uid);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
        }
        return map;
    }

    @Override
    public boolean doCreate(Shopcar vo) throws SQLException {
        String sql = "INSERT INTO shopcar(gid,mid,amount) VALUES(?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, vo.getGoods().getGid());
        pstmt.setInt(2, vo.getUid());
        pstmt.setInt(3, vo.getAmount());
        return pstmt.executeUpdate() > 0;
    }

	@Override
	public boolean doUpdate(Shopcar vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Shopcar> findAllSplit(Integer currentPage, Integer lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcar> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shopcar findById(Integer uid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doDeleteByUid(Integer uid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}
