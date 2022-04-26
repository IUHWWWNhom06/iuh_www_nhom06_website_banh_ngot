package com.banhngot.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banhngot.entity.NguoiDung;
import com.banhngot.service.NguoiDungService;

@RestController(value = "NguoiDungAdminRestControllerOfAdmin")
@RequestMapping("/admin/admin/api")
public class NguoiDungAdminRestController {
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@GetMapping("/users/{id}")
	public NguoiDung getNguoiDungs(@PathVariable int id){
		return nguoiDungService.getNguoiDung(id);
	}
}
