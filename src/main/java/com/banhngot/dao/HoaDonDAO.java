package com.banhngot.dao;

import java.util.List;

import com.banhngot.entity.HoaDon;
import com.banhngot.entity.PhuongThucThanhToan;

public interface HoaDonDAO {
	public void saveHoaDon(HoaDon hoaDon);
	public HoaDon getHoaDon(int id);
	public List<HoaDon> getListHoaDon();
	public List<PhuongThucThanhToan> layTatCaPhuongThucThanhToan();
	public PhuongThucThanhToan getPhuongThuc(int id);
	public List<HoaDon> getListHoaDonTheoPage(int page, List<HoaDon> list);
	public List<HoaDon> timKiemHoaDon(String search);
	public List<HoaDon> xapXepTheo(String name,String search);
}
