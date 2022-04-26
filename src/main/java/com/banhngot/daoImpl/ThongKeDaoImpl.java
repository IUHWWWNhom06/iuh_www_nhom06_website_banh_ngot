package com.banhngot.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ThongKeDao;
import com.banhngot.entity.DienThoai;

@Repository
public class ThongKeDaoImpl implements ThongKeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int getDonHangTheoThang() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		int count=(int) currentSession.createNativeQuery("select  COUNT(id) from HOADON where MONTH(ngayLap)=MONTH(GETDATE())").getSingleResult();
		return count;
	}

	@Override
	public double getDoanhThuTheoThangHienTai() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		double doanhThu=(double) currentSession.createNativeQuery("select sum(ct.soLuong*dt.giaDT)\r\n"
				+ "from CHITIETHOADON ct \r\n"
				+ "join DIENTHOAI dt on dt.id=ct.id_DienThoai\r\n"
				+ "join HOADON hd on hd.id=ct.id_HoaDon\r\n"
				+ "where MONTH(hd.ngayLap)=MONTH(GETDATE())").getSingleResult();
		return doanhThu;
	}

	@Override
	public double getDoanhThuTheoThanggTruoc() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		double doanhThu=(double) currentSession.createNativeQuery("select sum(ct.soLuong*dt.giaDT)\r\n"
				+ "from CHITIETHOADON ct \r\n"
				+ "join DIENTHOAI dt on dt.id=ct.id_DienThoai\r\n"
				+ "join HOADON hd on hd.id=ct.id_HoaDon\r\n"
				+ "where MONTH(hd.ngayLap)=MONTH(GETDATE()) - 1").getSingleResult();
		return doanhThu;
	}

	@Transactional
	@Override
	public List<DienThoai> getListDienThoaiBanChay() {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "select  sum(soLuong) as sum, dt.tenDT, dt.giaDT, ts.boNho\r\n"
				+ "from CHITIETHOADON ct \r\n"
				+ "join DIENTHOAI dt on dt.id=ct.id_DienThoai\r\n"
				+ "join THONGSO ts on dt.id_ThongSo=ts.id\r\n"
				+ "group by dt.tenDT, dt.giaDT, ts.boNho\r\n"
				+ "order by sum desc";
		
		@SuppressWarnings("unchecked")
		List<DienThoai> listDT=currentSession.createNativeQuery(sql).getResultList();
		return listDT;	
	}

	@Override
	public int getSoLuongBan() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		int sum=(int) currentSession.createNativeQuery("select  sum(soLuong) as sum from CHITIETHOADON ct join HOADON hd on hd.id=ct.id_HoaDon\r\n"
				+ "where MONTH(hd.ngayLap)=MONTH(GETDATE())").getSingleResult();
		return sum;
	}

}
