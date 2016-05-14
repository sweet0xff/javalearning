package org.xxx.web.action;

import java.util.List;

import org.xxx.factory.ServiceFactory;
import org.xxx.model.entity.persist.Classtype;
import org.xxx.model.entity.persist.Students;

public class StudentAction {
	private Students student;

	private List<Classtype> clist;
	
	public List<Classtype> getClist() {
		return clist;
	}

	public void setClist(List<Classtype> clist) {
		this.clist = clist;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
	public String findStudentById(){
		student = ServiceFactory.getStudentServiceInstance().fingStudentById(student.getSid());
		if(student != null){
			clist = ServiceFactory.getClasstypeServiceInstance().findAllClasstypes();
			return "edit";
		}
		
		return "error";
	}

	public String editStudent(){
//		student.setClasstype(ServiceFactory.getClasstypeServiceInstance().);
		if(ServiceFactory.getStudentServiceInstance().editStudent(student)){
			return "success";
		}
		return "error";
	}
	
}
