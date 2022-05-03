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

import com.banhngot.entity.TypeProduct;
import com.banhngot.entity.Product;
import com.banhngot.service.TypeProductService;
import com.banhngot.service.ProductService;

@Controller(value = "danhMucControllerOfAdmin")
@RequestMapping("/admin")
public class DanhMucController {
	@Autowired
	private TypeProductService danhMucService;

	@Autowired
	private ProductService productService;

	@GetMapping("/cate/list")
	private String getListDanhMuc(Model thModel) {
		List<TypeProduct> cates = danhMucService.getListDanhMuc();
		List<Product> dts = productService.getListProduct();
		thModel.addAttribute("cates", cates);
		thModel.addAttribute("dts", dts);
		return "admin/cate";
	}

	@GetMapping("/cate/showFormEdit")
	private String showFormEditUser(@RequestParam("cateId") int id, Model theModel) {
		TypeProduct cate = danhMucService.getDanhMuc(id);
		theModel.addAttribute("cate", cate);
		return "admin/cate-form";
	}

	@GetMapping("/cate/showFormAdd")
	private String showFormAddUser(Model theModel) {
		TypeProduct cate = new TypeProduct();
		theModel.addAttribute("cate", cate);
		return "admin/cate-form";
	}

	@PostMapping("/cate/save")
	private String editUser(@ModelAttribute("cate") @Validated TypeProduct cate, BindingResult result) {
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
