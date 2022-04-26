package com.banhngot.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.DanhMucDao;
import com.banhngot.entity.DanhMuc;

@Repository
public class DanhMucDaoImpl implements DanhMucDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public DanhMuc getDanhMuc(String tenDanhMuc) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DanhMuc> theQuery = currentSession.createQuery("from DanhMuc where name=:x order by id", DanhMuc.class);
		theQuery.setParameter("x", tenDanhMuc);
		DanhMuc danhMuc = null;
		try {
			danhMuc = theQuery.getSingleResult();
		} catch (Exception e) {
			danhMuc = null;
		}

		return danhMuc;
	}
	@Transactional
	@Override
	public List<DanhMuc> getListDanhMuc() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DanhMuc> theQuery = currentSession.createQuery("from DanhMuc order by id", DanhMuc.class);
		List<DanhMuc> danhMucs = theQuery.getResultList();
		return danhMucs;
	}
	@Override
	public void saveDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(danhMuc);
	}
	@Override
	public void deleteDanhMuc(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		DanhMuc danhMuc=currentSession.get(DanhMuc.class, id);
		currentSession.delete(danhMuc);
	}
	@Override
	public DanhMuc getDanhMuc(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		DanhMuc danhMuc=currentSession.get(DanhMuc.class, id);
		return danhMuc;
	}
	@Override
	public List<DanhMuc> getListTheoTen(String tenDanhMuc) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DanhMuc> theQuery = currentSession.createNativeQuery("select * from DanhMuc where tenDanhMuc like N'%"+tenDanhMuc+"%'", DanhMuc.class);
		List<DanhMuc> danhMucs = theQuery.getResultList();
		return danhMucs;
	}
}
