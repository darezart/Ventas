package com.example.demoVentas.infrastructure.model;

import java.io.Serializable;


public class ProductModel implements Serializable{
	
	private static final long serialVersionUID = 4L;
	
	private Integer id;
	private String name;
	private int price;
	private int stock;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
