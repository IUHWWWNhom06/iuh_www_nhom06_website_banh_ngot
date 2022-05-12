package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.TypeProduct;

public interface TypeProductDao {
	public TypeProduct getDanhMuc(int id);
	public TypeProduct getDanhMuc(String tenDanhMuc);
	public List<TypeProduct> getListDanhMuc();
	public List<TypeProduct> getListTheoTen(String tenDanhMuc);
}
