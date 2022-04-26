package com.banhngot.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.DienThoai;
import com.banhngot.service.ThongKeService;

@RestController(value = "trangChuRestControllerOfAdmin")
@RequestMapping("/admin/api")
public class TrangChuRestController {
	@Autowired
	private ThongKeService thongKeService;

	@GetMapping("/products")
	public List<DienThoai> getDienThoaiBanChay() {
		return thongKeService.getListDienThoaiBanChay();
	}
}
