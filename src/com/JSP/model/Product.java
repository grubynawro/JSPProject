package com.JSP.model;

public class Product {
	
	private int productId;
	private float price;
	private String producer;
	private String model;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
        return "Product [productId=" + productId + ", price=" + price
                + ", producer=" + producer + ", model=" + model + "]";
	}
	
}
