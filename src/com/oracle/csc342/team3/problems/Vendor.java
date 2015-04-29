package com.oracle.csc342.team3.problems;

import java.math.BigDecimal;
	
public class Vendor {
	
	BigDecimal vendorID;
	String vendorName;
	Address address;
	String faxNum;
	String phoneNum;
	String vendorContact;
	BigDecimal taxID;
	
	//constructors
	public Vendor(){}
	public Vendor(BigDecimal vid) {this.vendorID = vid;}
	
	//setters / getters
	public BigDecimal getVendorID() {return vendorID;}
	public void setVendorID(BigDecimal pid) {this.vendorID = pid;}
	
	public String getVendorName() {return vendorName;}
	public void setVendorName(String vn) {this.vendorName = vn;}
	
	public void setAddress(Address a){this.address = a;}
	public Address getAddress(){return this.address;}
	
	public void setFaxNum(String fn){this.faxNum = fn;}
	public String getFaxNum(){return this.faxNum;}
	
	public void setPhoneNum(String pn){this.phoneNum = pn;}
	public String getPhoneNum(){return this.phoneNum;}
	
	public void setVendorContact(String vc){this.vendorContact = vc;}
	public String getVendorContact(){return this.vendorContact;}
	
	public void setTaxID(BigDecimal pn){this.taxID = pn;}
	public BigDecimal getTaxID(){return this.taxID;}

	
	public String toString() {
		return ("Vendor ID: " + getVendorID() + " Vendor Name: " + getVendorName() + " Address: " + getAddress() +
				" Fax Number: " + getFaxNum() + " Phone Number: " + getPhoneNum() + " Vendor Contact: "
				+ getVendorContact() + " Tax ID: " + getTaxID());
	}

	
}
