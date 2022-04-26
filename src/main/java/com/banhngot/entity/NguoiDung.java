package com.banhngot.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "NGUOIDUNG")
public class NguoiDung implements Serializable{
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
	private String tenNguoiDung;
	@Pattern(regexp = "[0-9]{9,11}",message = "Số điện thoại không hợp lệ")
	private String soDienThoai;
	
	@Nationalized
	@Size(min = 1,message = "Không được bỏ trống")
	private String diaChi;
	
	@Nationalized
	@Pattern(regexp = "^.{1,}@(gmail|yahoo|hotgmail).com",message = "Email không hợp lệ")
	private String email;
	
	@Nationalized
	@Pattern(regexp = "[a-zA-Z-0-9]{8,}",message = "Tên đăng nhập có ít nhất 8 kí tự và không được chứa kí tự đặc biệt")
	private String tenDangNhap;
	
	@Nationalized 
//	@Pattern(regexp = "[a-zA-Z-0-9]{8,}",message = "Mật khẩu có ít nhất 8 kí tự và không được chứa kí tự đặc biệt")
	@Size(min = 1,message = "Không được bỏ trống")
	private String matKhau;
	
	@Nationalized 
	private String vaiTro;
	
	private Date ngayTao;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "NGUOIDUNGS_ROLES", 
	joinColumns = @JoinColumn(name = "nguoiDung_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnore
	private Collection<Role> roles;

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NguoiDung() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NguoiDung(Integer id, String tenNguoiDung, String soDienThoai, String diaChi, String email,
			String tenDangNhap, String matKhau, String vaiTro, Date ngayTao, Collection<Role> roles) {
		super();
		this.id = id;
		this.tenNguoiDung = tenNguoiDung;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.ngayTao = ngayTao;
		this.roles = roles;
	}

	public NguoiDung(Integer id, String tenNguoiDung, String soDienThoai, String diaChi, String email,
			String tenDangNhap, String matKhau, String vaiTro, Date ngayTao) {
		super();
		this.id = id;
		this.tenNguoiDung = tenNguoiDung;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.ngayTao = ngayTao;
	}

	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", tenNguoiDung=" + tenNguoiDung + ", soDienThoai=" + soDienThoai + ", diaChi="
				+ diaChi + ", email=" + email + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", vaiTro="
				+ vaiTro + ", ngayTao=" + ngayTao + ", roles=" + roles + "]";
	}

	

	
	
}
