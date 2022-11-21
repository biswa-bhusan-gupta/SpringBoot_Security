package com.app.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.test.entities.User;

@Service
public class UserService {
	
     List<User> list = new ArrayList<>();

	 public UserService() {
		list.add(new User("Biswa","XYZ","Biswa@gmail.com"));
		list.add(new User("Yash","ABC","Yash@gmail.com"));
	 }
	 
	 // For All Users :
	 public List<User> getAllUsers(){
		 return this.list;
	 }
	 
	 // For Single User :
	 public User getUser(String username) {
		 return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	 }
	 
	 // Add User :
	 public User setUser(User user) {
		 list.add(user);
		 return user;
	 }
     
}
