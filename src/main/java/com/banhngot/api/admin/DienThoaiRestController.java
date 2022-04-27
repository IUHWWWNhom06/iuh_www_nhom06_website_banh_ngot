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

import com.banhngot.entity.Product;
import com.banhngot.service.ProductService;

@RestController(value = "dienThoaiRestControllerOfAdmin")
@RequestMapping("/admin/product/api")
public class DienThoaiRestController {
	@Autowired
	private ProductService dienThoaiService;

//	@GetMapping("/product")
//	public List<Product> getDienThoais() {
//		return dienThoaiService.getDienTHoaiBanChay();
//	}

	@GetMapping("/products/{id}")
	public Product getDienThoai(@PathVariable int id) {
		return dienThoaiService.getDienThoai(id);
	}

//	@GetMapping("/products")
//	public List<Product> getListTheoTen(@RequestParam("tenDT") String tenDT) {
//		return dienThoaiService.getListTheoTen(tenDT);
//	}

	@PostMapping("/products")
	public Product themDienThoai(@RequestBody Product dienThoai) {
		dienThoai.setId(0);
		dienThoaiService.saveDienThoai(dienThoai);
		return dienThoai;
	}

	@PutMapping("/products")
	public Product suaDienThoai(@RequestBody Product dienThoai) {
		dienThoaiService.saveDienThoai(dienThoai);
		return dienThoai;
	}

	@DeleteMapping("/products/{id}")
	public void xoaDienThoai(@PathVariable int id) {
		dienThoaiService.deleteDienThoai(id);
	}

}
