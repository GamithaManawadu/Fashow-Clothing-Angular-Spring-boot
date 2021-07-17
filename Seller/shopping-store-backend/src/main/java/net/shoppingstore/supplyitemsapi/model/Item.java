package net.shoppingstore.supplyitemsapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_category")
	private String itemCategory;

	@Column(name = "item_cost")
	private double itemCost;

	@Column(name = "item_selling_price")
	private double itemSellingPrice;

	@Column(name = "item_quantity")
	private int itemQuantity;

	public Item() {

	}



	public Item(String itemName, String itemCategory, double itemCost, double itemSellingPrice,
				int itemQuantity) {
		super();
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemCost = itemCost;
		this.itemSellingPrice = itemSellingPrice;
		this.itemQuantity = itemQuantity;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	public double getItemSellingPrice() {
		return itemSellingPrice;
	}

	public void setItemSellingPrice(double itemSellingPrice) {
		this.itemSellingPrice = itemSellingPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



}