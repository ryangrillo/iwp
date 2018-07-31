package com.innerWorkings.models;

import java.util.List;

public class Job {
	
	private int id;
	
	private List<Item> items;
	
	private boolean hasExtraMargin;

	public Job() {}

	public Job(List<Item> items, boolean hasExtraMargin, int id) {
		super();
		this.items = items;
		this.hasExtraMargin = hasExtraMargin;
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public boolean isHasExtraMargin() {
		return hasExtraMargin;
	}

	public void setHasExtraMargin(boolean hasExtraMargin) {
		this.hasExtraMargin = hasExtraMargin;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", items=" + items + ", hasExtraMargin=" + hasExtraMargin + "]";
	}


	
}
