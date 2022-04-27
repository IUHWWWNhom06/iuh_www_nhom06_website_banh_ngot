package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.Product;

public interface ThongKeDao {
	public int getDonHangTheoThang();
	public double getDoanhThuTheoThangHienTai();
	public double getDoanhThuTheoThanggTruoc();
	public List<Product> getListDienThoaiBanChay();
	public int getSoLuongBan();
}
