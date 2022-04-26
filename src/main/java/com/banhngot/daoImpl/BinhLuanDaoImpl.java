package com.banhngot.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.BinhLuanDao;
import com.banhngot.entity.BinhLuan;

@Repository
public class BinhLuanDaoImpl implements BinhLuanDao{
	
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public List<BinhLuan> getListBinhLuan() {
		Session session = factory.getCurrentSession();
		Query<BinhLuan> theQuery = session.createQuery("from BinhLuan", BinhLuan.class);
		List<BinhLuan> bls = theQuery.getResultList();
		return bls;
	}
	@Transactional
	@Override
	public void themBinhLuan(BinhLuan binhLuan) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(binhLuan);
	}
	@Transactional
	@Override
	public List<BinhLuan> getListBinhLuanByIdDienThoai(int dtId) {
		Session session = factory.getCurrentSession();
		String sql = "select bl.* from DIENTHOAI dt join BINHLUAN bl on dt.id = bl.id_DienThoai where dt.id ="+dtId;
		List<BinhLuan> list = session.createNativeQuery(sql, BinhLuan.class).getResultList();
		return list;
	}
	@Override
	public void xoaBinhLuan(int id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		BinhLuan binhLuan=session.get(BinhLuan.class, id);
		session.delete(binhLuan);
	}

}
