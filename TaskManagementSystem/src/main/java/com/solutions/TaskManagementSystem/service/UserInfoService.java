package com.solutions.TaskManagementSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.solutions.TaskManagementSystem.config.UserInfoUserDetails;
import com.solutions.TaskManagementSystem.entity.UserInfo;
import com.solutions.TaskManagementSystem.repo.UserInfoRepo;

@Component
public class UserInfoService implements UserDetailsService{

	private UserInfoRepo userRepo;
	@Autowired
	public UserInfoService(UserInfoRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}


	public UserInfoService() {
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo= userRepo.findByUsername(username);
		
		return userInfo.map(UserInfoUserDetails::new)
			.orElseThrow();
		
	}
	
	
}
