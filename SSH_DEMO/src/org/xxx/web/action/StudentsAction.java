package org.xxx.web.action;

import java.util.List;

import org.xxx.model.entity.persist.Classtype;
import org.xxx.model.entity.persist.Students;
import org.xxx.model.entity.persist.StudentsClasstype;
import org.xxx.model.service.ClasstypeService;
import org.xxx.model.service.StudentsService;
import org.xxx.model.service.impl.ClasstypeServiceImpl;

public class StudentsAction {
	private Students students;
//	private Classtype classtype;
//	
//	public Classtype getClasstype() {
//		return classtype;
//	}
//	public void setClasstype(Classtype classtype) {
//		this.classtype = classtype;
//	}
	private Integer cid;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}
	private List<StudentsClasstype> slist ;
	private StudentsService studentsService;
	private ClasstypeService classtypeService;
	private List<Classtype> clist;
	public List<Classtype> getClist() {
		return clist;
	}
	public void setClist(List<Classtype> clist) {
		this.clist = clist;
	}
	public ClasstypeService getClasstypeService() {
		return classtypeService;
	}
	public void setClasstypeService(ClasstypeService classtypeService) {
		this.classtypeService = classtypeService;
	}
	public List<StudentsClasstype> getSlist() {
		return slist;
	}
	public void setSlist(List<StudentsClasstype> slist) {
		this.slist = slist;
	}
	public StudentsService getStudentsService() {
		return studentsService;
	}
	public void setStudentsService(StudentsService studentsService) {
		this.studentsService = studentsService;
	}
	
	public void findAllStudents(){
		slist = studentsService.findAllStudents();
	}
	
	public String findStudentsById(){
		students=studentsService.findStudentsById(students.getSid());
		clist = classtypeService.findAllClasstype();
		return "edit";
	}
	
	public String query(){
		slist=studentsService.findAllStudents();
		return "success";
	}
	public StudentsAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String update(){
//		classtype.setCid(students.getClasstype().getCid());
//		students.setClasstype(classtype);
//		if(studentsService.updateStudents(students)){
//			return "query";
//	}
		
		Classtype classtype =new Classtype();
		classtype.setCid(cid);
		students.setClasstype(classtype);
		if(studentsService.updateStudents(students)){
			return "query";
		}
		return "error";
	}
	
	public String addBefore(){
		clist=classtypeService.findAllClasstype();
		return "add";
	}

	public String add(){
		if(studentsService.addStudents(students)){
			return "query";
		}
		return "error";
	}
	
	public String delete(){
		if(studentsService.delete(students)){
			return "query";
		}
		return "errror";
				
	}
}
