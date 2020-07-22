package model;

import java.sql.Date;
import java.time.LocalDate;

public class OrderProduct {
private long buyerid;
private String itemname;
private long quantity;
private String street;
private String city;
private String State;
private long zip;
//private LocalDate shipdate;
private String paymentmethod;
private float bill;

//Constructor with parameters
public OrderProduct(long buyerid, String itemname, long quantity, String street, String city, String state, long zip,
		String paymentmethod, float bill) {
	
	this.buyerid = buyerid;
	this.itemname = itemname;
	this.quantity = quantity;
	this.street = street;
	this.city = city;
	State = state;
	this.zip = zip;
	this.paymentmethod = paymentmethod;
	this.bill = bill;
}

public long getBuyerid() {
	return buyerid;
}

public void setBuyerid(long buyerid) {
	this.buyerid = buyerid;
}

public String getItemname() {
	return itemname;
}

public void setItemname(String itemname) {
	this.itemname = itemname;
}

public long getQuantity() {
	return quantity;
}

public void setQuantity(long quantity) {
	this.quantity = quantity;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return State;
}

public void setState(String state) {
	State = state;
}

public long getZip() {
	return zip;
}

public void setZip(long zip) {
	this.zip = zip;
}

public String getPaymentmethod() {
	return paymentmethod;
}

public void setPaymentmethod(String paymentmethod) {
	this.paymentmethod = paymentmethod;
}

public float getBill() {
	return bill;
}

public void setBill(float bill) {
	this.bill = bill;
}



}
