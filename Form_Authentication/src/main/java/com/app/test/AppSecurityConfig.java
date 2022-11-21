package com.app.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;



@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService uds;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
	      .csrf().disable()	
	      .authorizeRequests()
	      .antMatchers("/LoginPage").permitAll()
	      .and()
	      .formLogin()
	      .loginPage("/LoginPage").permitAll()
	      .loginProcessingUrl("/getLogin")
	      .defaultSuccessUrl("/HomePage")
	      .and()
	      .logout().invalidateHttpSession(true)
	      .clearAuthentication(true)
	      .logoutRequestMatcher(new AntPathRequestMatcher("/Logout"))
	      .logoutSuccessUrl("/LogoutPage").permitAll();
	      
	}
	
	
	
//	<------------------------------------------------------ For Database --------------------------------------------------->

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// i. Configuration Layer -> Service Layer -> Database Layer
		provider.setUserDetailsService(uds); // STEP 1 : Authentication Provider interacts with Service Layer,Service Layer connects with Database 
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return provider;
	}



//	<------------------------------------------------------ For MANUAL --------------------------------------------------->
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//	
//		List<UserDetails> user = new ArrayList<>();
//		user.add(User.withDefaultPasswordEncoder().username("Biswa").password("XYZ").roles("USER").build());
//		return new InMemoryUserDetailsManager(user);
//		
//	}

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
