package com.banhngot.entity;

public class ProductCart {
	private Product product = new Product();
	private int soLuong;
	public ProductCart(Product product, int soLuong) {
		super();
		this.product = product;
		this.soLuong = soLuong;
	}
	public ProductCart() {
		super();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "ProductGioHang [product=" + product + ", soLuong=" + soLuong + "]";
	}
	
}
