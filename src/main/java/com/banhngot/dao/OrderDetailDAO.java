package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.OrderDetail;

public interface OrderDetailDAO {
	public List<OrderDetail> getOrderDetail(int id);
	public List<OrderDetail> getAllOrderDetail();
	public void addOrderDetail(OrderDetail orderDetail);
	public void addAllOrderDetail(int id_cake,int id_order,int quantity);
}
