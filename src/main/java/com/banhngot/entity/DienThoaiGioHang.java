package com.banhngot.entity;

public class DienThoaiGioHang {
	private Product dienThoai = new Product();
	private int soLuong;
	public DienThoaiGioHang(Product dienThoai, int soLuong) {
		super();
		this.dienThoai = dienThoai;
		this.soLuong = soLuong;
	}
	public DienThoaiGioHang() {
		super();
	}
	public Product getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(Product dienThoai) {
		this.dienThoai = dienThoai;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		return "DienThoaiGioHang [dienThoai=" + dienThoai + ", soLuong=" + soLuong + "]";
	}
	
}
