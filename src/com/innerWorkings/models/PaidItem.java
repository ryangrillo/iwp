package com.innerWorkings.models;

public class PaidItem {
	private String name;
	
	private String finalPriceWithSalesTax;

	public PaidItem() {}

	public PaidItem(String name, String finalPriceWithSalesTax) {
		super();
		this.name = name;
		this.finalPriceWithSalesTax = finalPriceWithSalesTax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFinalPriceWithSalesTax() {
		return finalPriceWithSalesTax;
	}

	public void setFinalPriceWithSalesTax(String finalPriceWithSalesTax) {
		this.finalPriceWithSalesTax = finalPriceWithSalesTax;
	}

	@Override
	public String toString() {
		return "PaidItem [name=" + name + ", finalPriceWithSalesTax=" + finalPriceWithSalesTax + "]";
	}
	
	

}