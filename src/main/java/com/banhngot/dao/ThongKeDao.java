package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.DienThoai;

public interface ThongKeDao {
	public int getDonHangTheoThang();
	public double getDoanhThuTheoThangHienTai();
	public double getDoanhThuTheoThanggTruoc();
	public List<DienThoai> getListDienThoaiBanChay();
	public int getSoLuongBan();
}
