package com.banhngot.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DienThoaiGioHang_PK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer gioHang;
	private Integer dienThoai;
	public Integer getGioHang() {
		return gioHang;
	}
	public void setGioHang(Integer gioHang) {
		this.gioHang = gioHang;
	}
	public Integer getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(Integer dienThoai) {
		this.dienThoai = dienThoai;
	}
	public DienThoaiGioHang_PK(Integer gioHang, Integer dienThoai) {
		super();
		this.gioHang = gioHang;
		this.dienThoai = dienThoai;
	}
	public DienThoaiGioHang_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dienThoai == null) ? 0 : dienThoai.hashCode());
		result = prime * result + ((gioHang == null) ? 0 : gioHang.hashCode());
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
		DienThoaiGioHang_PK other = (DienThoaiGioHang_PK) obj;
		if (dienThoai == null) {
			if (other.dienThoai != null)
				return false;
		} else if (!dienThoai.equals(other.dienThoai))
			return false;
		if (gioHang == null) {
			if (other.gioHang != null)
				return false;
		} else if (!gioHang.equals(other.gioHang))
			return false;
		return true;
	}
	
	
}
