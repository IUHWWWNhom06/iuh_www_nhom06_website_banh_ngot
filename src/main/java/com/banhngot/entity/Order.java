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
@Table(name = "ORDER")
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	private Date createAt;

	@Nationalized
	@Pattern(regexp = ".{1,}", message = "Họ và tên không hợp lệ")
	private String nameCustomer;

	@Nationalized
	@Pattern(regexp = "[0-9]{9,11}", message = "Số điện thoại không hợp lệ")
	private String phoneCustomer;

	@Nationalized
	@Size(min = 1, message = "Địa chỉ không hợp lệ")
	private String addressCustomer;

	@Nationalized
	@Pattern(regexp = "^.{1,}@(gmail|yahoo|hotgmail).com", message = "Email không hợp lệ")
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_Payment")
	private PaymentMethod payment;

	@ManyToOne
	@JoinColumn(name = "id_NguoiDung")
	private NguoiDung nguoiDung;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderDetail> orderDetails;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getPhoneCustomer() {
		return phoneCustomer;
	}

	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PaymentMethod getPayment() {
		return payment;
	}

	public void setPayment(PaymentMethod payment) {
		this.payment = payment;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order(Integer id, Date createAt, String nameCustomer, String phoneCustomer, String addressCustomer,
			String email, PaymentMethod payment, NguoiDung nguoiDung, List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.nameCustomer = nameCustomer;
		this.phoneCustomer = phoneCustomer;
		this.addressCustomer = addressCustomer;
		this.email = email;
		this.payment = payment;
		this.nguoiDung = nguoiDung;
		this.orderDetails = orderDetails;
	}

}
