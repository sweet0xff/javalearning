package org.xxx.model.entity.persist;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Orders implements Serializable{
	private Integer id;
	private String orderNumber;
	private Double orderPrice;
	private Customer customer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String orderNumber, Double orderPrice, Customer customer) {
		super();
		this.orderNumber = orderNumber;
		this.orderPrice = orderPrice;
		this.customer = customer;
	}

}
