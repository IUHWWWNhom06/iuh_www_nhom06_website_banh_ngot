package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.OrderDetailDAO;
import com.banhngot.entity.OrderDetail;
import com.banhngot.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	
	@Override
	@Transactional
	public List<OrderDetail> getOrderDetail(int id) {
		return orderDetailDAO.getOrderDetail(id);
	}

	@Override
	@Transactional
	public List<OrderDetail> getAllOrderDetail() {
		return orderDetailDAO.getAllOrderDetail();
	}

	@Override
	@Transactional
	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.addOrderDetail(orderDetail);
	}

	@Override
	@Transactional
	public void addAllOrderDetail(int id_cake, int id_order, int quantity) {
		// TODO Auto-generated method stub
		orderDetailDAO.addAllOrderDetail(id_cake, id_order, quantity);
	}
	

	

	
	
}
