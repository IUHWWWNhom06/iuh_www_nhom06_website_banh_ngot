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
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.ThongSo;
import com.banhngot.service.ThongSoService;

@RestController(value = "thongSoRestControllerOfAdmin")
@RequestMapping("/admin/product/api")
public class ThongSoRestController { 
	@Autowired
	private ThongSoService thongSoService;
	
	@GetMapping("/details")
	public List<ThongSo> getDienThoais(){
		return thongSoService.getListThongSo();
	}
	
	@GetMapping("/details/{id}")
	public ThongSo getThongSo(@PathVariable int id){
		return thongSoService.getThongSo(id);
	}
	
	@PostMapping("/details")
	public ThongSo themThongSo(@RequestBody ThongSo thongSo) {
		thongSoService.saveThongSo(thongSo);
		return thongSo;
	}
	
	@PutMapping("/details")
	public ThongSo suaThongSo(@RequestBody ThongSo thongSo) {
		thongSoService.saveThongSo(thongSo);
		return thongSo;
	}
	
	@DeleteMapping("/details/{id}")
	public void xoaThongSo(@PathVariable int id) {
		thongSoService.deleteThongSo(id);
	}
	
}
