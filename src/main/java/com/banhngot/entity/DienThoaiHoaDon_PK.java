package com.banhngot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DienThoaiHoaDon_PK  implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int dienThoai;
	private int hoaDon;
	
	public int getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(int dienThoai) {
		this.dienThoai = dienThoai;
	}
	public int getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(int hoaDon) {
		this.hoaDon = hoaDon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dienThoai;
		result = prime * result + hoaDon;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DienThoaiHoaDon_PK other = (DienThoaiHoaDon_PK) obj;
		if (dienThoai != other.dienThoai)
			return false;
		if (hoaDon != other.hoaDon)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DienThoaiHoaDon_PK [dienThoai=" + dienThoai + ", hoaDon=" + hoaDon + "]";
	}
	public DienThoaiHoaDon_PK(int dienThoai, int hoaDon) {
		super();
		this.dienThoai = dienThoai;
		this.hoaDon = hoaDon;
	}
	public DienThoaiHoaDon_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
