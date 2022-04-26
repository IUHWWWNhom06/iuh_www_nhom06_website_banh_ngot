package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.DienThoai;

public interface ThongKeService {
	public int getDonHangTheoThang();
	public double getDoanhThuTheoThangHienTai();
	public double getDoanhThuTheoThangTruoc();
	public List<DienThoai> getListDienThoaiBanChay();
	public int getSoLuongBan();
}
