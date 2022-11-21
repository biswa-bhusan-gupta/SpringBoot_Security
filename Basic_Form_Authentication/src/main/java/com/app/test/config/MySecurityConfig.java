package com.app.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.test.services.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailService serv;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http 
		      .csrf().disable()
		      .authorizeRequests() // Authorize(Access) any request but should be authenticated first
		      
//		      .antMatchers("/Home","/Register").permitAll()
//		      .antMatchers("/Home","/Public/**").permitAll()
	          .antMatchers("/Home","/Public/**").hasRole("NORMAL")
		      .antMatchers("/Home","/Users/**").hasRole("ADMIN")
		      
		      .antMatchers("/Home","/Login").permitAll()

		      
		      .anyRequest() // Authorize any request
		      .authenticated() // Should be Authenticated(Permission) first
		      .and()
//		      .httpBasic(); // Mechanism is Basic Authenticated
		      
		      
		      .formLogin()
		      .loginPage("/Login")
		      .loginProcessingUrl("/getLogin")
		      .defaultSuccessUrl("/Users/");
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//   auth.inMemoryAuthentication().withUser("Biswa").password("XYZ").roles("NORMAL"); // InMemory -> Temporary Memory
//	 auth.inMemoryAuthentication().withUser("Biswa").password(this.passwordEncoder().encode("XYZ")).roles("NORMAL"); // Normal -> Read Only
//	 auth.inMemoryAuthentication().withUser("Yash").password(this.passwordEncoder().encode("XYZ")).roles("ADMIN"); // Admin -> Read,Write and Update

	 auth.userDetailsService(serv).passwordEncoder(passwordEncoder());
		
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(10);
//	}
//	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
 
}
