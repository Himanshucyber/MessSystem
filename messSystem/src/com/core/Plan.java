package com.core;

public enum Plan {
	 MONTHLY(3000),QUARTERLY(11700),HALFYEAR(17500),YEAR(32000);
    double price;

	private Plan(double price) {
		this.price = price;
	}
	 public double getPrice() {
	        return price;
	    }
	
}
