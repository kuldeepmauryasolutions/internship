package com.solutions.JWTSecurityDbUser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import com.solutions.JWTSecurityDbUser.security.JwtAuthenticationEntryPoint;
import com.solutions.JWTSecurityDbUser.security.JwtAuthenticationFilter;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class SecurityConfig {
	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;
	@Autowired
	private JwtAuthenticationFilter filter;
	@Autowired
	private UserDetailsService userDetailsService;//customUserDetailsService
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").authenticated()
					.requestMatchers("/auth/login").permitAll()
					.requestMatchers("/auth/createUser").permitAll()
					.anyRequest().authenticated())
					.exceptionHandling(ex -> ex.authenticationEntryPoint(entryPoint))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider1=new DaoAuthenticationProvider();
		daoAuthenticationProvider1.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider1.setPasswordEncoder(passwordEncoder);
		return daoAuthenticationProvider1;
	}
}
