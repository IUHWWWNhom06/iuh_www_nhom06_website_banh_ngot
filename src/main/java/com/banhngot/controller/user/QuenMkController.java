package com.banhngot.controller.user;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banhngot.entity.NguoiDung;
import com.banhngot.service.NguoiDungService;

@Controller(value = "QuenMkController")
@RequestMapping("/user")
public class QuenMkController {
	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/formTimTenDangNhap")
	public String timTenDangNhap() {
		return "user/formtimtendangnhap";
	}

	@GetMapping("/formCapNhatMatKhau")
	public String formCapNhatMatKhau() {
		return "user/formCapNhatMatKhau";
	}

	@PostMapping("/capNhatMatKhau")
	public String capNhatMatKhau(@RequestParam("matKhau") String matKhau, HttpSession session,Model model) {
		try {
			String email = (String) session.getAttribute("email");
			NguoiDung nguoiDung = nguoiDungService.getEmail(email);
			
			nguoiDung.setMatKhau(passwordEncoder.encode(matKhau));
			nguoiDungService.saveNguoiDung(nguoiDung);
			session.removeAttribute("email");

			return "user/capnhatthanhcong";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("error","Mật khẩu phải tối tiếu 8 kí tự.");
		return "user/formCapNhatMatKhau";
	}

}
