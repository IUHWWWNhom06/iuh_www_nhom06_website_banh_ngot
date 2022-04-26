package com.banhngot.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.HoaDon;
import com.banhngot.service.HoaDonService;

@RestController(value = "HoaDonRestControllerOfAdmin")
@RequestMapping("/admin/order/api")
public class HoaDonRestController {
	@Autowired
	private HoaDonService hoaDonService;
	
	@GetMapping("/orders")
	public List<HoaDon> getHoaDons(){
		return hoaDonService.getListHoaDon();
	}
}
