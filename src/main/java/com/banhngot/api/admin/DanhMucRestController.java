package com.banhngot.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.DanhMuc;
import com.banhngot.service.DanhMucService;

@RestController(value = "danhMucRestControllerOfAdmin")
@RequestMapping("/admin/cate/api")
public class DanhMucRestController {
	@Autowired
	private DanhMucService  danhMucService;
	

	@GetMapping("/cates")
	public List<DanhMuc> getListDanhMucTheoTen(@RequestParam("tenDanhMuc") String tenDanhMuc){
		return danhMucService.getListTheoTen(tenDanhMuc);
	}
	
	@GetMapping("/cates/{id}")
	public DanhMuc getDanhMuc(@PathVariable int id){
		return danhMucService.getDanhMuc(id);
	}
	
	@DeleteMapping("/cates/{id}")
	public void xoaDanhMuc(@PathVariable int id) {
		danhMucService.deleteDanhMuc(id);
	}
	
}
