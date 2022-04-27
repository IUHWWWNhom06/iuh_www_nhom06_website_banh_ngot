package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ThongKeDao;
import com.banhngot.entity.Product;
import com.banhngot.service.ThongKeService;

@Service
public class ThongKeServiceImpl implements ThongKeService {
	@Autowired
	private ThongKeDao thongKeDao;

	@Transactional
	@Override
	public int getDonHangTheoThang() {
		// TODO Auto-generated method stub
		return thongKeDao.getDonHangTheoThang();
	}

	@Transactional
	@Override
	public double getDoanhThuTheoThangHienTai() {
		// TODO Auto-generated method stub
		return thongKeDao.getDoanhThuTheoThangHienTai();
	}

	@Transactional
	@Override
	public double getDoanhThuTheoThangTruoc() {
		// TODO Auto-generated method stub
		return thongKeDao.getDoanhThuTheoThanggTruoc();
	}

	@Transactional
	@Override
	public List<Product> getListDienThoaiBanChay() {
		// TODO Auto-generated method stub
		return thongKeDao.getListDienThoaiBanChay();
	}

	@Transactional
	@Override
	public int getSoLuongBan() {
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongBan();
	}

}
