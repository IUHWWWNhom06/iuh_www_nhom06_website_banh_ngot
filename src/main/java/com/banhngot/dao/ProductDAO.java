package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.Product;
import com.banhngot.entity.ThuongHieu;

public interface ProductDAO {
	public void saveDienThoai(Product dt);
	public void deleteDienThoai(int id);
	public Product getDienThoai(int id);
	public List<Product> getListDienThoai();
//	public List<BanhNgot> getListTheoTen(String tenDT);
//	public List<BanhNgot> getListDienThoaiGiamGia();
//	public List<BanhNgot> getListDienThoaiBanChay();
	public List<Product> getListDienThoaiLienQuan(String tenDM); //Theo danh muc
//	public List<ThuongHieu> getListThuongHieu();
	public List<Product> getListDienThoaiTheoPage(int page, int element, List<Product> list);
	public List<Product> getListDienThoaiCoSapXep(String sortName,String searchName,String memory);
	public List<Product> getListDienThoaiSearch(String searchName);
//	public List<BanhNgot> getListDienThoaiTheoThuongHieu(int idThuongHieu);
	
}
