package com.banhngot.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.TypeProductDao;
import com.banhngot.entity.TypeProduct;

@Repository
public class TypeProductDaoImpl implements TypeProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public TypeProduct getDanhMuc(String tenDanhMuc) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<TypeProduct> theQuery = currentSession.createQuery("from TypeProduct where name=:x order by id", TypeProduct.class);
		theQuery.setParameter("x", tenDanhMuc);
		TypeProduct danhMuc = null;
		try {
			danhMuc = theQuery.getSingleResult();
		} catch (Exception e) {
			danhMuc = null;
		}

		return danhMuc;
	}
	@Transactional
	@Override
	public List<TypeProduct> getListDanhMuc() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<TypeProduct> theQuery = currentSession.createQuery("from TypeProduct order by id", TypeProduct.class);
		List<TypeProduct> danhMucs = theQuery.getResultList();
		return danhMucs;
	}
	@Override
	public void saveDanhMuc(TypeProduct danhMuc) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(danhMuc);
	}
	@Override
	public void deleteDanhMuc(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		TypeProduct danhMuc=currentSession.get(TypeProduct.class, id);
		currentSession.delete(danhMuc);
	}
	@Override
	public TypeProduct getDanhMuc(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		TypeProduct danhMuc=currentSession.get(TypeProduct.class, id);
		return danhMuc;
	}
	@Override
	public List<TypeProduct> getListTheoTen(String tenDanhMuc) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<TypeProduct> theQuery = currentSession.createNativeQuery("select * from TypeProduct where tenDanhMuc like N'%"+tenDanhMuc+"%'", TypeProduct.class);
		List<TypeProduct> danhMucs = theQuery.getResultList();
		return danhMucs;
	}
}
