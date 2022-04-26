package com.banhngot.controller.admin;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banhngot.entity.NguoiDung;
import com.banhngot.service.NguoiDungService;
import com.banhngot.service.RoleService;

@Controller(value = "nguoiDungControllerOfAdmin")
@RequestMapping("/admin")
public class NguoiDungController {
	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private RoleService roleService;

	@GetMapping("/user/search")
	private String timKiemNguoiDung(Model theModel, @RequestParam(value = "search", defaultValue = "") String search) {
		if (search != null && search.trim().length() > 0) {
			List<NguoiDung> datHang = nguoiDungService.timKiemNguoiDungDatHang(search);
			List<NguoiDung> chuaDat = nguoiDungService.timKiemNguoiDungChuaDatHang(search);
			theModel.addAttribute("datHang", datHang);
			theModel.addAttribute("chuaDatHang", chuaDat);
			return "admin/user";
		} else {
			return "redirect:/admin/user/list";
		}

	}

	@GetMapping("/user/list")
	private String User(Model theModel, @RequestParam(value = "search", defaultValue = "") String search) {
		List<NguoiDung> chuaDatHang = nguoiDungService.getChuaDatHang();
		List<NguoiDung> datHang = nguoiDungService.getDatHang();
		theModel.addAttribute("chuaDatHang", chuaDatHang);
		theModel.addAttribute("datHang", datHang);
		return "admin/user";
	}

	@GetMapping("/user/showFormEdit")
	private String showFormEditUser(@RequestParam("userId") int id, Model theModel) {
		NguoiDung user = nguoiDungService.getNguoiDung(id);
		theModel.addAttribute("user", user);
		return "admin/user-form";
	}

	@PostMapping("/user/save")
	private String editUser(@ModelAttribute("user") @Validated NguoiDung user, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/user-form";
		} else {
			String role = "ROLE_USER";
			user.setVaiTro(role);
			user.setRoles(Arrays.asList(roleService.findRoleByName(role)));
			nguoiDungService.saveNguoiDung(user);
			return "redirect:/admin/user/list";
		}
	}

	@GetMapping("/user/showFormAdd")
	private String showFormAddUser(Model theModel) {
		NguoiDung user = new NguoiDung();
		theModel.addAttribute("user", user);
		return "admin/user-form";
	}

	@GetMapping("/user/delete")
	private String deleteUser(@RequestParam("userId") int id) {
		nguoiDungService.deleteNguoiDung(id);
		return "redirect:/admin/user/list";
	}

	@GetMapping("/admin/list")
	private String admin(Model theModel) {
		List<NguoiDung> admin = nguoiDungService.getListNguoiDung();
		theModel.addAttribute("admin", admin);
		return "admin/admin";
	}

	@GetMapping("/admin/showFormEdit")
	private String showFormEditAdmin(@RequestParam("adminId") int id, Model theModel) {
		NguoiDung admin = nguoiDungService.getNguoiDung(id);
		theModel.addAttribute("admin", admin);
		return "admin/admin-form";
	}

	@PostMapping("/admin/save")
	private String editAdmin(@ModelAttribute("admin") NguoiDung admin) {
		String role = "ROLE_ADMIN";
		admin.setVaiTro(role);
		admin.setRoles(Arrays.asList(roleService.findRoleByName(role)));
		nguoiDungService.saveNguoiDung(admin);
		return "redirect:/admin/admin/list";
	}

}
