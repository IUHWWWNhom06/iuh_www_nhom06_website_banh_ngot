package com.banhngot.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.OrderDAO;
import com.banhngot.entity.Order;
import com.banhngot.entity.PaymentMethod;

@Repository
public class OrderDAOIplm implements OrderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void saveOrder(Order od) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(od);
	}

	@Transactional
	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Order od = currentSession.get(Order.class, id);
		return od;
	}

	@Transactional
	@Override
	public List<Order> getListOrder() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Order> theQuery = currentSession.createQuery("from Order order by id", Order.class);
		List<Order> ods = theQuery.getResultList();
		return ods;
	}

	@Transactional
	@Override
	public List<PaymentMethod> getAllPaymentMethod() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<PaymentMethod> list = currentSession
				.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
		return list;
	}

	@Override
	public PaymentMethod getMethod(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		PaymentMethod pm =currentSession.get(PaymentMethod.class, id);
		return pm;
	}

	@Override
	public List<Order> getListOrderByPage(int page, List<Order> list) {
		// TODO Auto-generated method stub
		int position = (page-1)*9;
		int end = position + 9;
		
		List<Order> orders = new ArrayList<Order>();
		
		while(position < end && list.size() > position) {
			orders.add(list.get(position));
			position++;
		}
		
		return orders;
	}

	@Override
	public List<Order> findOrder(String search) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<Order> hoaDons=currentSession.createNativeQuery("select * from ORDER o join ORDERDETAIL od on o.id=od.id_Order\r\n"
				+ "where o.nameCustomer like N'%"+search+"%' or phoneCustomer like N'%"+search+"%' or email like N'%"+search+"%'",Order.class).getResultList();
		return hoaDons;
	}

	@Override
	public List<Order> sortOrder(String name,String search) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();		
		String sql=null;
		List<Order> ods=new ArrayList<Order>();
		switch (name) {
		case "ngay_desc":
			sql="select * from ORDER where nameCustomer like N'%"+search+"%' or phoneCustomer like N'%"+search+"%' order by createAt desc";
			ods=currentSession.createNativeQuery(sql,Order.class).getResultList();
			break;
		case "ngay_asc":
			sql="select * from ORDER where nameCustomer like N'%"+search+"%' or phoneCustomer like N'%"+search+"%'  order by createAt asc";
			ods=currentSession.createNativeQuery(sql,Order.class).getResultList();
			break;
		default:
			sql="select * from ORDER where nameCustomer like N'%"+search+"%' or phoneCustomer like N'%"+search+"%' ";
			ods=currentSession.createNativeQuery(sql,Order.class).getResultList();
			break;
		}
		
		return ods;
	}

}
