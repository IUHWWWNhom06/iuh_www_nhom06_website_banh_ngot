package com.banhngot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "PHUONGTHUCTHANHTOAN")
public class PhuongThucThanhToan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Nationalized
	private String phuongThuc;
	

	public PhuongThucThanhToan(Integer id,String phuongThuc) {
		super();
		this.id = id;
		this.phuongThuc = phuongThuc;

	}

	public PhuongThucThanhToan() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getPhuongThuc() {
		return phuongThuc;
	}

	public void setPhuongThuc(String phuongThuc) {
		this.phuongThuc = phuongThuc;
	}



	@Override
	public String toString() {
		return "PhuongThucThanhToan [id=" + id + ", phuongThuc=" + phuongThuc
				+ "]";
	}
	
	
}
