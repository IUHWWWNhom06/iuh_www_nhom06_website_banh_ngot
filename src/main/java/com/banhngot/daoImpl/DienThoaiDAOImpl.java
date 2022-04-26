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

import com.banhngot.dao.DienThoaiDAO;
import com.banhngot.entity.DienThoai;
import com.banhngot.entity.ThuongHieu;

@Repository
public class DienThoaiDAOImpl implements DienThoaiDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void saveDienThoai(DienThoai dt) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(dt);
	}

	@Transactional
	@Override
	public void deleteDienThoai(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		DienThoai dt = currentSession.get(DienThoai.class, id);
		currentSession.delete(dt);
	}

	@Transactional
	@Override
	public DienThoai getDienThoai(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		DienThoai dt = currentSession.get(DienThoai.class, id);
		return dt;
	}

	@Transactional
	@Override
	public List<DienThoai> getListDienThoai() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DienThoai> theQuery = currentSession.createQuery("from DienThoai", DienThoai.class);
		List<DienThoai> dts = theQuery.getResultList();
		return dts;
	}

	@Transactional
	@Override
	public List<DienThoai> getListTheoTen(String tenDT) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DienThoai> theQuery = currentSession
				.createNativeQuery("select * from DienThoai where tenDT like N'%" + tenDT + "%'", DienThoai.class);
		List<DienThoai> dts = theQuery.getResultList();
		return dts;
	}

	@Transactional
	@Override
	public List<DienThoai> getListDienThoaiGiamGia() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DienThoai> theQuery = currentSession.createQuery("from DienThoai where giamGia>0 ", DienThoai.class);
		List<DienThoai> dts = theQuery.getResultList();
		return dts;
	}

	@Transactional
	@Override
	public List<DienThoai> getListDienThoaiBanChay() {
		List<DienThoai> dts = new ArrayList<DienThoai>();
		Session currentSession = sessionFactory.getCurrentSession();
		String sql = "select id, SUM(ct.soLuong) as sum from DIENTHOAI as dt join CHITIETHOADON ct on dt.id = ct.id_DienThoai\r\n"
				+ "group by dt.id,dt.tenDT\r\n" + "order by sum desc";
		List<?> list = currentSession.createNativeQuery(sql).getResultList();
		for (Object object : list) {
			Object[] temp = (Object[]) object;
			DienThoai dt = currentSession.find(DienThoai.class, temp[0]);
			dts.add(dt);
		}
		return dts;
	}

	@Transactional
	@Override
	public List<ThuongHieu> getListThuongHieu() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ThuongHieu> theQuery = currentSession.createQuery("from ThuongHieu ", ThuongHieu.class);
		List<ThuongHieu> ths = theQuery.getResultList();
		return ths;
	}

	@Override
	public List<DienThoai> getListDienThoaiTheoPage(int page, int element, List<DienThoai> list) {
		// TODO Auto-generated method stub
		int position = (page - 1) * element;
		int end = position + element;

		List<DienThoai> dienThoais = new ArrayList<DienThoai>();

		while (position < end && list.size() > position) {
			dienThoais.add(list.get(position));
			position++;
		}

		return dienThoais;
	}

	@Transactional
	@Override
	public List<DienThoai> getListDienThoaiCoSapXep(String sortName,String searchName,String memory) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<DienThoai> dts = new ArrayList<DienThoai>();
		String sql = null;
		switch (sortName) {
		case "gia_asc":
			sql = "select dt.* from DIENTHOAI dt join THUONGHIEU th  on dt.id_ThuongHieu = th.id join THONGSO ts on dt.id_ThongSo = ts.id "
					+ "where (LOWER(tenDT) like N'%"+searchName+"%' or LOWER(baoHanh) like N'%"+searchName+"%' or "
					+ "LOWER(kichThuoc) like N'%"+searchName+"%' or LOWER(mauSac) like N'%"+searchName+"%' or "
					+ "LOWER(tenTH) like N'%"+searchName+"%' or LOWER(xuatXu) like N'%"+searchName+"%' or "
					+ "LOWER(heDieuHanh) like N'%"+searchName+"%' or LOWER(manHinh) like N'%"+searchName+"%' or "
					+ "LOWER(camera) like N'%"+searchName+"%' or "
					+ "LOWER(pin) like N'%"+searchName+"%' or LOWER(ram) like N'%"+searchName+"%' or "
					+ "LOWER(sim) like N'%"+searchName+"%') "
					+ "and LOWER(boNho) like N'%"+memory+"%' "
					+ "order by (giaDT*(100-giamGia))/100  asc";
			dts = currentSession.createNativeQuery(sql, DienThoai.class).getResultList();
			break;
		case "gia_desc":
			sql = "select dt.* from DIENTHOAI dt join THUONGHIEU th  on dt.id_ThuongHieu = th.id join THONGSO ts on dt.id_ThongSo = ts.id "
					+ "where (LOWER(tenDT) like N'%"+searchName+"%' or LOWER(baoHanh) like N'%"+searchName+"%' or "
					+ "LOWER(kichThuoc) like N'%"+searchName+"%' or LOWER(mauSac) like N'%"+searchName+"%' or "
					+ "LOWER(tenTH) like N'%"+searchName+"%' or LOWER(xuatXu) like N'%"+searchName+"%' or "
					+ "LOWER(heDieuHanh) like N'%"+searchName+"%' or LOWER(manHinh) like N'%"+searchName+"%' or "
					+ "LOWER(camera) like N'%"+searchName+"%' or "
					+ "LOWER(pin) like N'%"+searchName+"%' or LOWER(ram) like N'%"+searchName+"%' or "
					+ "LOWER(sim) like N'%"+searchName+"%') "
					+ "and LOWER(boNho) like N'%"+memory+"%' "
					+ "order by (giaDT*(100-giamGia))/100  desc";
			dts = currentSession.createNativeQuery(sql, DienThoai.class).getResultList();
			break;
		case "giamgia":
			sql = "select dt.* from DIENTHOAI dt join THUONGHIEU th  on dt.id_ThuongHieu = th.id join THONGSO ts on dt.id_ThongSo = ts.id "
					+ "where giamGia > 0 and "
					+ "(LOWER(tenDT) like N'%"+searchName+"%' or LOWER(baoHanh) like N'%"+searchName+"%' or "
					+ "LOWER(kichThuoc) like N'%"+searchName+"%' or LOWER(mauSac) like N'%"+searchName+"%' or "
					+ "LOWER(tenTH) like N'%"+searchName+"%' or LOWER(xuatXu) like N'%"+searchName+"%' or "
					+ "LOWER(heDieuHanh) like N'%"+searchName+"%' or LOWER(manHinh) like N'%"+searchName+"%' or "
					+ "LOWER(camera) like N'%"+searchName+"%' or "
					+ "LOWER(pin) like N'%"+searchName+"%' or LOWER(ram) like N'%"+searchName+"%' or "
					+ "LOWER(sim) like N'%"+searchName+"%') "
					+ "and LOWER(boNho) like N'%"+memory+"%' "
					+ "order by (giaDT*(100-giamGia))/100  asc";
			dts = currentSession.createNativeQuery(sql, DienThoai.class).getResultList();
			break;
		case "banchay":
			sql = "select dt.id, SUM(ct.soLuong) as sum from DIENTHOAI dt join CHITIETHOADON ct on dt.id = ct.id_DienThoai "
				+ "join THUONGHIEU th  on dt.id_ThuongHieu = th.id join THONGSO ts on dt.id_ThongSo = ts.id "
				+ "where (LOWER(tenDT) like N'%"+searchName+"%' or LOWER(baoHanh) like N'%"+searchName+"%' or "
				+ "LOWER(kichThuoc) like N'%"+searchName+"%' or LOWER(mauSac) like N'%"+searchName+"%' or "
				+ "LOWER(tenTH) like N'%"+searchName+"%' or LOWER(xuatXu) like N'%"+searchName+"%' or "
				+ "LOWER(heDieuHanh) like N'%"+searchName+"%' or LOWER(manHinh) like N'%"+searchName+"%' or "
				+ "LOWER(camera) like N'%"+searchName+"%' or "
				+ "LOWER(pin) like N'%"+searchName+"%' or LOWER(ram) like N'%"+searchName+"%' or "
				+ "LOWER(sim) like N'%"+searchName+"%') "
				+ "and LOWER(boNho) like N'%"+memory+"%' "
				+ "group by dt.id,dt.tenDT "
				+ "order by sum desc";
			List<?> list = currentSession.createNativeQuery(sql).getResultList();
			for (Object object : list) {
				Object[] temp = (Object[]) object;
				DienThoai dt = currentSession.find(DienThoai.class, temp[0]);
				dts.add(dt);
			}
			break;
		/*
		 * case "hotnhat": sql =
		 * "select dt.id, ts.boNho from DIENTHOAI dt join THONGSO ts on dt.id_ThongSo = ts.id"
		 * ; List<?> ds_id_boNho =
		 * currentSession.createNativeQuery(sql).getResultList(); final List<Integer>
		 * listboNho = new ArrayList<Integer>(); Map<String, Integer> map = new
		 * HashMap<String, Integer>(); for (Object object : ds_id_boNho) { Object[] temp
		 * = (Object[]) object; String chuoiBoNho =
		 * temp[1].toString().replaceAll("[a-zA-Z]", ""); int boNho =
		 * Integer.parseInt(chuoiBoNho); map.put(temp[0].toString(), boNho); } final
		 * List<DienThoai> finaldt = new ArrayList<DienThoai>(); LinkedHashMap<String,
		 * Integer> reverseSortedMap = new LinkedHashMap<>();
		 * map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.
		 * reverseOrder())) .forEachOrdered(x -> reverseSortedMap.put(x.getKey(),
		 * x.getValue())); reverseSortedMap.forEach((id, bn) -> { listboNho.add(bn);
		 * finaldt.add(currentSession.find(DienThoai.class, Integer.parseInt(id))); });
		 * dts = finaldt; break;
		 */
		default:
			sql = "select dt.* from DIENTHOAI dt join THUONGHIEU th  on dt.id_ThuongHieu = th.id join THONGSO ts on dt.id_ThongSo = ts.id "
					+ "where (LOWER(tenDT) like N'%"+searchName+"%' or LOWER(baoHanh) like N'%"+searchName+"%' or "
					+ "LOWER(kichThuoc) like N'%"+searchName+"%' or LOWER(mauSac) like N'%"+searchName+"%' or "
					+ "LOWER(tenTH) like N'%"+searchName+"%' or LOWER(xuatXu) like N'%"+searchName+"%' or "
					+ "LOWER(heDieuHanh) like N'%"+searchName+"%' or LOWER(manHinh) like N'%"+searchName+"%' or "
					+ "LOWER(camera) like N'%"+searchName+"%' or "
					+ "LOWER(pin) like N'%"+searchName+"%' or LOWER(ram) like N'%"+searchName+"%' or "
					+ "LOWER(sim) like N'%"+searchName+"%') "
					+ "and LOWER(boNho) like N'%"+memory+"%' "
					+ "order by (giaDT*(100-giamGia))/100  desc";
			dts = currentSession.createNativeQuery(sql, DienThoai.class).getResultList();
			break;
		}
		return dts;
	}

	@Override
	@Transactional
	public List<DienThoai> getListDienThoaiSearch(String searchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<DienThoai> dts = new ArrayList<DienThoai>();
		String sql = null;
		if (searchName != null && searchName.trim().length() > 0) {
			// search for firstName or lastName ... case insensitive
			String theName = "N'%" + searchName + "%'";
			sql = "select dt.* from DIENTHOAI dt join THUONGHIEU th  on dt.id_ThuongHieu = th.id join THONGSO ts on dt.id_ThongSo = ts.id\r\n"
					+ "where LOWER(tenDT) like(" + theName + ") or LOWER(baoHanh) like(" + theName
					+ ") or LOWER(kichThuoc) like(" + theName + ") or LOWER(mauSac) like(" + theName
					+ ") or LOWER(tenTH) like(" + theName + ") or LOWER(xuatXu) like(" + theName
					+ ") or LOWER(heDieuHanh) like(" + theName + ") or LOWER(manHinh) like(" + theName
					+ ") or LOWER(boNho) like(" + theName + ") or LOWER(camera) like(" + theName
					+ ") or LOWER(pin) like(" + theName + ") or LOWER(ram) like(" + theName + ") or LOWER(sim) like("
					+ theName + ")";
		} else {
			sql = "select * from DIENTHOAI";
		}
		dts = currentSession.createNativeQuery(sql, DienThoai.class).getResultList();
		return dts;
	}
	@Transactional
	@Override
	public List<DienThoai> getListDienThoaiTheoThuongHieu(int idThuongHieu) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("select * from DIENTHOAI where id_ThuongHieu = "+idThuongHieu, DienThoai.class).getResultList();
	}

	@Override
	public List<DienThoai> getListDienThoaiLienQuan(String tenDM) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		List<DienThoai> list=currentSession.createNativeQuery("select top 4 dt.* from DIENTHOAI dt join DANHMUC dm on dt.id_DanhMuc=dm.id\r\n"
				+ " where dm.tenDanhMuc = '"+tenDM+"'",DienThoai.class).getResultList();
		return list;
	}

}
