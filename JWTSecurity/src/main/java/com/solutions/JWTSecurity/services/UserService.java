package com.solutions.JWTSecurity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.solutions.JWTSecurity.models.User;


@Service
public class UserService {
	
	private List<User> store=new ArrayList<User>();
	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"Kuldeep","kuldep@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Anoop","anoop@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Shubham","shubham@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Aman","aman@gmail.com"));
	}
	public List<User> getUsers(){
		return store;
	}
}
