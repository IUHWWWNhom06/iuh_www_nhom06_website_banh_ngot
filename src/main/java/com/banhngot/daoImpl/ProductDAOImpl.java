package com.banhngot.daoImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ProductDAO;
import com.banhngot.entity.Product;
import com.banhngot.entity.ThuongHieu;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void saveDienThoai(Product dt) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(dt);
	}

	@Transactional
	@Override
	public void deleteDienThoai(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Product dt = currentSession.get(Product.class, id);
		currentSession.delete(dt);
	}

	@Transactional
	@Override
	public Product getDienThoai(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Product dt = currentSession.get(Product.class, id);
		return dt;
	}

	@Transactional
	@Override
	public List<Product> getListDienThoai() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
		List<Product> dts = theQuery.getResultList();
		return dts;
	}

//	@Transactional
//	@Override
//	public List<BanhNgot> getListTheoTen(String ) {
//		// TODO Auto-generated method stub
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<BanhNgot> theQuery = currentSession
//				.createNativeQuery("select * from DienThoai where  like N'%" +  + "%'", BanhNgot.class);
//		List<BanhNgot> dts = theQuery.getResultList();
//		return dts;
//	}
//
//	@Transactional
//	@Override
//	public List<BanhNgot> getListDienThoaiGiamGia() {
//		// TODO Auto-generated method stub
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<BanhNgot> theQuery = currentSession.createQuery("from DienThoai where giamGia>0 ", BanhNgot.class);
//		List<BanhNgot> dts = theQuery.getResultList();
//		return dts;
//	}

//	@Transactional
//	@Override
//	public List<BanhNgot> getListDienThoaiBanChay() {
//		List<BanhNgot> dts = new ArrayList<BanhNgot>();
//		Session currentSession = sessionFactory.getCurrentSession();
//		String sql = "select id, SUM(ct.soLuong) as sum from DIENTHOAI as dt join CHITIETHOADON ct on dt.id = ct.id_DienThoai\r\n"
//				+ "group by dt.id,dt.\r\n" + "order by sum desc";
//		List<?> list = currentSession.createNativeQuery(sql).getResultList();
//		for (Object object : list) {
//			Object[] temp = (Object[]) object;
//			BanhNgot dt = currentSession.find(BanhNgot.class, temp[0]);
//			dts.add(dt);
//		}
//		return dts;
//	}

//	@Transactional
//	@Override
//	public List<ThuongHieu> getListThuongHieu() {
//		Session currentSession = sessionFactory.getCurrentSession();
//		Query<ThuongHieu> theQuery = currentSession.createQuery("from ThuongHieu ", ThuongHieu.class);
//		List<ThuongHieu> ths = theQuery.getResultList();
//		return ths;
//	}

	@Override
	public List<Product> getListDienThoaiTheoPage(int page, int element, List<Product> list) {
		// TODO Auto-generated method stub
		int position = (page - 1) * element;
		int end = position + element;

		List<Product> dienThoais = new ArrayList<Product>();

		while (position < end && list.size() > position) {
			dienThoais.add(list.get(position));
			position++;
		}

		return dienThoais;
	}

	@Transactional
	@Override
	public List<Product> getListDienThoaiCoSapXep(String sortName,String searchName,String memory) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Product> dts = new ArrayList<Product>();
		String sql = null;
		switch (sortName) {
		case "gia_asc":
			sql = "select dt.* from Product dt "
					+ "where (LOWER(name) like N'%"+searchName+"%')"
					+ "order by (giaDT*(100-giamGia))/100  asc";
			dts = currentSession.createNativeQuery(sql, Product.class).getResultList();
			break;
		case "gia_desc":
			sql = "select dt.* from Product dt "
					+ "order by (giaDT*(100-giamGia))/100  desc";
			dts = currentSession.createNativeQuery(sql, Product.class).getResultList();
			break;
		case "giamgia":
			sql = "select dt.* from Product dt "
					+ "where giamGia > 0 "
					+ "order by (giaDT*(100-giamGia))/100  asc";
			dts = currentSession.createNativeQuery(sql, Product.class).getResultList();
			break;
//		case "banchay":
//			sql = "select dt.id, SUM(ct.soLuong) as sum from DIENTHOAI dt join CHITIETHOADON ct on dt.id = ct.id_DienThoai "
//				+ "join THUONGHIEU th  on dt.id_ThuongHieu = th.id join THONGSO ts on dt.id_ThongSo = ts.id "
//				+ "where (LOWER() like N'%"+searchName+"%' or LOWER(baoHanh) like N'%"+searchName+"%' or "
//				+ "LOWER(kichThuoc) like N'%"+searchName+"%' or LOWER(mauSac) like N'%"+searchName+"%' or "
//				+ "LOWER(tenTH) like N'%"+searchName+"%' or LOWER(xuatXu) like N'%"+searchName+"%' or "
//				+ "LOWER(heDieuHanh) like N'%"+searchName+"%' or LOWER(manHinh) like N'%"+searchName+"%' or "
//				+ "LOWER(camera) like N'%"+searchName+"%' or "
//				+ "LOWER(pin) like N'%"+searchName+"%' or LOWER(ram) like N'%"+searchName+"%' or "
//				+ "LOWER(sim) like N'%"+searchName+"%') "
//				+ "and LOWER(boNho) like N'%"+memory+"%' "
//				+ "group by dt.id,dt. "
//				+ "order by sum desc";
//			List<?> list = currentSession.createNativeQuery(sql).getResultList();
//			for (Object object : list) {
//				Object[] temp = (Object[]) object;
//				Product dt = currentSession.find(Product.class, temp[0]);
//				dts.add(dt);
//			}
//			break;
		default:
			sql = "select dt.* from Product dt "
					+ "where (LOWER(name) like N'%"+searchName+"%') "
//					+ "LOWER(kichThuoc) like N'%"+searchName+"%' or LOWER(mauSac) like N'%"+searchName+"%' or "
//					+ "LOWER(tenTH) like N'%"+searchName+"%' or LOWER(xuatXu) like N'%"+searchName+"%' or "
//					+ "LOWER(heDieuHanh) like N'%"+searchName+"%' or LOWER(manHinh) like N'%"+searchName+"%' or "
//					+ "LOWER(camera) like N'%"+searchName+"%' or "
//					+ "LOWER(pin) like N'%"+searchName+"%' or LOWER(ram) like N'%"+searchName+"%' or "
//					+ "LOWER(sim) like N'%"+searchName+"%') "
//					+ "and LOWER(boNho) like N'%"+memory+"%' "
					+ "order by (giaDT*(100-giamGia))/100  desc";
			dts = currentSession.createNativeQuery(sql, Product.class).getResultList();
			break;
		}
		return dts;
	}

	@Override
	@Transactional
	public List<Product> getListDienThoaiSearch(String searchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Product> dts = new ArrayList<Product>();
		String sql = null;
		if (searchName != null && searchName.trim().length() > 0) {
			// search for firstName or lastName ... case insensitive
			String theName = "N'%" + searchName + "%'";
			sql = "select dt.* from Product dt \r\n"
					+ "where LOWER(name) like(" + theName + ")";
//					+ ") or LOWER(kichThuoc) like(" + theName + ") or LOWER(mauSac) like(" + theName
//					+ ") or LOWER(tenTH) like(" + theName + ") or LOWER(xuatXu) like(" + theName
//					+ ") or LOWER(heDieuHanh) like(" + theName + ") or LOWER(manHinh) like(" + theName
//					+ ") or LOWER(boNho) like(" + theName + ") or LOWER(camera) like(" + theName
//					+ ") or LOWER(pin) like(" + theName + ") or LOWER(ram) like(" + theName + ") or LOWER(sim) like("
//					+ theName + ")";
		} else {
			sql = "select * from Product";
		}
		dts = currentSession.createNativeQuery(sql, Product.class).getResultList();
		System.out.println(dts);
		return dts;
	}
//	@Transactional
//	@Override
//	public List<BanhNgot> getListDienThoaiTheoThuongHieu(int idThuongHieu) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.createNativeQuery("select * from DIENTHOAI where id_ThuongHieu = "+idThuongHieu, BanhNgot.class).getResultList();
//	}
//
	@Override
	public List<Product> getListDienThoaiLienQuan(String tenDM) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<Product> list=currentSession.createNativeQuery("select top 4 dt.* from Product dt join DANHMUC dm on dt.id_DanhMuc=dm.id\r\n"
				+ " where dm.tenDanhMuc = '"+tenDM+"'",Product.class).getResultList();
		return list;
	}

}
