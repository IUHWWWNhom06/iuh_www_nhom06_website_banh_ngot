package com.banhngot.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banhngot.entity.BinhLuan;
import com.banhngot.service.BinhLuanService;

@Controller(value = "BinhLuanControllerrOfAdmin")
@RequestMapping("/admin")
public class BinhLuanController {
	@Autowired
	private BinhLuanService binhLuanService;

	@GetMapping("/comment/list")
	private String getListThuongHieu(Model thModel) {
		List<BinhLuan> comments = binhLuanService.getListBinhLuan();
		thModel.addAttribute("comments", comments);
		return "admin/comment";
	}

	@GetMapping("/comment/delete")
	private String delete(@RequestParam("commentId") int id) {
		binhLuanService.xoaBinhLuan(id);
		return "redirect:/admin/comment/list";
	}

}
