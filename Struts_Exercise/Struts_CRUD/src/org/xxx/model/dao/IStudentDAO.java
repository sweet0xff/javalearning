package org.xxx.model.dao;

import java.util.List;

import org.xxx.model.dao.entity.Student;

public interface IStudentDAO {

	public boolean doCreat(Student vo) throws Exception;
	public boolean doDelete(String sname)throws Exception;
	public boolean doUpdate(Student vo)throws Exception;
	public List<Student> doFindAll()throws Exception;
	public Student doFindByName(String sname)throws Exception;

}
