package com.banhngot.entity;

public class DienThoaiGioHang {
	private DienThoai dienThoai = new DienThoai();
	private int soLuong;
	public DienThoaiGioHang(DienThoai dienThoai, int soLuong) {
		super();
		this.dienThoai = dienThoai;
		this.soLuong = soLuong;
	}
	public DienThoaiGioHang() {
		super();
	}
	public DienThoai getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(DienThoai dienThoai) {
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
