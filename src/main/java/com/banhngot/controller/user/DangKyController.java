package com.banhngot.controller.user;

import java.sql.Date;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.entity.NguoiDung;
import com.banhngot.service.NguoiDungService;
import com.banhngot.service.RoleService;

@Controller(value = "dangKyController")
@RequestMapping(value = "/user")
public class DangKyController {
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;

	@GetMapping(value = "/formDangKy")
	public String showFormDangKy(Model model) {
		model.addAttribute("nguoiDung", new NguoiDung());
		return "user/dangky";
	}

	@PostMapping("/dangky")
	public String DangKy(@ModelAttribute("nguoiDung") @Validated NguoiDung nguoiDung,BindingResult result, Model theModel
			) {
		if (result.hasErrors()) {
			return "user/dangky";
		} else {
			String role="ROLE_USER";
			String tenDangNhap = nguoiDung.getTenDangNhap();
			NguoiDung tonTai = nguoiDungService.getTenDangNhap(tenDangNhap);
			if (tonTai != null) {
				theModel.addAttribute("nguoiDung", new NguoiDung());
				theModel.addAttribute("loi", "Tên đăng nhập đã tồn tại!");
				return "user/dangky";
			} else {
				nguoiDung.setNgayTao(new Date(System.currentTimeMillis()));
				nguoiDung.setVaiTro(role);
				nguoiDung.setMatKhau(passwordEncoder.encode(nguoiDung.getMatKhau()));
				nguoiDung.setRoles(Arrays.asList(roleService.findRoleByName(role)));
				nguoiDungService.saveNguoiDung(nguoiDung);
				guiMailChoKhachHang(nguoiDung.getEmail());
				return "user/dangkythanhcong";
			}
		}
	}
	public void guiMailChoKhachHang(String email) {
		try {
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
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setContent("Cám ơn bạn đã đăng ký tài khoản. \n"+
			"Đăng nhập tại đây: http://localhost:8080/WebBanDienThoai/user/formDangNhap", "text/plain; charset=UTF-8");
			message.setSubject("QMobile");
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", "HoangTheLongxm40@gmail.com", "Dkm0983382780");
			transport.sendMessage(message, message.getAllRecipients());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
