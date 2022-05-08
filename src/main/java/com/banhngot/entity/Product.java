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
@Table(name = "Product")
public class Product implements Serializable{
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
	private String name;
	
	
	@Min(value = 1, message = "Phải lớn hơn 0")
	private float price;

	@NotNull(message = "Không được bỏ trống")
	@Min(value = 0, message = "Phải lớn hơn 0")	
	private float discount;

	@NotNull(message = "Không được bỏ trống")
	@Min(value = 1, message = "Phải lớn hơn 0")	
	private int quantity;
	
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	private String description;
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	private String ingredient;
	
	@NotNull(message = "Không được bỏ trống")
	@Min(value = 1, message = "Phải lớn hơn 0")	
	private int expiry;
	
	@Nationalized
	private String anhURL;
	
	@ManyToOne
	@JoinColumn(name = "id_DanhMuc")
	private TypeProduct danhMuc;
	
	
	@OneToMany(mappedBy = "dienThoai", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ChiTietHoaDon> danhSachSanPhamHoaDon;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "HINHANH", joinColumns = @JoinColumn(name = "id"))
	@JsonIgnore
	private List<String> hinhAnh;

	public Product() {
		super();
	}

	public Product(Integer id, String name, float price, float discount, int quantity, String description,
			String ingredient, int expiry, String anhURL, TypeProduct danhMuc,
			List<ChiTietHoaDon> danhSachSanPhamHoaDon, List<String> hinhAnh) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.description = description;
		this.ingredient = ingredient;
		this.expiry = expiry;
		this.anhURL = anhURL;
		this.danhMuc = danhMuc;
		this.danhSachSanPhamHoaDon = danhSachSanPhamHoaDon;
		this.hinhAnh = hinhAnh;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public int getExpiry() {
		return expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	public String getAnhURL() {
		return anhURL;
	}

	public void setAnhURL(String anhURL) {
		this.anhURL = anhURL;
	}

	public TypeProduct getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(TypeProduct danhMuc) {
		this.danhMuc = danhMuc;
	}

	public List<ChiTietHoaDon> getDanhSachSanPhamHoaDon() {
		return danhSachSanPhamHoaDon;
	}

	public void setDanhSachSanPhamHoaDon(List<ChiTietHoaDon> danhSachSanPhamHoaDon) {
		this.danhSachSanPhamHoaDon = danhSachSanPhamHoaDon;
	}

	public List<String> getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(List<String> hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
