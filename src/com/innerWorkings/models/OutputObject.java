package com.innerWorkings.models;

import java.util.List;

public class OutputObject {
	
	private int id;
	
	private List<PaidItem> paidItems;
	
	String total;

	public OutputObject() {}
	
	public OutputObject(List<PaidItem> paidItems, String total, int id) {
		super();
		this.paidItems = paidItems;
		this.total = total;
		this.id = id;
	}


	public List<PaidItem> getPaidItems() {
		return paidItems;
	}

	public void setPaidItems(List<PaidItem> paidItems) {
		this.paidItems = paidItems;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OutputObject [id=" + id + ", paidItems=" + paidItems + ", total=" + total + "]";
	}


	
	
}
