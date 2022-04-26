package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	public List<ChiTietHoaDon> getChiTietHoaDon(int id);
	public List<ChiTietHoaDon> getAllChiTietHoaDon();
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	public void addChiTietHoaDon(int id_dienthoai,int id_hoadon,int soLuong);
	
}
