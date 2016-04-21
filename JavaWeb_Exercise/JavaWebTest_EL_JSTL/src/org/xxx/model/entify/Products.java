package org.xxx.model.entify;

public class Products {
	private String name;
	private int productsnumber;
	private double price;
	public Products(String name, int productsnumber, double price) {
		super();
		this.name = name;
		this.productsnumber = productsnumber;
		this.price = price;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProductsnumber() {
		return productsnumber;
	}
	public void setProductsnumber(int productsnumber) {
		this.productsnumber = productsnumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
