package com.banhngot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "DANHMUC")
public class DanhMuc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Nationalized
	@Pattern(regexp = ".{1,}",message = "Không được bỏ trống")
	private String tenDanhMuc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public DanhMuc(Integer id, String tenDanhMuc) {
		super();
		this.id = id;
		this.tenDanhMuc = tenDanhMuc;
	}

	public DanhMuc(String tenDanhMuc) {
		super();
		this.tenDanhMuc = tenDanhMuc;
	}

	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
