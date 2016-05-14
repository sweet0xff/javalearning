package org.xxx.model.entity.persist;

import java.util.HashSet;
import java.util.Set;

/**
 * TItem entity. @author MyEclipse Persistence Tools
 */

public class TItem implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Double basePrice;
	private Set categoryItems = new HashSet(0);
	private Set orderItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public TItem() {
	}

	/** full constructor */
	public TItem(String name, Double basePrice, Set categoryItems,
			Set orderItems) {
		this.name = name;
		this.basePrice = basePrice;
		this.categoryItems = categoryItems;
		this.orderItems = orderItems;
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

	public Double getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Set getCategoryItems() {
		return this.categoryItems;
	}

	public void setCategoryItems(Set categoryItems) {
		this.categoryItems = categoryItems;
	}

	public Set getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set orderItems) {
		this.orderItems = orderItems;
	}

}