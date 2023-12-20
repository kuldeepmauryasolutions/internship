package com.solutions.JWTSecurityDbUser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.solutions.JWTSecurityDbUser.models.CustomUserDetails;
import com.solutions.JWTSecurityDbUser.repository.UserRepository;

@Service 
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("CustomUserDetailService class "+email);
		CustomUserDetails userDetails= userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User Not Found"));
		return userDetails;
	}

}
