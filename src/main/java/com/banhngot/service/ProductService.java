package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.Product;
import com.banhngot.entity.ThuongHieu;

public interface ProductService {
	public void saveDienThoai(Product dt);
	public void deleteDienThoai(int id);
	public Product getDienThoai(int id);
	public List<Product> getListDienThoai();
//	public List<Product> getListTheoTen(String tenDT);
//	public List<Product> getDienThoaiGiamGia(); 
//	public List<Product> getDienTHoaiBanChay();
//	public List<ThuongHieu> getListThuongHieu();
	public List<Product> getListDienThoaiTheoPage(int page, int element, List<Product> list);
	public List<Product> getListDienThoaiCoSapXep(String sort,String searchName,String memory);
	public List<Product> getListDienThoaiSearch(String searchName);
	public List<Product> getListDienThoaiLienQuan(String tenDM);
//	public List<Product> getListDienThoaiTheoThuongHieu(int idThuongHieu);
}
