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
	private String name;
	
	
	private float price;

	@NotNull(message = "Không được bỏ trống")
	private float discount;

	@NotNull(message = "Không được bỏ trống")
	private int quantity;
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	private String description;
	
	@Nationalized
	@Size(min = 1, message = "Không được bỏ trống")
	private String ingredient;
	
	@NotNull(message = "Không được bỏ trống")
	private int expiry;
	
	@Nationalized
	private String anhURL;
	
	@ManyToOne
	@JoinColumn(name = "id_DanhMuc")
	private TypeProduct danhMuc;
	
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderDetail> danhSachSanPhamHoaDon;

	public Product() {
		super();
	}

	public Product(Integer id, String name, float price, float discount, int quantity, String description,
			String ingredient, int expiry, String anhURL, TypeProduct danhMuc,
			List<OrderDetail> danhSachSanPhamHoaDon) {
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

	public List<OrderDetail> getDanhSachSanPhamHoaDon() {
		return danhSachSanPhamHoaDon;
	}

	public void setDanhSachSanPhamHoaDon(List<OrderDetail> danhSachSanPhamHoaDon) {
		this.danhSachSanPhamHoaDon = danhSachSanPhamHoaDon;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
