package com.banhngot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "BINHLUAN")
public class BinhLuan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Nationalized
	private String tenBinhLuan;
	
	@Nationalized
	private String email;
	
	@Nationalized
	private String noiDung;
	
	private LocalDateTime ngay;
	
	@ManyToOne
	@JoinColumn(name = "id_DienThoai")
	private DienThoai dienThoai;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenBinhLuan() {
		return tenBinhLuan;
	}

	public void setTenBinhLuan(String tenBinhLuan) {
		this.tenBinhLuan = tenBinhLuan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public LocalDateTime getNgay() {
		return ngay;
	}

	public void setNgay(LocalDateTime ngay) {
		this.ngay = ngay;
	}

	public DienThoai getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(DienThoai dienThoai) {
		this.dienThoai = dienThoai;
	}

	public BinhLuan(Integer id, String tenBinhLuan, String email, String noiDung, LocalDateTime ngay, DienThoai dienThoai) {
		super();
		this.id = id;
		this.tenBinhLuan = tenBinhLuan;
		this.email = email;
		this.noiDung = noiDung;
		this.ngay = ngay;
		this.dienThoai = dienThoai;
	}

	public BinhLuan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinhLuan(Integer id, String tenBinhLuan, String email, String noiDung, LocalDateTime ngay) {
		super();
		this.id = id;
		this.tenBinhLuan = tenBinhLuan;
		this.email = email;
		this.noiDung = noiDung;
		this.ngay = ngay;
	}

	@Override
	public String toString() {
		return "BinhLuan [id=" + id + ", tenBinhLuan=" + tenBinhLuan + ", email=" + email + ", noiDung=" + noiDung
				+ ", ngay=" + ngay + ", dienThoai=" + dienThoai + "]";
	}
	
}
