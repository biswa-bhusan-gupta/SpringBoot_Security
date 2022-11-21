package com.app.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Public")
public class HomeController {

	@GetMapping("/Home")
	public String Home(){
		return "This is Home Controller";
	}	
	
	@GetMapping("/Register")
	public String Register(){
		return "This is Register Page";
	}	
	
}
