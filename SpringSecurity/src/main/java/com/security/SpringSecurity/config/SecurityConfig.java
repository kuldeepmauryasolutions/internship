package com.security.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {//WebSecurityConfigurerAdapter
	
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails normalUser=User.withUsername("Kuldeep")
				.password(passwordEncoder().encode("Password"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUser=User.withUsername("Kuldeep1")
				.password(passwordEncoder().encode("Password"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager (normalUser,adminUser);
					
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf->csrf.disable()).build();
//			.authorizeHttpRequests().requestMatchers("/ss/public")
//			.permitAll()
//			.anyRequest()
//			.authenticated();
//			.and()
//			.formLogin();
//		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		return http.build();
//	}
	
}
