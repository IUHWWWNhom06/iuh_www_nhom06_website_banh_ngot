package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.ThuongHieuDao;
import com.banhngot.entity.ThuongHieu;
import com.banhngot.service.ThuongHieuService;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
	@Autowired
	private ThuongHieuDao thuongHieuDao;

	@Transactional
	@Override
	public void saveThuongHieu(ThuongHieu thuongHieu) {
		// TODO Auto-generated method stub
		thuongHieuDao.saveThuongHieu(thuongHieu);
	}

	@Transactional
	@Override
	public void deleteThuongHieu(int id) {
		// TODO Auto-generated method stub
		thuongHieuDao.deleteThuongHieu(id);
	}

	@Transactional
	@Override
	public ThuongHieu getThuongHieu(int id) {
		// TODO Auto-generated method stub
		return thuongHieuDao.getThuongHieu(id);
	}

	@Transactional
	@Override
	public List<ThuongHieu> getListThuongHieu() {
		// TODO Auto-generated method stub
		return thuongHieuDao.getListThuongHieu();
	}

	@Transactional
	@Override
	public ThuongHieu getTheoTen(String tenThuongHieu) {
		// TODO Auto-generated method stub
		return thuongHieuDao.getTheoTen(tenThuongHieu);
	}

}
