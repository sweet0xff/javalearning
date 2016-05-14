package org.xxx.model.entity.persist;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TCustomer entity. @author MyEclipse Persistence Tools
 */

public class TCustomer implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String password;
	private Date birthday;
	private Integer age;
	private Timestamp registeredTime;
	private String addr;
	private Integer eid;
	private Set TOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public TCustomer() {
	}

	/** full constructor */
	public TCustomer(String name, String password, Date birthday, Integer age,
			Timestamp registeredTime, String addr, Integer eid, Set TOrders) {
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.age = age;
		this.registeredTime = registeredTime;
		this.addr = addr;
		this.eid = eid;
		this.TOrders = TOrders;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Timestamp getRegisteredTime() {
		return this.registeredTime;
	}

	public void setRegisteredTime(Timestamp registeredTime) {
		this.registeredTime = registeredTime;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Set getTOrders() {
		return this.TOrders;
	}

	public void setTOrders(Set TOrders) {
		this.TOrders = TOrders;
	}

}