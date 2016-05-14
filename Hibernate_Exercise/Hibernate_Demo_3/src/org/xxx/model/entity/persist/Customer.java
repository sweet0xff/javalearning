package org.xxx.model.entity.persist;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	
	private Integer id;
	private String name;
	private String password;
	private Date birthday;
	private Integer age;
	private Timestamp register;
	private String addr;
	private Email email;
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	private Set<Orders> orders= new HashSet<Orders>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Customer(String name, String password, Date birthday, Integer age,
			Timestamp register, String addr) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.age = age;
		this.register = register;
		this.addr = addr;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Timestamp getRegister() {
		return register;
	}
	public void setRegister(Timestamp register) {
		this.register = register;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Customer(Integer id, String name, String password, Date birthday,
			Integer age, Timestamp register, String addr, Set<Orders> orders) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.age = age;
		this.register = register;
		this.addr = addr;
		this.orders = orders;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String password, Date birthday, Integer age,
			Timestamp register, String addr, Set<Orders> orders) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.age = age;
		this.register = register;
		this.addr = addr;
		this.orders = orders;
	}
	
}
