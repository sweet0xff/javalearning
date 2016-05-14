package org.xxx.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.xxx.model.dao.IStudentDAO;
import org.xxx.model.dao.entity.Student;

public class StudentDAO implements IStudentDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	
	public StudentDAO(Connection conn) {
		this.conn=conn;
	}

	@Override
	public boolean doCreat(Student vo) throws Exception{
		boolean flag=false;
		String sql= "INSERT INTO students(sname,cid) values(?,?)";
		this.ps=this.conn.prepareStatement(sql);
		this.ps.setString(1, vo.getSname());
		this.ps.setInt(2, vo.getCid());
		if(ps.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean doDelete(String sname)throws Exception {
		boolean flag=false;
		String sql = "delete from students where sid = ?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, sname);
		if(ps.executeUpdate()>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Student vo) throws Exception{
		boolean flag = false;
		String sql = "Update students set cid = ? where sname = ?";
		this.ps= this.conn.prepareStatement(sql);
		this.ps.setInt(1, vo.getCid());
		this.ps.setString(2, vo.getSname());
		if(ps.executeUpdate()>0){
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Student> doFindAll() throws Exception {
	 	List<Student> slist = new ArrayList<Student>();
		String sql = "select * from students";
		this.ps=this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Student vo = new Student();
			vo.setSid(rs.getInt("sid"));
			vo.setSname(rs.getString("sname"));
			vo.setCid(rs.getInt("cid"));
			slist.add(vo);
		}
		return slist;
	}

	@Override
	public Student doFindByName(String sname)  throws Exception{
		String sql = "select * from students where sid = ?";
		this.ps= this.conn.prepareStatement(sql);
		ps.setString(1, sname);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Student vo = new Student();
			vo.setSid(rs.getInt("sid"));
			vo.setSname(rs.getString("sname"));
			vo.setCid(rs.getInt("cid"));
			return vo;
		}else {
			return null;
		}
	}
}
