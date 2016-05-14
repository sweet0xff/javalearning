package org.xxx.model.entity.persist;

import java.util.HashSet;
import java.util.Set;

/**
 * TCategory entity. @author MyEclipse Persistence Tools
 */

public class TCategory implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Set categoryItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public TCategory() {
	}

	/** full constructor */
	public TCategory(String name, Set categoryItems) {
		this.name = name;
		this.categoryItems = categoryItems;
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

	public Set getCategoryItems() {
		return this.categoryItems;
	}

	public void setCategoryItems(Set categoryItems) {
		this.categoryItems = categoryItems;
	}

}