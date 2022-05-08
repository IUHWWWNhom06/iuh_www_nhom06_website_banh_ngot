package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.OrderDAO;
import com.banhngot.entity.Order;
import com.banhngot.entity.PaymentMethod;
import com.banhngot.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public void saveOrder(Order od) {
		orderDAO.saveOrder(od);
	}

	@Override
	@Transactional
	public Order getOrder(int id) {
		return orderDAO.getOrder(id);
	}

	@Override
	@Transactional
	public List<Order> getListOrder() {
		return orderDAO.getListOrder();
	}

	@Override
	@Transactional
	public List<PaymentMethod> getAllPaymentMethod() {
		return orderDAO.getAllPaymentMethod();
	}

	@Transactional
	@Override
	public PaymentMethod getMethod(int id) {
		// TODO Auto-generated method stub
		return orderDAO.getMethod(id);
	}

	@Override
	@Transactional
	public List<Order> getListOrderByPage(int page, List<Order> list) {
		// TODO Auto-generated method stub
		return orderDAO.getListOrderByPage(page, list);
	}

	@Transactional
	@Override
	public List<Order> findOrder(String search) {
		// TODO Auto-generated method stub
		return orderDAO.findOrder(search);
	}
	
	@Transactional
	@Override
	public List<Order> sortOrder(String name, String search) {
		// TODO Auto-generated method stub
		return orderDAO.sortOrder(name, search);
	}

	

}
