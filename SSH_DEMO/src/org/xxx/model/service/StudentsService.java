package org.xxx.model.service;

import java.util.List;

import org.xxx.model.entity.persist.Students;
import org.xxx.model.entity.persist.StudentsClasstype;

public interface StudentsService {

	public List<StudentsClasstype> findAllStudents();
	
	public Students findStudentsById(Integer sid);
	
	public boolean updateStudents(Students vo);
	
	public boolean addStudents(Students vo);
	
//	public boolean deleteStudents(Integer sid);
	
	public boolean delete(Students vo);
		
}
