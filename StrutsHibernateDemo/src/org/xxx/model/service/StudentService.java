package org.xxx.model.service;

import org.xxx.model.dao.StudentsDAO;
import org.xxx.model.entity.persist.Students;

public class StudentService {
	StudentsDAO dao = new StudentsDAO();
	
	public Students fingStudentById(Integer sid){
		return dao.doFindStudentById(sid);
	}

	public boolean editStudent(Students vo){
		return dao.doUpdateStudent(vo);
	}
}
