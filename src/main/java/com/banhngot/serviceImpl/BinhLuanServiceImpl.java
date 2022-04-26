package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.BinhLuanDao;
import com.banhngot.entity.BinhLuan;
import com.banhngot.service.BinhLuanService;

@Service
public class BinhLuanServiceImpl implements BinhLuanService {
	@Autowired
	private BinhLuanDao binhLuanDao;

	@Transactional
	@Override
	public List<BinhLuan> getListBinhLuan() {
		// TODO Auto-generated method stub
		return binhLuanDao.getListBinhLuan();
	}

	@Transactional
	@Override
	public void themBinhLuan(BinhLuan binhLuan) {
		// TODO Auto-generated method stub
		binhLuanDao.themBinhLuan(binhLuan);
	}

	@Transactional
	@Override
	public List<BinhLuan> getListBinhLuanByIdDienThoai(int dtId) {
		// TODO Auto-generated method stub
		return binhLuanDao.getListBinhLuanByIdDienThoai(dtId);
	}

	@Transactional
	@Override
	public void xoaBinhLuan(int id) {
		// TODO Auto-generated method stub
		binhLuanDao.xoaBinhLuan(id);
	}

}
