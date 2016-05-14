package org.xxx.model.entity.persist;

/**
 * CategoryItem entity. @author MyEclipse Persistence Tools
 */

public class CategoryItem implements java.io.Serializable {

	// Fields

	private Long id;
	private TItem TItem;
	private TCategory TCategory;
	private String remark;

	// Constructors

	/** default constructor */
	public CategoryItem() {
	}

	/** full constructor */
	public CategoryItem(TItem TItem, TCategory TCategory, String remark) {
		this.TItem = TItem;
		this.TCategory = TCategory;
		this.remark = remark;
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

	public TCategory getTCategory() {
		return this.TCategory;
	}

	public void setTCategory(TCategory TCategory) {
		this.TCategory = TCategory;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}