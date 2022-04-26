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

	@GetMapping("/guiEmail")
	public String guiEmail(@RequestParam("email") String email, HttpSession sesion,Model model) {
		try {
			NguoiDung nguoiDung = nguoiDungService.getEmail(email);
			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.socketFactory.port", "465");
			Session session = Session.getDefaultInstance(properties, null);
			session.setDebug(true);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("HoangTheLongxm40@gmail.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(nguoiDung.getEmail()));
			message.setContent(
					"Click vào link này để lấy lại mật khẩu" + " "
							+ "http://localhost:8080/WebBanDienThoai/user/formCapNhatMatKhau",
					"text/plain; charset=UTF-8");
			message.setSubject("QMobile");
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", "HoangTheLongxm40@gmail.com", "Dkm0983382780");
			transport.sendMessage(message, message.getAllRecipients());
			sesion.setAttribute("email", email);
			return "user/guiemail";
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("error","Không tìm thấy email!");
		return "user/formtimtendangnhap";
	}
}
