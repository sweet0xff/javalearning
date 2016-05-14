package org.xxx.model.entity.persist;

/**
 * Students entity. @author MyEclipse Persistence Tools
 */

public class Students implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Classtype classtype;
	private String sname;
	private String ssex;

	// Constructors

	/** default constructor */
	public Students() {
	}

	/** full constructor */
	public Students(Classtype classtype, String sname, String ssex) {
		this.classtype = classtype;
		this.sname = sname;
		this.ssex = ssex;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Classtype getClasstype() {
		return this.classtype;
	}

	public void setClasstype(Classtype classtype) {
		this.classtype = classtype;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

}