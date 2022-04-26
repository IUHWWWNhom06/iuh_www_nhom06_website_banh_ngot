package com.banhngot.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banhngot.entity.DienThoai;
import com.banhngot.service.DienThoaiService;

@Controller(value = "chiTietDienThoaiControllerOfAdmin")
@RequestMapping("/admin")
public class ChiTietDienThoaiController {
	@Autowired
	private DienThoaiService dienThoaiService;

	@GetMapping("/product/product-detail")
	public String productDetail(@RequestParam("productId") int id, Model theModel) {
		DienThoai product = dienThoaiService.getDienThoai(id);
		theModel.addAttribute("product", product);
		return "admin/product-detail";
	}
}
