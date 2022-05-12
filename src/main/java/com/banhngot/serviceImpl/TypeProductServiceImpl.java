package com.banhngot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banhngot.dao.TypeProductDao;
import com.banhngot.entity.TypeProduct;
import com.banhngot.service.TypeProductService;

@Service
public class TypeProductServiceImpl implements TypeProductService {
	@Autowired
	private TypeProductDao danhMucDao;

	@Transactional
	@Override
	public TypeProduct getDanhMuc(String tenDanhMuc) {
		// TODO Auto-generated method stub
		return danhMucDao.getDanhMuc(tenDanhMuc);
	}

	@Transactional
	@Override
	public List<TypeProduct> getListDanhMuc() {
		// TODO Auto-generated method stub
		return danhMucDao.getListDanhMuc();
	}

	@Transactional
	@Override
	public TypeProduct getDanhMuc(int id) {
		// TODO Auto-generated method stub
		return danhMucDao.getDanhMuc(id);
	}
	@Transactional
	@Override
	public List<TypeProduct> getListTheoTen(String tenDanhMuc) {
		// TODO Auto-generated method stub
		return danhMucDao.getListTheoTen(tenDanhMuc);
	}

}
