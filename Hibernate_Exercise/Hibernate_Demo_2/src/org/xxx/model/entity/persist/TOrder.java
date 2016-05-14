package org.xxx.model.entity.persist;

import java.util.HashSet;
import java.util.Set;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

	private Long id;
	private TCustomer TCustomer;
	private String orderNumber;
	private Double orderPrice;
	private Set orderItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public TOrder() {
	}

	/** minimal constructor */
	public TOrder(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/** full constructor */
	public TOrder(TCustomer TCustomer, String orderNumber, Double orderPrice,
			Set orderItems) {
		this.TCustomer = TCustomer;
		this.orderNumber = orderNumber;
		this.orderPrice = orderPrice;
		this.orderItems = orderItems;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TCustomer getTCustomer() {
		return this.TCustomer;
	}

	public void setTCustomer(TCustomer TCustomer) {
		this.TCustomer = TCustomer;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Set getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set orderItems) {
		this.orderItems = orderItems;
	}

}