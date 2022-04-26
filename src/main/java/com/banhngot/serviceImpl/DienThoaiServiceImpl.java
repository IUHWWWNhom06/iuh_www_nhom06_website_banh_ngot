package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.DienThoaiDAO;
import com.banhngot.entity.DienThoai;
import com.banhngot.entity.ThuongHieu;
import com.banhngot.service.DienThoaiService;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {
	@Autowired
	private DienThoaiDAO dienThoaiDAO;

	@Override
	@Transactional
	public void saveDienThoai(DienThoai dt) {
		dienThoaiDAO.saveDienThoai(dt);
	}

	@Override
	@Transactional
	public void deleteDienThoai(int id) {
		dienThoaiDAO.deleteDienThoai(id);
	}

	@Override
	public DienThoai getDienThoai(int id) {
		return dienThoaiDAO.getDienThoai(id);
	}

	@Override
	@Transactional
	public List<DienThoai> getListDienThoai() {
		return dienThoaiDAO.getListDienThoai();
	}

	@Override
	@Transactional
	public List<DienThoai> getListTheoTen(String tenDT) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListTheoTen(tenDT);
	}

	@Override
	public List<DienThoai> getDienThoaiGiamGia() {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiGiamGia();
	}

	@Override
	public List<DienThoai> getDienTHoaiBanChay() {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiBanChay();
	}

	@Override
	@Transactional
	public List<ThuongHieu> getListThuongHieu() {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListThuongHieu();
	}

	@Transactional
	@Override
	public List<DienThoai> getListDienThoaiTheoPage(int page, int element, List<DienThoai> list) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiTheoPage(page,element, list);
	}
	@Override
	public List<DienThoai> getListDienThoaiCoSapXep(String sort,String searchName,String memory) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiCoSapXep(sort,searchName,memory);
	}

	@Override
	public List<DienThoai> getListDienThoaiSearch(String searchName) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiSearch(searchName);
	}

	@Transactional
	@Override
	public List<DienThoai> getListDienThoaiLienQuan(String tenDM) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiLienQuan(tenDM);

	}
	@Override
	public List<DienThoai> getListDienThoaiTheoThuongHieu(int idThuongHieu) {
		// TODO Auto-generated method stub
		return dienThoaiDAO.getListDienThoaiTheoThuongHieu(idThuongHieu);

	}
}
