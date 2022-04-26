package com.banhngot.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.entity.ChiTietHoaDon;
import com.banhngot.service.ChiTietHoaDonService;

@Controller(value = "chiTietHoaDonControllerOfUser")
@RequestMapping("a")
public class ChiTietHoaDonController {
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<ChiTietHoaDon> dts = chiTietHoaDonService.getAllChiTietHoaDon();

		theModel.addAttribute("dts", dts);
		return "ds-dienthoai";
	}
}
