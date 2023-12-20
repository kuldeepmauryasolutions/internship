package com.security.SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.SpringSecurity.entity.User;
import com.security.SpringSecurity.repo.UserRepo;

@Service
public class UserService {
	private UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	public User createUser(User user) {
		return userRepo.save(user);
	}
	public User getUser(int id) {
		return userRepo.findById(id).orElse(null);
	}
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	public User updateUserName(int id,String name) {
		User updatedUser=userRepo.findById(id).orElse(null);
		updatedUser.setName(name);
		return userRepo.save(updatedUser);
	}
	public boolean deleteUser(int id) {
		User toDelete=userRepo.findById(id).orElse(null);
		userRepo.delete(toDelete);
		return toDelete!=null;
	}
}
