package com.oracle.csc342.team3.problems;

import java.math.BigDecimal;
	
public class Product {
	
	BigDecimal productID;
	BigDecimal productLineID;
	String productDescription;
	String productFinish;
	BigDecimal productStandardPrice;
	
	//constructors
	public Product(){}
	public Product(BigDecimal productID) {this.productID = productID;}
	
	//setters / getters
	public BigDecimal getProductID() {return productID;}
	public void setProductID(BigDecimal productID) {this.productID = productID;}
	
	public BigDecimal getLineID() {return productLineID;}
	public void setLineID(BigDecimal lineID) {this.productLineID = lineID;}
	
	public void setProductDesc(String desc){this.productDescription = desc;}
	public String getProductDesc(){return this.productDescription;}
	
	public void setProductFinish(String finish){this.productFinish = finish;}
	public String getProductFinish(){return this.productFinish;}
	
	public void setProductStandardPrice(BigDecimal standardPrice){this.productStandardPrice = standardPrice;}
	public BigDecimal getProductStandardPrice(){return this.productStandardPrice;}

	
	public String toString() {
		return ("Product ID: " + getProductID() + " Line ID: " + getLineID() + " Product Description: " + 
				getProductDesc() + " Product Finish: " + " " + getProductFinish() + " Product Standard Price: " 
				+ getProductStandardPrice());           
	}

	
}
