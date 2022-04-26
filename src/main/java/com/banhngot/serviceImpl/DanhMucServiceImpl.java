package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.DanhMucDao;
import com.banhngot.entity.DanhMuc;
import com.banhngot.service.DanhMucService;

@Service
public class DanhMucServiceImpl implements DanhMucService {
	@Autowired
	private DanhMucDao danhMucDao;

	@Transactional
	@Override
	public DanhMuc getDanhMuc(String tenDanhMuc) {
		// TODO Auto-generated method stub
		return danhMucDao.getDanhMuc(tenDanhMuc);
	}

	@Transactional
	@Override
	public List<DanhMuc> getListDanhMuc() {
		// TODO Auto-generated method stub
		return danhMucDao.getListDanhMuc();
	}

	@Transactional
	@Override
	public void saveDanhMuc(DanhMuc danhMuc) {
		// TODO Auto-generated method stub
		danhMucDao.saveDanhMuc(danhMuc);
	}

	@Transactional
	@Override
	public void deleteDanhMuc(int id) {
		// TODO Auto-generated method stub
		danhMucDao.deleteDanhMuc(id);
	}

	@Transactional
	@Override
	public DanhMuc getDanhMuc(int id) {
		// TODO Auto-generated method stub
		return danhMucDao.getDanhMuc(id);
	}
	@Transactional
	@Override
	public List<DanhMuc> getListTheoTen(String tenDanhMuc) {
		// TODO Auto-generated method stub
		return danhMucDao.getListTheoTen(tenDanhMuc);
	}

}
