package com.banhngot.controller.user;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@ControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(NoHandlerFoundException.class)
	public String exceptionHandler(Exception exception) {
		return "exception";
	}

	@ExceptionHandler(IOException.class)
	public String ioExceptionHandler(IOException e,Model model) {
		model.addAttribute("error",e.getMessage());
		return "exception";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String inHandler(NumberFormatException e,Model model) {
		model.addAttribute("error",e.getMessage());
		return "exception";
	}
}
