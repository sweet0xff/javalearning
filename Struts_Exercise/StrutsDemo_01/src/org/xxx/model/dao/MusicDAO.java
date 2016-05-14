package org.xxx.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.xxx.model.entity.Music;

public class MusicDAO extends BaseDAO{
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private Connection conn = null;
	
	public boolean creat(Music vo) throws Exception{
		boolean flag = false;
		String sql = "insert into musiclist values(?,?)";
		try {
			conn= this.getConn();
			ps= conn.prepareStatement(sql);
			if(ps.executeUpdate()>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoures(rs, ps, conn);
		}
		return flag;
	}
	public List<Music> find() throws Exception {
		List<Music> mlist = new ArrayList<Music>() ;
		String sql = "select * from musiclist";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Music music = new Music();
				music.setId(rs.getInt("id"));
				music.setMusicname(rs.getString("musicname"));
				music.setSingername(rs.getString("singername"));
				mlist.add(music);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoures(rs, ps, conn);
		}
		return mlist;
		
	}
	
	public Music findById(Integer id) throws Exception{
		Music music = new Music();
		String sql = "select * from musiclist where id = ?";
		try {
			conn = this.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				music.setId(rs.getInt("id"));
				music.setMusicname(rs.getString("musicname"));
				music.setSingername(rs.getString("singername"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeResoures(rs, ps, conn);
		}
		return music;
	}
		
	public boolean update(Music music) throws Exception{
		boolean flag = false;
		String sql="update musiclist set musicname = ? , singername = ? where id = ?";
		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,music.getMusicname());
			ps.setString(2, music.getSingername());
			ps.setInt(3, music.getId());
			if(ps.executeUpdate()>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean delete(Integer id) throws Exception{
		boolean flag = false;
		String sql = "delete from musiclist where id = ?";

		try {
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			flag =  ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResoures(rs, ps, conn);
		}
		return flag;
		
	}
}
