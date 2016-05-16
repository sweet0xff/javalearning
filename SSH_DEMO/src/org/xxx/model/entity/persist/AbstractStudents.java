package org.xxx.model.entity.persist;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractStudents entity provides the base persistence definition of the
 * Students entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractStudents implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Classtype classtype;
	private String sname;
	private String ssex;

	// Constructors

	/** default constructor */
	public AbstractStudents() {
	}

	/** full constructor */
	public AbstractStudents(Classtype classtype, String sname, String ssex) {
		this.classtype = classtype;
		this.sname = sname;
		this.ssex = ssex;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid")
	public Classtype getClasstype() {
		return this.classtype;
	}

	public void setClasstype(Classtype classtype) {
		this.classtype = classtype;
	}

	@Column(name = "sname", length = 32)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "ssex", length = 32)
	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

}