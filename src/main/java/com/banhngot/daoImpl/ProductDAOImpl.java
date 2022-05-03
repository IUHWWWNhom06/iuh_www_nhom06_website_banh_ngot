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
	public void saveProduct(Product dt) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(dt);
	}

	@Transactional
	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Product dt = currentSession.get(Product.class, id);
		currentSession.delete(dt);
	}

	@Transactional
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Product dt = currentSession.get(Product.class, id);
		return dt;
	}

	@Transactional
	@Override
	public List<Product> getListProduct() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
		List<Product> dts = theQuery.getResultList();
		return dts;
	}


	@Override
	public List<Product> getListProduct(List<Product> list) {
		// TODO Auto-generated method stub
		int position = 0;

		List<Product> dienThoais = new ArrayList<Product>();

		while (list.size() > position) {
			dienThoais.add(list.get(position));
			position++;
		}

		return dienThoais;
	}

	@Transactional
	@Override
	public List<Product> getListProductCoSapXep(String sortName,String searchName) {
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
		default:
			sql = "select dt.* from Product dt "
					+ "where (LOWER(name) like N'%"+searchName+"%') "
					+ "order by (giaDT*(100-giamGia))/100  desc";
			dts = currentSession.createNativeQuery(sql, Product.class).getResultList();
			break;
		}
		return dts;
	}

	@Override
	@Transactional
	public List<Product> getListProductSearch(String searchName) {
		System.out.println(searchName);
		Session currentSession = sessionFactory.getCurrentSession();
		List<Product> dts = new ArrayList<Product>();
		String sql = null;
		if (searchName != null && searchName.trim().length() > 0) {
			String theName = "N'%" + searchName + "%'";
			sql = "select dt.* from Product dt \r\n"
					+ "where LOWER(name) like(" + theName + ")";
		} else {
			sql = "select * from Product";
		}
		dts = currentSession.createNativeQuery(sql, Product.class).getResultList();
		return dts;
	}

	@Override
	public List<Product> getListProductLienQuan(String tenDM) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Product> list=currentSession.createNativeQuery("select top 4 dt.* from Product dt join TypeProduct dm on dt.id_DanhMuc=dm.id\r\n"
				+ " where dm.tenDanhMuc = '"+tenDM+"'",Product.class).getResultList();
		return list;
	}

}
