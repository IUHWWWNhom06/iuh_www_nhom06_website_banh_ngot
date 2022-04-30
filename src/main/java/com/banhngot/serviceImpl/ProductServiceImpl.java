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
	private ProductDAO dienThoaiDAO;

	@Override
	@Transactional
	public void saveDienThoai(Product dt) {
		dienThoaiDAO.saveDienThoai(dt);
	}

	@Override
	@Transactional
	public void deleteDienThoai(int id) {
		dienThoaiDAO.deleteDienThoai(id);
	}

	@Override
	public Product getDienThoai(int id) {
		return dienThoaiDAO.getDienThoai(id);
	}

	@Override
	@Transactional
	public List<Product> getListDienThoai() {
		return dienThoaiDAO.getListDienThoai();
	}

//	@Override
//	@Transactional
//	public List<Product> getListTheoTen(String tenDT) {
//		// TODO Auto-generated method stub
//		return dienThoaiDAO.getListTheoTen(tenDT);
//	}
//
//	@Override
//	public List<Product> getDienThoaiGiamGia() {
//		// TODO Auto-generated method stub
//		return dienThoaiDAO.getListDienThoaiGiamGia();
//	}
//
//	@Override
//	public List<Product> getDienTHoaiBanChay() {
//		// TODO Auto-generated method stub
//		return dienThoaiDAO.getListDienThoaiBanChay();
//	}
//
//	@Override
//	@Transactional
//	public List<ThuongHieu> getListThuongHieu() {
//		// TODO Auto-generated method stub
//		return dienThoaiDAO.getListThuongHieu();
//	}

	@Transactional
	@Override
	public List<Product> getListDienThoaiTheoPage(int page, int element, List<Product> list) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiTheoPage(page,element, list);
	}
	@Override
	public List<Product> getListDienThoaiCoSapXep(String sort,String searchName,String memory) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiCoSapXep(sort,searchName,memory);
	}

	@Override
	public List<Product> getListDienThoaiSearch(String searchName) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiSearch(searchName);
	}

	@Transactional
	@Override
	public List<Product> getListDienThoaiLienQuan(String tenDM) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiLienQuan(tenDM);

	}
//	@Override
//	public List<Product> getListDienThoaiTheoThuongHieu(int idThuongHieu) {
//		// TODO Auto-generated method stub
//		return dienThoaiDAO.getListDienThoaiTheoThuongHieu(idThuongHieu);
//
//	}
}
