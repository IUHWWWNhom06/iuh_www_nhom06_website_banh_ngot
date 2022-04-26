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
@Table(name = "THONGSO")
public class ThongSo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Nationalized
	private String manHinh;
	
	@Nationalized
	private String boNho;
	
	@Nationalized
	private String camera;
	
	@Nationalized
	private String heDieuHanh;
	@Nationalized
	private String pin;

	@Nationalized
	private String ram;
	
	@Nationalized
	private String sim;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBoNho() {
		return boNho;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public void setBoNho(String boNho) {
		this.boNho = boNho;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getHeDieuHanh() {
		return heDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		this.heDieuHanh = heDieuHanh;
	}


	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	
	public ThongSo(Integer id, String manHinh, String boNho, String camera, String heDieuHanh, String pin, String ram,
			String sim) {
		super();
		this.id = id;
		this.manHinh = manHinh;
		this.boNho = boNho;
		this.camera = camera;
		this.heDieuHanh = heDieuHanh;
		this.pin = pin;
		this.ram = ram;
		this.sim = sim;
	}

	public ThongSo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
