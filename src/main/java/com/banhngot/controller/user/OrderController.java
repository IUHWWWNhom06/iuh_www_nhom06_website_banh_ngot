package com.banhngot.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banhngot.entity.Order;
import com.banhngot.service.OrderService;

@Controller(value = "cartControllerOfUser")
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the service
		List<Order> cakes = orderService.getListOrder();
		// add the customers to the model
		theModel.addAttribute("cakes", cakes);
		return "listCake";
	}
}
