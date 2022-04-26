package com.banhngot.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.entity.ChiTietHoaDon;
import com.banhngot.service.ChiTietHoaDonService;

@Controller(value = "ChiTietHoaDonControllerOfAdmin")
@RequestMapping("/admin")
public class ChiTietHoaDonController {
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;

	@GetMapping("/orderdetail/list")
	private String order(Model theModel) {
		List<ChiTietHoaDon> order = chiTietHoaDonService.getAllChiTietHoaDon();
		theModel.addAttribute("order", order);
		return "admin/order";
	}

//	@GetMapping("/user/showFormEdit")
//	private String showFormEditUser(@RequestParam("userId") int id, Model theModel) {
//		NguoiDung user=nguoiDungService.getNguoiDung(id);
//		theModel.addAttribute("user",user);
//		return "admin/user-form";
//	}
//	
//	@PostMapping("/user/save")
//	private String editUser(@ModelAttribute("user") NguoiDung user) {
//		nguoiDungService.saveNguoiDung(user);
//		return "redirect:/admin/user/list";
//	}
//	
//	@GetMapping("/user/showFormAdd")
//	private String showFormAddUser(Model theModel) {
//		NguoiDung user=new NguoiDung();
//		theModel.addAttribute("user",user);
//		return "admin/user-form";
//	}
//	
//	@GetMapping("/user/delete")
//	private String deleteUser(@RequestParam("userId") int id) {
//		nguoiDungService.deleteNguoiDung(id);
//		return "redirect:/admin/user/list";
//	}
//	
//	@GetMapping("/admin/list")
//	private String admin(Model theModel) {
//		List<NguoiDung> admin=nguoiDungService.getListNguoiDung();
//		theModel.addAttribute("admin",admin);
//		return "admin/admin";
//	}
//	
//	@GetMapping("/admin/showFormEdit")
//	private String showFormEditAdmin(@RequestParam("adminId") int id, Model theModel) {
//		NguoiDung admin=nguoiDungService.getNguoiDung(id);
//		theModel.addAttribute("admin",admin);
//		return "admin/admin-form";
//	}
//	
//	@PostMapping("/admin/save")
//	private String editAdmin(@ModelAttribute("admin") NguoiDung admin) {
//		nguoiDungService.saveNguoiDung(admin);
//		return "redirect:/admin/admin/list";
//	}
}
