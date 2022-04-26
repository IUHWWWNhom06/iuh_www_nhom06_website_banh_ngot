package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.DanhMuc;

public interface DanhMucService {
	public DanhMuc getDanhMuc(String tenDanhMuc);
	public List<DanhMuc> getListDanhMuc();
	public void saveDanhMuc(DanhMuc danhMuc);
	public void deleteDanhMuc(int id);
	public DanhMuc getDanhMuc(int id);
	public List<DanhMuc> getListTheoTen(String tenDanhMuc);
}
