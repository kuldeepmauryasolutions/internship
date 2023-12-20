package com.solutions.TaskManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.solutions.TaskManagementSystem.service.UserInfoService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	@Bean
//	public WebMvcConfigurer cors() {
//		return new WebMvcConfigurer() {
//		@Override
//		public void addCorsMappings(CorsRegistry registry) {
//			registry.addMapping("/**")
//			.allowedOrigins("http://localhost:8080")
//			.allowedHeaders(HttpHeaders.CONTENT_TYPE, "X-CSRF-TOKEN")
//			.allowedMethods(HttpMethod.GET.name(),HttpMethod.POST.name(),HttpMethod.PUT.name(),HttpMethod.DELETE.name())
//			.allowCredentials(true);
//		}
//		};
//	}

//	@Bean
//	public UserDetailsService userDetailService() {
//		UserDetails normalUser1=User.withUsername("Kuldeep")
//				.password(passwordEncoder().encode("Password1"))
//				.roles("USER")
//				.build();
//		
//		UserDetails normalUser2=User.withUsername("Dilshad")
//				.password(passwordEncoder().encode("Password2"))
//				.roles("USER")
//				.build();
//		
//		UserDetails adminUser=User.withUsername("Kuldeep1")
//				.password(passwordEncoder().encode("Password"))
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager (normalUser1,normalUser2,adminUser);				
//	}
	
	@Bean
	public UserDetailsService userDetailService() {
		return new UserInfoService();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/ums/createUser").permitAll()
			.and()
			.authorizeHttpRequests().requestMatchers("/tms/**")
			.authenticated().and().build();
	}
    
}