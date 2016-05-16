package org.xxx.model.entity.persist;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractClasstype entity provides the base persistence definition of the
 * Classtype entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractClasstype implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private Set<Students> studentses = new HashSet<Students>(0);

	// Constructors

	/** default constructor */
	public AbstractClasstype() {
	}

	/** full constructor */
	public AbstractClasstype(String cname, Set<Students> studentses) {
		this.cname = cname;
		this.studentses = studentses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "cname", length = 32)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classtype")
	public Set<Students> getStudentses() {
		return this.studentses;
	}

	public void setStudentses(Set<Students> studentses) {
		this.studentses = studentses;
	}

}