package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.Product;

public interface ThongKeService {
	public int getDonHangTheoThang();
	public double getDoanhThuTheoThangHienTai();
	public double getDoanhThuTheoThangTruoc();
	public List<Product> getListDienThoaiBanChay();
	public int getSoLuongBan();
}
