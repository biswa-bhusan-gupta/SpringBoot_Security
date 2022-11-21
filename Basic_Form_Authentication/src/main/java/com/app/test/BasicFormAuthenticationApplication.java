package com.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.test.entities.User;
import com.app.test.repo.UserRepository;

@SpringBootApplication
public class BasicFormAuthenticationApplication implements CommandLineRunner{

	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bpassEnc;

	public static void main(String[] args) {
		SpringApplication.run(BasicFormAuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();
		user1.setUsername("Biswa");
		user1.setPassword(this.bpassEnc.encode("XYZ"));
		user1.setEmail("Biswa@gmail.com");
		user1.setRole("ROLE_NORMAL");
		this.repo.save(user1);
		
		
		User user2 = new User();
		user2.setUsername("Yash");
		user2.setPassword(this.bpassEnc.encode("XYZ"));
		user2.setEmail("Yash@gmail.com");
		user2.setRole("ROLE_ADMIN");
		this.repo.save(user2);

	}

}
