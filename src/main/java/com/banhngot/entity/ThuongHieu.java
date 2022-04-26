package com.banhngot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "THUONGHIEU")
public class ThuongHieu implements Serializable{
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
	private String tenTH;
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	@Pattern(regexp = "[a-zA-Z]{1,}",message = "Nơi xuất xứ không chứa số và kí tự đặc biệt")
	private String xuatXu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenTH() {
		return tenTH;
	}

	public void setTenTH(String tenTH) {
		this.tenTH = tenTH;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public ThuongHieu(Integer id, String tenTH, String xuatXu) {
		super();
		this.id = id;
		this.tenTH = tenTH;
		this.xuatXu = xuatXu;
	}

	public ThuongHieu() {
		super();
	}

	@Override
	public String toString() {
		return "ThuongHieu [id=" + id + ", tenTH=" + tenTH + ", xuatXu=" + xuatXu + "]";
	}
	
	
}
