package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ChiTietHoaDonDAO;
import com.banhngot.entity.ChiTietHoaDon;
import com.banhngot.service.ChiTietHoaDonService;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {
	@Autowired
	private ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	
	@Override
	@Transactional
	public List<ChiTietHoaDon> getChiTietHoaDon(int id) {
		return chiTietHoaDonDAO.getChiTietHoaDon(id);
	}

	@Override
	@Transactional
	public List<ChiTietHoaDon> getAllChiTietHoaDon() {
		return chiTietHoaDonDAO.getAllChiTietHoaDon();
	}

	@Override
	@Transactional
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDon);
	}

	@Override
	@Transactional
	public void addChiTietHoaDon(int id_dienthoai, int id_hoadon, int soLuong) {
		// TODO Auto-generated method stub
		 chiTietHoaDonDAO.addChiTietHoaDon(id_dienthoai, id_hoadon, soLuong);
	}
	

	

	
	
}
