package com.banhngot.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ChiTietHoaDonDAO;
import com.banhngot.entity.ChiTietHoaDon;
@Repository
public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<ChiTietHoaDon> getChiTietHoaDon(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<ChiTietHoaDon> cthds = currentSession.createNativeQuery("select * from CHITIETHOADON where id_HoaDon="+id+"" ,ChiTietHoaDon.class).getResultList();
		return cthds;
	}
	@Transactional
	@Override
	public List<ChiTietHoaDon> getAllChiTietHoaDon() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ChiTietHoaDon> theQuery = currentSession.createQuery("from ChiTietHoaDon order by id_hoaDon", ChiTietHoaDon.class);
		List<ChiTietHoaDon> cthds = theQuery.getResultList();
		return cthds;
	}
	@Transactional
	@Override
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(chiTietHoaDon);
	}
	
	@Transactional
	@Override
	public void addChiTietHoaDon(int id_dienthoai,int id_hoadon,int soLuong) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query query =currentSession.createNativeQuery("insert into Chitiethoadon values("+id_dienthoai+","+id_hoadon+","+soLuong+" )");
		int cthd=query.executeUpdate();
	}

	
	
}
