package org.xxx.model.service;

import java.util.List;

import org.xxx.model.dao.entity.Student;

public interface IStudentService {
	public boolean creat(Student vo)throws Exception;
	public boolean delete(String sname) throws Exception;
	public boolean update(Student vo)throws Exception;
	public List<Student> find()throws Exception;
}
