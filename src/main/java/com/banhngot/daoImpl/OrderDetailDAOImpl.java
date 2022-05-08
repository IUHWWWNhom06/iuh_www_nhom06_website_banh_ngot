package com.banhngot.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.OrderDetailDAO;
import com.banhngot.entity.OrderDetail;
@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<OrderDetail> getOrderDetail(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<OrderDetail> ods = currentSession.createNativeQuery("select * from ORDERDETAIL where id_Order="+id+"" ,OrderDetail.class).getResultList();
		return ods;
	}
	@Transactional
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<OrderDetail> theQuery = currentSession.createQuery("from OrderDetail order by id_Order", OrderDetail.class);
		List<OrderDetail> ods = theQuery.getResultList();
		return ods;
	}
	@Transactional
	@Override
	public void addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(orderDetail);
	}
	
	@Transactional
	@Override
	public void addAllOrderDetail(int id_cake,int id_order,int quantity) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query query =currentSession.createNativeQuery("insert into Chitiethoadon values("+id_cake+","+id_order+","+quantity+" )");
		int ods=query.executeUpdate();
	}

	
	
}
