package com.solutions.JWTSecurityDbUser.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.solutions.JWTSecurityDbUser.models.CustomUserDetails;
import com.solutions.JWTSecurityDbUser.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	//no need of UserService because now data will be fetched from database.
//	private List<CustomUserDetails> store=new ArrayList<CustomUserDetails>();
//		public UserService() {
//		store.add(new User(UUID.randomUUID().toString(),"Kuldeep","kuldep@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"Anoop","anoop@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"Shubham","shubham@gmail.com"));
//		store.add(new User(UUID.randomUUID().toString(),"Aman","aman@gmail.com"));
//	}
	public List<CustomUserDetails> getUsers(){
		return userRepository.findAll();
	}
	
	public CustomUserDetails createUser(CustomUserDetails user) {
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
