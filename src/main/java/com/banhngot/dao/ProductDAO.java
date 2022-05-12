package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.Product;

public interface ProductDAO {
	public void saveProduct(Product dt);
	public void deleteProduct(int id);
	public Product getProduct(int id);
	public List<Product> getListProduct();
	public List<Product> getListProductLienQuan(String tenDM);
	public List<Product> getListProduct(List<Product> list);
	public List<Product> getListProductCoSapXep(String sortName,String searchName);
	public List<Product> getListProductSearch(String searchName);
}
