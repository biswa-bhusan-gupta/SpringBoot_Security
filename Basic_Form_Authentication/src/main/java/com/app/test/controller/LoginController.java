package com.app.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
  
	@GetMapping("/Login")
	public String Login() {
		return "login.jsp";
	}
}
