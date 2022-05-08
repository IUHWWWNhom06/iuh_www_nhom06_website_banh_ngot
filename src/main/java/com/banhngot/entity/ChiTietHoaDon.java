package com.banhngot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETHOADON")
@IdClass(DienThoaiHoaDon_PK.class)
public class ChiTietHoaDon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_DienThoai")
	private Product dienThoai;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_HoaDon")
	private HoaDon hoaDon;
	
	private int soLuong;
	
	
	
	public ChiTietHoaDon(Product dienThoai, HoaDon hoaDon, int soLuong) {
		super();
		this.dienThoai = dienThoai;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
	}
	public ChiTietHoaDon(Product dienThoai, int soLuong) {
		super();
		this.dienThoai = dienThoai;
		this.soLuong = soLuong;
	}
	public ChiTietHoaDon() {
		super();
	}
	public Product getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(Product dienThoai) {
		this.dienThoai = dienThoai;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [dienThoai=" + dienThoai + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + "]";
	}
}
