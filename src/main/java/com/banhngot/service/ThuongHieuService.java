package com.banhngot.service;

import java.util.List;

import com.banhngot.entity.ThuongHieu;

public interface ThuongHieuService {
	public void saveThuongHieu(ThuongHieu thuongHieu);
	public void deleteThuongHieu(int id);
	public ThuongHieu getThuongHieu(int id);
	public List<ThuongHieu> getListThuongHieu();
	public ThuongHieu getTheoTen(String tenThuongHieu);
}
