package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ProductDAO;
import com.banhngot.entity.Product;
import com.banhngot.entity.ThuongHieu;
import com.banhngot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public void saveProduct(Product dt) {
		productDAO.saveProduct(dt);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}

	@Override
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	@Override
	@Transactional
	public List<Product> getListProduct() {
		return productDAO.getListProduct();
	}

	@Transactional
	@Override
	public List<Product> getListProduct(List<Product> list) {
		// TODO Auto-generated method stub
		return productDAO.getListProduct(list);
	}
	@Override
	public List<Product> getListProductCoSapXep(String sort,String searchName) {
		// TODO Auto-generated method stub
		return productDAO.getListProductCoSapXep(sort,searchName);
	}

	@Override
	public List<Product> getListProductSearch(String searchName) {
		// TODO Auto-generated method stub
		return productDAO.getListProductSearch(searchName);
	}

	@Transactional
	@Override
	public List<Product> getListProductLienQuan(String tenDM) {
		// TODO Auto-generated method stub
		return productDAO.getListProductLienQuan(tenDM);

	}
}
