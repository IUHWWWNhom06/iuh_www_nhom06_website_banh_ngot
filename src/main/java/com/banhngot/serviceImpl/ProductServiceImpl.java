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

//	@Override
//	@Transactional
//	public List<Product> getListTheoTen(String tenDT) {
//		// TODO Auto-generated method stub
//		return productDAO.getListTheoTen(tenDT);
//	}
//
//	@Override
//	public List<Product> getProductGiamGia() {
//		// TODO Auto-generated method stub
//		return productDAO.getListProductGiamGia();
//	}
//
//	@Override
//	public List<Product> getDienTHoaiBanChay() {
//		// TODO Auto-generated method stub
//		return productDAO.getListProductBanChay();
//	}
//
//	@Override
//	@Transactional
//	public List<ThuongHieu> getListThuongHieu() {
//		// TODO Auto-generated method stub
//		return productDAO.getListThuongHieu();
//	}

	@Transactional
	@Override
	public List<Product> getListProductTheoPage(int page, int element, List<Product> list) {
		// TODO Auto-generated method stub
		return productDAO.getListProductTheoPage(page,element, list);
	}
	@Override
	public List<Product> getListProductCoSapXep(String sort,String searchName,String memory) {
		// TODO Auto-generated method stub
		return productDAO.getListProductCoSapXep(sort,searchName,memory);
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
//	@Override
//	public List<Product> getListProductTheoThuongHieu(int idThuongHieu) {
//		// TODO Auto-generated method stub
//		return productDAO.getListProductTheoThuongHieu(idThuongHieu);
//
//	}
}
