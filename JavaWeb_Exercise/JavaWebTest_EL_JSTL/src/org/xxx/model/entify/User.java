package org.xxx.model.entify;

public class User {

	private String name;
	private String password;

	private Pet P;

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

	public Pet getP() {
		return P;
	}

	public void setP(Pet p) {
		P = p;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String password, Pet p) {
		super();
		this.name = name;
		this.password = password;
		P = p;
	}


	
}
