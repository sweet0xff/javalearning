package org.xxx.model.entity.persist;

/**
 * OrderItem entity. @author MyEclipse Persistence Tools
 */

public class OrderItem implements java.io.Serializable {

	// Fields

	private Long id;
	private TItem TItem;
	private TOrder TOrder;
	private Integer num;

	// Constructors

	/** default constructor */
	public OrderItem() {
	}

	/** full constructor */
	public OrderItem(TItem TItem, TOrder TOrder, Integer num) {
		this.TItem = TItem;
		this.TOrder = TOrder;
		this.num = num;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TItem getTItem() {
		return this.TItem;
	}

	public void setTItem(TItem TItem) {
		this.TItem = TItem;
	}

	public TOrder getTOrder() {
		return this.TOrder;
	}

	public void setTOrder(TOrder TOrder) {
		this.TOrder = TOrder;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}