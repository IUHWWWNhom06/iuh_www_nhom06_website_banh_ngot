package com.banhngot.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.entity.HoaDon;
import com.banhngot.service.HoaDonService;

@Controller(value = "gioHangControllerOfUser")
@RequestMapping("/hoadon")
public class HoaDonController {
	@Autowired
	private HoaDonService hoaDonService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the service
		List<HoaDon> dts = hoaDonService.getListHoaDon();
		// add the customers to the model
		theModel.addAttribute("dts", dts);
		return "ds-dienthoai";
	}
}
