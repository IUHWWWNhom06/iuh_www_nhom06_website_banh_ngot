package com.banhngot.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductCart_PK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cart;
	private Integer product;
	public Integer getCart() {
		return cart;
	}
	public void setCart(Integer cart) {
		this.cart = cart;
	}
	public Integer getProduct() {
		return product;
	}
	public void setProduct(Integer product) {
		this.product = product;
	}
	public ProductCart_PK(Integer cart, Integer product) {
		super();
		this.cart = cart;
		this.product = product;
	}
	public ProductCart_PK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCart_PK other = (ProductCart_PK) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		return true;
	}
	
	
}
