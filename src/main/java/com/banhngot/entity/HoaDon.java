package com.banhngot.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "HOADON")
public class HoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	private Date ngayLap;
	
	@Nationalized
	@Pattern(regexp = ".{1,}",message = "Họ và tên không hợp lệ")
	private String hoTenKhachHang;
	
	@Nationalized
	@Pattern(regexp = "[0-9]{9,11}",message = "Số điện thoại không hợp lệ")
	private String soDienThoaiGiaoHang;
	
	@Nationalized
	@Size(min = 1,message = "Địa chỉ không hợp lệ")
	private String diaChiGiaoHang;
	
	@Nationalized
	@Pattern(regexp = "^.{1,}@(gmail|yahoo|hotgmail).com",message = "Email không hợp lệ")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_ThanhToan")
	private PhuongThucThanhToan thanhToan;
	
	@ManyToOne
	@JoinColumn(name = "id_NguoiDung")
	private NguoiDung nguoiDung;
	
	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ChiTietHoaDon> danhSachChiTiet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getHoTenKhachHang() {
		return hoTenKhachHang;
	}

	public void setHoTenKhachHang(String hoTenKhachHang) {
		this.hoTenKhachHang = hoTenKhachHang;
	}

	public String getSoDienThoaiGiaoHang() {
		return soDienThoaiGiaoHang;
	}

	public void setSoDienThoaiGiaoHang(String soDienThoaiGiaoHang) {
		this.soDienThoaiGiaoHang = soDienThoaiGiaoHang;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhuongThucThanhToan getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(PhuongThucThanhToan thanhToan) {
		this.thanhToan = thanhToan;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public List<ChiTietHoaDon> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}

	public void setDanhSachChiTiet(List<ChiTietHoaDon> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}

	public HoaDon(Integer id, Date ngayLap, String hoTenKhachHang, String soDienThoaiGiaoHang, String diaChiGiaoHang,
			String email, PhuongThucThanhToan thanhToan, NguoiDung nguoiDung) {
		super();
		this.id = id;
		this.ngayLap = ngayLap;
		this.hoTenKhachHang = hoTenKhachHang;
		this.soDienThoaiGiaoHang = soDienThoaiGiaoHang;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.email = email;
		this.thanhToan = thanhToan;
		this.nguoiDung = nguoiDung;
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
