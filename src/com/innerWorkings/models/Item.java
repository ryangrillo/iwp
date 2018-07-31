package com.innerWorkings.models;

public class Item {
	
	private String name;
	
	private double price;
	
	private boolean isExempt;

	public Item() {}

	public Item(String name, double price, boolean isExempt) {
		super();
		this.name = name;
		this.price = price;
		this.isExempt = isExempt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isExempt() {
		return isExempt;
	}

	public void setIsExempt(boolean isExempt) {
		this.isExempt = isExempt;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", isExempt=" + isExempt + "]";
	}
	
	
	
	
	
}
