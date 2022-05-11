package com.banhngot.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductOrder_PK  implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int product;
	private int order;
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public ProductOrder_PK(int product, int order) {
		super();
		this.product = product;
		this.order = order;
	}
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOrder_PK other = (ProductOrder_PK) obj;
		return order == other.order && product == other.product;
	}
	
	


	
}
