package com.banhngot.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value ="AccessDeniedController" )
public class AccessDeniedController {

	@RequestMapping(value = "/access-denied")
	public String denied() {
		return "access-denied";
	}
}
