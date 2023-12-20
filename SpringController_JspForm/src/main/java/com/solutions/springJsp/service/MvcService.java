package com.solutions.springJsp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solutions.springJsp.entity.User;
import com.solutions.springJsp.repo.UserRepo;

@Service
public class MvcService {
	
	@Autowired
	private UserRepo userRepo;

	public User registerUser(User user) {
		userRepo.save(user);
		return user;
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public static MvcService getService() {
		return new MvcService();
	}
}
