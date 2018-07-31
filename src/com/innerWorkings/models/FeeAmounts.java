package com.innerWorkings.models;

public class FeeAmounts {
	private float baseMargin;
	
	private float extraMargin;
	
	private float salesTax;

	public FeeAmounts() {}

	public FeeAmounts(float baseMargin, float extraMargin, float salesTax) {
		super();
		this.baseMargin = baseMargin;
		this.extraMargin = extraMargin;
		this.salesTax = salesTax;
	}

	public float getBaseMargin() {
		return baseMargin;
	}

	public void setBaseMargin(float baseMargin) {
		this.baseMargin = baseMargin;
	}

	public float getExtraMargin() {
		return extraMargin;
	}

	public void setExtraMargin(float extraMargin) {
		this.extraMargin = extraMargin;
	}

	public float getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(float salesTax) {
		this.salesTax = salesTax;
	}

	@Override
	public String toString() {
		return "FeeAmounts [baseMargin=" + baseMargin + ", extraMargin=" + extraMargin + ", salesTax=" + salesTax + "]";
	}
	
	
	
	
}
