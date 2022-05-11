package com.banhngot.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.entity.OrderDetail;
import com.banhngot.service.OrderDetailService;

@Controller(value = "orderDetailControllerOfUser")
@RequestMapping("a")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<OrderDetail> cakes = orderDetailService.getAllOrderDetail();

		theModel.addAttribute("cakes", cakes);
		return "listCake";
	}
}
