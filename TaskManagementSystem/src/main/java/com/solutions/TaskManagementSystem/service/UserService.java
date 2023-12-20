package com.solutions.TaskManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.solutions.TaskManagementSystem.entity.UserInfo;
import com.solutions.TaskManagementSystem.repo.UserInfoRepo;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	public String createUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepo.save(userInfo);
		return userInfo.getUsername()+" Added to the system.";
	}
	
}
