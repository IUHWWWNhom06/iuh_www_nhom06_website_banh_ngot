package com.banhngot.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banhngot.dao.ThuongHieuDao;
import com.banhngot.entity.ThuongHieu;
@Repository
public class ThuongHieuDaoImpl implements ThuongHieuDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveThuongHieu(ThuongHieu thuongHieu) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thuongHieu);
	}

	@Override
	public void deleteThuongHieu(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		ThuongHieu thuongHieu=currentSession.get(ThuongHieu.class, id);
		currentSession.delete(thuongHieu);
	}

	@Override
	public ThuongHieu getThuongHieu(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		ThuongHieu thuongHieu=currentSession.get(ThuongHieu.class, id);
		return thuongHieu;
	}


	@Override
	public List<ThuongHieu> getListThuongHieu() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<ThuongHieu> thuongHieus=currentSession.createNativeQuery("select * from THUONGHIEU",ThuongHieu.class).getResultList();
		return thuongHieus;
	}

	@Override
	public ThuongHieu getTheoTen(String tenThuongHieu) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		ThuongHieu thuongHieu=currentSession.createNativeQuery("select * from thuonghieu where tenTH ='"+tenThuongHieu+"'",ThuongHieu.class).getSingleResult();
		return thuongHieu;
	}

}
