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

import com.banhngot.entity.DanhMuc;
import com.banhngot.entity.DienThoai;
import com.banhngot.service.DanhMucService;
import com.banhngot.service.DienThoaiService;

@Controller(value = "danhMucControllerOfAdmin")
@RequestMapping("/admin")
public class DanhMucController {
	@Autowired
	private DanhMucService danhMucService;

	@Autowired
	private DienThoaiService dienThoaiService;

	@GetMapping("/cate/list")
	private String getListDanhMuc(Model thModel) {
		List<DanhMuc> cates = danhMucService.getListDanhMuc();
		List<DienThoai> dts = dienThoaiService.getListDienThoai();
		thModel.addAttribute("cates", cates);
		thModel.addAttribute("dts", dts);
		return "admin/cate";
	}

	@GetMapping("/cate/showFormEdit")
	private String showFormEditUser(@RequestParam("cateId") int id, Model theModel) {
		DanhMuc cate = danhMucService.getDanhMuc(id);
		theModel.addAttribute("cate", cate);
		return "admin/cate-form";
	}

	@GetMapping("/cate/showFormAdd")
	private String showFormAddUser(Model theModel) {
		DanhMuc cate = new DanhMuc();
		theModel.addAttribute("cate", cate);
		return "admin/cate-form";
	}

	@PostMapping("/cate/save")
	private String editUser(@ModelAttribute("cate") @Validated DanhMuc cate, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/cate-form";
		} else {
			danhMucService.saveDanhMuc(cate);
			return "redirect:/admin/cate/list";
		}

	}

	@GetMapping("/cate/delete")
	private String deleteUser(@RequestParam("cateId") int id) {
		danhMucService.deleteDanhMuc(id);
		return "redirect:/admin/cate/list";
	}
}
