package model;

public class ProductDetails {
private int product_ID;
private String productname;
private float cost;
public ProductDetails(int product_ID, String productname, float cost) {
	this.product_ID = product_ID;
	this.productname = productname;
	this.cost = cost;
}
public int getProduct_ID() {
	return product_ID;
}
public void setProduct_ID(int product_ID) {
	this.product_ID = product_ID;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}

}
