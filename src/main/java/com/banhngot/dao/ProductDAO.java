package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.Product;
import com.banhngot.entity.ThuongHieu;

public interface ProductDAO {
	public void saveProduct(Product dt);
	public void deleteProduct(int id);
	public Product getProduct(int id);
	public List<Product> getListProduct();
//	public List<BanhNgot> getListTheoTen(String tenDT);
//	public List<BanhNgot> getListProductGiamGia();
//	public List<BanhNgot> getListProductBanChay();
	public List<Product> getListProductLienQuan(String tenDM); //Theo danh muc
//	public List<ThuongHieu> getListThuongHieu();
	public List<Product> getListProductTheoPage(int page, int element, List<Product> list);
	public List<Product> getListProductCoSapXep(String sortName,String searchName,String memory);
	public List<Product> getListProductSearch(String searchName);
//	public List<BanhNgot> getListProductTheoThuongHieu(int idThuongHieu);
	
}
