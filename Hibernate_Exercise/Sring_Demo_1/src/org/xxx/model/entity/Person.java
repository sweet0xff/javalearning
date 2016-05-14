package org.xxx.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
	private String pname;
	private String password;
	
	private Pet pet;
	
	private List<String> games= new ArrayList<String>();
	
	private String[] foods;
	
	private Map<String, Object> configMap= new HashMap<String, Object>();
	
	public Map<String, Object> getConfigMap() {
		return configMap;
	}

	public void setConfig(Map<String, Object> configMap) {
		this.configMap = configMap;
	}

	public String[] getFoods() {
		return foods;
	}

	public void setFoods(String[] foods) {
		this.foods = foods;
	}

	public List<String> getGames() {
		return games;
	}

	public void setGames(List<String> games) {
		this.games = games;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person(String pname, String password) {
		super();
		this.pname = pname;
		this.password = password;
	}
	public Person() {
		super();
	}
	
	public void showPet() {
		System.out.println(pet.getPetname() + " " + pet.getPetage());
	}
	
	public void showGames(){
		for (String g : games) {
			System.out.println(g);
		}
	}
	
	public void showFoods(){
		for (String f : foods) {
			System.out.println(f);
		}
	}
	
	public void showConfigMap(){
		Set<String> keys= configMap.keySet();
		for (String k : keys) {
			System.out.println(k + ": " + configMap.get(k));
			
		}
	}

}
