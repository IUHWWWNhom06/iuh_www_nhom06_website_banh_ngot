package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.Product;

public interface ProductService {
	public void saveProduct(Product dt);
	public void deleteProduct(int id);
	public Product getProduct(int id);
	public List<Product> getListProduct();
	public List<Product> getListProduct(List<Product> list);
	public List<Product> getListProductCoSapXep(String sort,String searchName);
	public List<Product> getListProductSearch(String searchName);
	public List<Product> getListProductLienQuan(String tenDM);
}
