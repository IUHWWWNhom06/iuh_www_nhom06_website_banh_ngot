package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.Order;
import com.banhngot.entity.PaymentMethod;

public interface OrderService {
	public void saveOrder(Order order);
	public Order getOrder(int id);
	public List<Order> getListOrder();
	public List<PaymentMethod> getAllPaymentMethod();
	public PaymentMethod getMethod(int id);
	public List<Order> getListOrderByPage(int page, List<Order> list);
	public List<Order> findOrder(String search);
	public List<Order> sortOrder(String name,String search);
}
