package com.banhngot.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ThongSoDAO;
import com.banhngot.entity.ThongSo;
@Repository
public class ThongSoDAOImpl implements ThongSoDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	@Override
	public void saveThongSo(ThongSo ts) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(ts);
	}
	@Transactional
	@Override
	public void deleteThongSo(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		ThongSo ts=currentSession.get(ThongSo.class, id);
		currentSession.delete(ts);
	}
	@Transactional
	@Override
	public ThongSo getThongSo(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		ThongSo ts=currentSession.get(ThongSo.class, id);
		return ts;
	}
	@Transactional
	@Override
	public List<ThongSo> getListThongSo() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ThongSo> theQuery = currentSession.createQuery("from ThongSo", ThongSo.class);
		List<ThongSo> tss = theQuery.getResultList();
		return tss;
	}
}
