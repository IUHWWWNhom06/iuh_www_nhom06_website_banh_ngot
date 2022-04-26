package com.banhngot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.service.ThongKeService;

@Controller(value = "trangChuControllerOfadmin")
@RequestMapping("/admin")
public class TrangchuController {
	@Autowired
	private ThongKeService thongKeService;

	@GetMapping({ "/", "/trang-chu" })
	private String trangChu(Model model) {
		int soLuongDonHangTheoThang = thongKeService.getDonHangTheoThang();
		double doanhThuTheoThangHienTai = thongKeService.getDoanhThuTheoThangHienTai();
		double doanhThuTheoThangTruoc = thongKeService.getDoanhThuTheoThangTruoc();
		double loiNhuan = (doanhThuTheoThangHienTai - doanhThuTheoThangTruoc);
		double phanTram = ((doanhThuTheoThangHienTai - doanhThuTheoThangTruoc) / doanhThuTheoThangTruoc) * 100;
		int soLuongBan = thongKeService.getSoLuongBan();
		model.addAttribute("soLuongBan", soLuongBan);
		model.addAttribute("sl", soLuongDonHangTheoThang);
		model.addAttribute("doanhThu", doanhThuTheoThangHienTai);
		model.addAttribute("loiNhuan", loiNhuan);
		model.addAttribute("phanTram", phanTram);
		return "admin/index";
	}
}
