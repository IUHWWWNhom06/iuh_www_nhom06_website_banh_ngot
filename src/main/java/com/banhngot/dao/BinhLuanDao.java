 package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.BinhLuan;

public interface BinhLuanDao {
	public List<BinhLuan> getListBinhLuan();
	public void themBinhLuan(BinhLuan binhLuan);
	public void xoaBinhLuan(int id);
	public List<BinhLuan> getListBinhLuanByIdDienThoai(int dtId);
}
