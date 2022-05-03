package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.Product;
import com.banhngot.entity.ThuongHieu;

public interface ProductService {
	public void saveProduct(Product dt);
	public void deleteProduct(int id);
	public Product getProduct(int id);
	public List<Product> getListProduct();
//	public List<Product> getListTheoTen(String tenDT);
//	public List<Product> getProductGiamGia(); 
//	public List<Product> getDienTHoaiBanChay();
//	public List<ThuongHieu> getListThuongHieu();
	public List<Product> getListProductTheoPage(int page, int element, List<Product> list);
	public List<Product> getListProductCoSapXep(String sort,String searchName,String memory);
	public List<Product> getListProductSearch(String searchName);
	public List<Product> getListProductLienQuan(String tenDM);
//	public List<Product> getListProductTheoThuongHieu(int idThuongHieu);
}
