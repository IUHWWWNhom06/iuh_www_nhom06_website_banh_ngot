package com.banhngot.controller.admin;

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

import com.banhngot.entity.ThuongHieu;
import com.banhngot.service.ThuongHieuService;

@Controller(value = "thuongHieuControllerOfAdmin")
@RequestMapping("/admin")
public class ThuongHieuController {
	@Autowired
	private ThuongHieuService thuongHieuService;

	@GetMapping("/brand/list")
	private String getListThuongHieu(Model thModel) {
		List<ThuongHieu> brands = thuongHieuService.getListThuongHieu();
		thModel.addAttribute("brands", brands);
		return "admin/brand";
	}

	@GetMapping("/brand/showFormEdit")
	private String showFormEdit(@RequestParam("brandId") int id, Model theModel) {
		ThuongHieu brand = thuongHieuService.getThuongHieu(id);
		theModel.addAttribute("brand", brand);
		return "admin/brand-form";
	}

	@GetMapping("/brand/showFormAdd")
	private String showFormAdd(Model theModel) {
		ThuongHieu brand = new ThuongHieu();
		theModel.addAttribute("brand", brand);
		return "admin/brand-form";
	}

	@PostMapping("/brand/save")
	private String save(@ModelAttribute("brand") @Validated ThuongHieu brand, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/brand-form";
		} else {
			thuongHieuService.saveThuongHieu(brand);
			return "redirect:/admin/brand/list";
		}

	}

	@GetMapping("/brand/delete")
	private String delete(@RequestParam("brandId") int id) {
		thuongHieuService.deleteThuongHieu(id);
		return "redirect:/admin/brand/list";
	}
}
