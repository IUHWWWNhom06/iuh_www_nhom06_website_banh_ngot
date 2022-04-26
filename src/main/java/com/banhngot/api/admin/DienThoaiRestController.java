package com.banhngot.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.DienThoai;
import com.banhngot.service.DienThoaiService;

@RestController(value = "dienThoaiRestControllerOfAdmin")
@RequestMapping("/admin/product/api")
public class DienThoaiRestController {
	@Autowired
	private DienThoaiService dienThoaiService;

	@GetMapping("/product")
	public List<DienThoai> getDienThoais() {
		return dienThoaiService.getDienTHoaiBanChay();
	}

	@GetMapping("/products/{id}")
	public DienThoai getDienThoai(@PathVariable int id) {
		return dienThoaiService.getDienThoai(id);
	}

	@GetMapping("/products")
	public List<DienThoai> getListTheoTen(@RequestParam("tenDT") String tenDT) {
		return dienThoaiService.getListTheoTen(tenDT);
	}

	@PostMapping("/products")
	public DienThoai themDienThoai(@RequestBody DienThoai dienThoai) {
		dienThoai.setId(0);
		dienThoaiService.saveDienThoai(dienThoai);
		return dienThoai;
	}

	@PutMapping("/products")
	public DienThoai suaDienThoai(@RequestBody DienThoai dienThoai) {
		dienThoaiService.saveDienThoai(dienThoai);
		return dienThoai;
	}

	@DeleteMapping("/products/{id}")
	public void xoaDienThoai(@PathVariable int id) {
		dienThoaiService.deleteDienThoai(id);
	}

}
