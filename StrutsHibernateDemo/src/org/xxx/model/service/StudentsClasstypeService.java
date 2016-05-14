package org.xxx.model.service;

import java.util.List;

import org.xxx.model.dao.StudentsDAO;
import org.xxx.model.entity.vo.Students_Classtype;

public class StudentsClasstypeService {
	StudentsDAO dao=  new StudentsDAO();
	
	public List<Students_Classtype> findAll(){
		return dao.doFindAllStudents();
	}

}
