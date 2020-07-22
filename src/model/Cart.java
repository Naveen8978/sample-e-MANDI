package model;

public class Cart {

	private String itemname;
	private int quantity;
	public Cart(String itemname, int quantity) {
		this.itemname = itemname;
		this.quantity = quantity;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
