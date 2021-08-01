package com.stock;

public class Stocks {

	String companyName;
	long totalStocks;
	long totalPrice;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getTotalStocks() {
		return totalStocks;
	}

	public void setTotalStocks(long totalStocks) {
		this.totalStocks = totalStocks;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Stocks [companyName=" + companyName + ", totalStocks=" + totalStocks + ", totalPrice=" + totalPrice
				+ "]";
	}

}
