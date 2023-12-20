package com.solutions.JWTSecurityDbUser.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.JWTSecurityDbUser.models.CustomUserDetails;
import com.solutions.JWTSecurityDbUser.models.JwtRequest;
import com.solutions.JWTSecurityDbUser.models.JwtResponse;
import com.solutions.JWTSecurityDbUser.security.JwtHelper;
import com.solutions.JWTSecurityDbUser.services.CustomUserDetailService;
import com.solutions.JWTSecurityDbUser.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private CustomUserDetailService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtHelper helper;
	
	private Logger logger=LoggerFactory.getLogger(AuthController.class);
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest request) {
		
        //this.doAuthenticate(request.getEmail(), request.getPassword());
        
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
        	throw new BadCredentialsException(" Invalid Username or Password  !!");
        	//return new ResponseEntity<>("Unauthorize", HttpStatus.UNAUTHORIZED);		
        }
        String token = helper.generateToken(userDetails);
        
//        JwtResponse response = JwtResponse.builder()
//                .jwtToken(token)
//                .username(userDetails.getUsername()).build();
        JwtResponse response=new JwtResponse(token,userDetails.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
    	String encodedPassword = passwordEncoder.encode(password);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, encodedPassword);
        try {
        	System.out.println("email: "+email );
        	System.out.println("password: "+password );
        	System.out.println(authentication);
            manager.authenticate(authentication);
            
            System.out.println("doAunthenticate method.");
            
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
    
    @PostMapping("/createUser")
    public CustomUserDetails createUser(@RequestBody CustomUserDetails user) {
    	return userService.createUser(user);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
