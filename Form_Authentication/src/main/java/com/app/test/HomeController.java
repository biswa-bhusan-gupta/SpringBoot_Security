package com.app.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@RequestMapping("/HomePage")
	public String Home() {
		return "home.jsp";
	}
	
	@RequestMapping("/LoginPage")
	public String signIn() {
		return "login.jsp";
	}
	
	@RequestMapping("/LogoutPage")
	public String Logout() {
		return "logout.jsp";
	}
}
