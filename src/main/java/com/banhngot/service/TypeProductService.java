package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.TypeProduct;

public interface TypeProductService {
	public TypeProduct getDanhMuc(String tenDanhMuc);
	public List<TypeProduct> getListDanhMuc();
	public void saveDanhMuc(TypeProduct danhMuc);
	public void deleteDanhMuc(int id);
	public TypeProduct getDanhMuc(int id);
	public List<TypeProduct> getListTheoTen(String tenDanhMuc);
}
