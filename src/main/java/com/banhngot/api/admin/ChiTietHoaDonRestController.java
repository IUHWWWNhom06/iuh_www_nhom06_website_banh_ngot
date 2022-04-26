package com.banhngot.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.ChiTietHoaDon;
import com.banhngot.service.ChiTietHoaDonService;

@RestController(value = "ChiTietHoaDonRestControllerOfAdmin")
@RequestMapping("/admin/order/api")
public class ChiTietHoaDonRestController {
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@GetMapping("/orderdetails")
	public List<ChiTietHoaDon> getAllHoaDon(){
		return chiTietHoaDonService.getAllChiTietHoaDon();
	}
	@GetMapping("/orderdetails/{id}")
	public List<ChiTietHoaDon> getHoaDon(@PathVariable int id){
		return chiTietHoaDonService.getChiTietHoaDon(id);
	}
}
