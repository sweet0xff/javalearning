package org.xxx.model.entity;

public class Pet {
	private String petname;
	private String petage;
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getPetage() {
		return petage;
	}
	public void setPetage(String petage) {
		this.petage = petage;
	}
	public Pet(String petname, String petage) {
		super();
		this.petname = petname;
		this.petage = petage;
	}
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
