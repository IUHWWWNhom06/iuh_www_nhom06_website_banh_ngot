package com.banhngot.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.HoaDonDAO;
import com.banhngot.entity.HoaDon;
import com.banhngot.entity.PhuongThucThanhToan;

@Repository
public class HoaDonDAOImpl implements HoaDonDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void saveHoaDon(HoaDon hd) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(hd);
	}

	@Transactional
	@Override
	public HoaDon getHoaDon(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		HoaDon hd = currentSession.get(HoaDon.class, id);
		return hd;
	}

	@Transactional
	@Override
	public List<HoaDon> getListHoaDon() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<HoaDon> theQuery = currentSession.createQuery("from HoaDon order by id", HoaDon.class);
		List<HoaDon> hds = theQuery.getResultList();
		return hds;
	}

	@Transactional
	@Override
	public List<PhuongThucThanhToan> layTatCaPhuongThucThanhToan() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<PhuongThucThanhToan> list = currentSession
				.createQuery("from PhuongThucThanhToan", PhuongThucThanhToan.class).getResultList();
		return list;
	}

	@Override
	public PhuongThucThanhToan getPhuongThuc(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		PhuongThucThanhToan pttt=currentSession.get(PhuongThucThanhToan.class, id);
		return pttt;
	}

	@Override
	public List<HoaDon> getListHoaDonTheoPage(int page, List<HoaDon> list) {
		// TODO Auto-generated method stub
		int position = (page-1)*9;
		int end = position + 9;
		
		List<HoaDon> hoaDons = new ArrayList<HoaDon>();
		
		while(position < end && list.size() > position) {
			hoaDons.add(list.get(position));
			position++;
		}
		
		return hoaDons;
	}

	@Override
	public List<HoaDon> timKiemHoaDon(String search) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<HoaDon> hoaDons=currentSession.createNativeQuery("select * from HOADON hd join CHITIETHOADON ct on hd.id=ct.id_HoaDon\r\n"
				+ "where hd.hoTenKhachHang like N'%"+search+"%' or soDienThoaiGiaoHang like N'%"+search+"%' or email like N'%"+search+"%'",HoaDon.class).getResultList();
		return hoaDons;
	}

	@Override
	public List<HoaDon> xapXepTheo(String name,String search) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();		
		String sql=null;
		List<HoaDon> hoadons=new ArrayList<HoaDon>();
		switch (name) {
		case "ngay_desc":
			sql="select * from HOADON where hoTenKhachHang like N'%"+search+"%' or soDienThoaiGiaoHang like N'%"+search+"%' order by ngayLap desc";
			hoadons=currentSession.createNativeQuery(sql,HoaDon.class).getResultList();
			break;
		case "ngay_asc":
			sql="select * from HOADON where hoTenKhachHang like N'%"+search+"%' or soDienThoaiGiaoHang like N'%"+search+"%'  order by ngayLap asc";
			hoadons=currentSession.createNativeQuery(sql,HoaDon.class).getResultList();
			break;
		default:
			sql="select * from HOADON where hoTenKhachHang like N'%"+search+"%' or soDienThoaiGiaoHang like N'%"+search+"%' ";
			hoadons=currentSession.createNativeQuery(sql,HoaDon.class).getResultList();
			break;
		}
		
		return hoadons;
	}

}
