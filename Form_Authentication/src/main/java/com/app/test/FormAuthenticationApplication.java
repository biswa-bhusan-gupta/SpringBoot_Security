package com.app.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FormAuthenticationApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bpassEnc;

	public static void main(String[] args) {
		SpringApplication.run(FormAuthenticationApplication.class, args);
	}
	    @Override
		public void run(String... args) throws Exception {
			
			User user1 = new User();
			user1.setId(1);
			user1.setUsername("Biswa");
			user1.setPassword(this.bpassEnc.encode("XYZ"));
			this.repo.save(user1);
			
			
			User user2 = new User();
		    user2.setId(2);
			user2.setUsername("Yash");
			user2.setPassword(this.bpassEnc.encode("XYZ"));
			this.repo.save(user2);

		}

}
