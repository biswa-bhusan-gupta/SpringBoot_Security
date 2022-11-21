package com.app.test.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.test.entities.User;
import com.app.test.entities.UserDetail;
import com.app.test.repo.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.repo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No User");
		}
		
		UserDetail ud = new UserDetail(user);
		return ud;
	}

	
}