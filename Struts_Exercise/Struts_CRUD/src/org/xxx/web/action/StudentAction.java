package org.xxx.web.action;

import java.util.ArrayList;
import java.util.List;

import org.xxx.factory.ServiceFactory;
import org.xxx.model.dao.entity.Student;
import org.xxx.model.dao.entity.StudentJson;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StudentAction extends ActionSupport {
	private Student student;
	private List<Student> slist= new ArrayList<Student>();
	StudentJson sJson = new StudentJson();
	
	public StudentJson getsJson() {
		return sJson;
	}

	public void setsJson(StudentJson sJson) {
		this.sJson = sJson;
	}

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String creat(){
		try {
			if(ServiceFactory.getIStudentServiceInstance().creat(student)){
				return "success";
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String delete(){
		try {
			if(ServiceFactory.getIStudentServiceInstance().delete(student.getSname())){
				return "success";
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String update(){
		try {
			if(ServiceFactory.getIStudentServiceInstance().update(student)){
				return "success";
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String find(){
		List<Student> slist;
		try {
			slist = ServiceFactory.getIStudentServiceInstance().find();
			if(slist != null && slist.size() != 0){
				sJson.setSlist(slist);
				sJson.setMessageCode(200);
				sJson.setMessageInfo("success");
				
				return "success";
			}else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
