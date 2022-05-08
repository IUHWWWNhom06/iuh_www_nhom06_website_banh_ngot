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
@Table(name = "PAYMENTMETHOD")
public class PaymentMethod implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Nationalized
	private String method;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public PaymentMethod(Integer id, String method) {
		super();
		this.id = id;
		this.method = method;
	}

	@Override
	public String toString() {
		return "PaymentMethod [id=" + id + ", method=" + method + "]";
	}
	
	
	
	
	
}
