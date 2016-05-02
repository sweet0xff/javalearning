package cn.mldn.oracle.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Emp implements Serializable {
	private Integer empno ;
	private String ename ;
	private String job ;
	private Date hiredate ;
	private Double sal ;
	private Double comm ;
	private Emp mgr ;
	private Dept dept ;
	private String note ;
	private String photo ;
	public void setNote(String note) {
		this.note = note;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNote() {
		return note;
	}
	public String getPhoto() {
		return photo;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Dept getDept() {
		return dept;
	}
	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}
	public Emp getMgr() {
		return mgr;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ ", hiredate=" + hiredate + ", sal=" + sal + ", comm=" + comm
				+ "]";
	}
}
