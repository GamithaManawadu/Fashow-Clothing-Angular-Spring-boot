package com.shoppinstore.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="orders")
public class Order {
	@Id
	int id;
	String orderid;
	int productid;
	int qty;
	double price;
	String order_on;
	int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrder_on() {
		return order_on;
	}
	public void setOrder_on(String order_on) {
		this.order_on = order_on;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
