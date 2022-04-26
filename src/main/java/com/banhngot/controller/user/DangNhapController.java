package com.banhngot.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.entity.NguoiDung;

@Controller(value = "dangNhapController")
@RequestMapping(value = "/user")
public class DangNhapController {
	@GetMapping(value = "/formDangNhap")
	public String showFormDangNhap(Model model) {
		model.addAttribute("nguoiDungDangNhap",	new NguoiDung());
		return "user/dangnhap";
	}
}
