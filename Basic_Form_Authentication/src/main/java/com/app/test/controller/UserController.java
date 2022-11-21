package com.app.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.test.entities.User;
import com.app.test.services.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {
	
   @Autowired
   UserService serv;
   
   @GetMapping("/")
   public List<User> getUsers(){
	   return this.serv.getAllUsers();
   }
   
   
//   @PreAuthorize("hasRole('NORMAL')")
   @GetMapping("/{Username}")
   public User getUser(@PathVariable("Username") String username) {
	   return this.serv.getUser(username);
   }
   
   @PostMapping("/")
   public User setUser(@RequestBody User user) {
	   this.serv.setUser(user);
	   return user;
   }
}