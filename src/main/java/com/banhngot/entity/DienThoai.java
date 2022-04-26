package com.banhngot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Nationalized;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DIENTHOAI")
public class DienThoai implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	@Pattern(regexp = "[A-Za-z0-9 \\p{L}+]{1,}",message = "Không chứa kí tự đặc biệt")
	private String tenDT;
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	@Pattern(regexp = "[A-Za-z0-9 \\p{L}+]{1,}",message = "Không chứa kí tự đặc biệt")
	private String baoHanh;
	
	@Min(value = 1, message = "Phải lớn hơn 0")
	private float giaDT;

	@NotNull(message = "Không được bỏ trống")
	@Min(value = 0, message = "Phải lớn hơn 0")	
	private float giamGia;

	@NotNull(message = "Không được bỏ trống")
	@Min(value = 1, message = "Phải lớn hơn 0")	
	private int soLuongTon;
	@NotNull(message = "Không được bỏ trống")
	@Min(value = 0, message = "Phải lớn hơn 0")	
	private float thue;

	@NotNull(message = "Không được bỏ trống")
	@Min(value = 1, message = "Phải lớn hơn 0")	
	private float trongLuong;
	
	@Nationalized
	@Pattern(regexp = ".{1,}",message = "Không được bỏ trống")
	private String kichThuoc;
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	@Pattern(regexp = "[A-Za-z0-9 \\p{L}+]{1,}",message = "Không chứa kí tự đặc biệt")
	private String mauSac;
	
	@Nationalized
	private String anhURL;
	
	@ManyToOne
	@JoinColumn(name = "id_DanhMuc")
	private DanhMuc danhMuc;
	
	@ManyToOne
	@JoinColumn(name = "id_ThuongHieu")
	private ThuongHieu thuongHieu;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ThongSo")
	private ThongSo thongSo;
	
	
	@OneToMany(mappedBy = "dienThoai", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ChiTietHoaDon> danhSachSanPhamHoaDon;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "HINHANH", joinColumns = @JoinColumn(name = "id"))
	@JsonIgnore
	private List<String> hinhAnh;

	public List<String> getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(List<String> hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public String getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}
	public float getGiaDT() {
		return giaDT;
	}

	public void setGiaDT(float giaDT) {
		this.giaDT = giaDT;
	}

	public float getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}

	public float getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(float trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getAnhURL() {
		return anhURL;
	}

	public void setAnhURL(String anhURL) {
		this.anhURL = anhURL;
	}

	public ThuongHieu getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(ThuongHieu thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public ThongSo getThongSo() {
		return thongSo;
	}

	public void setThongSo(ThongSo thongSo) {
		this.thongSo = thongSo;
	}

	

	public List<ChiTietHoaDon> getDanhSachSanPhamHoaDon() {
		return danhSachSanPhamHoaDon;
	}

	public void setDanhSachSanPhamHoaDon(List<ChiTietHoaDon> danhSachSanPhamHoaDon) {
		this.danhSachSanPhamHoaDon = danhSachSanPhamHoaDon;
	}


	
	public DienThoai(Integer id, String tenDT, String baoHanh, float giaDT, float giamGia, int soLuongTon, float thue,
			float trongLuong, String kichThuoc, String mauSac, String anhURL) {
		super();
		this.id = id;
		this.tenDT = tenDT;
		this.baoHanh = baoHanh;
		this.giaDT = giaDT;
		this.giamGia = giamGia;
		this.soLuongTon = soLuongTon;
		this.thue = thue;
		this.trongLuong = trongLuong;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.anhURL = anhURL;
	}

	public DienThoai(Integer id, String tenDT, String baoHanh, float giaDT, float giamGia, int soLuongTon, float thue,
			float trongLuong, String kichThuoc, String mauSac, String anhURL, DanhMuc danhMuc, ThuongHieu thuongHieu,
			ThongSo thongSo) {
		super();
		this.id = id;
		this.tenDT = tenDT;
		this.baoHanh = baoHanh;
		this.giaDT = giaDT;
		this.giamGia = giamGia;
		this.soLuongTon = soLuongTon;
		this.thue = thue;
		this.trongLuong = trongLuong;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.anhURL = anhURL;
		this.danhMuc = danhMuc;
		this.thuongHieu = thuongHieu;
		this.thongSo = thongSo;
	}

	public DienThoai(Integer id, String tenDT, String baoHanh, float giaDT, float giamGia, int soLuongTon, float thue,
			float trongLuong, String kichThuoc, String mauSac, String anhURL, DanhMuc danhMuc, ThuongHieu thuongHieu,
			ThongSo thongSo,  List<ChiTietHoaDon> danhSachSanPhamHoaDon) {
		super();
		this.id = id;
		this.tenDT = tenDT;
		this.baoHanh = baoHanh;
		this.giaDT = giaDT;
		this.giamGia = giamGia;
		this.soLuongTon = soLuongTon;
		this.thue = thue;
		this.trongLuong = trongLuong;
		this.kichThuoc = kichThuoc;
		this.mauSac = mauSac;
		this.anhURL = anhURL;
		this.danhMuc = danhMuc;
		this.thuongHieu = thuongHieu;
		this.thongSo = thongSo;
		this.danhSachSanPhamHoaDon = danhSachSanPhamHoaDon;
	}

	public DienThoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	
	
}
