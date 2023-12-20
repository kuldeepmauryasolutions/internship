package com.solutions.JWTSecurityDbUser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.JWTSecurityDbUser.models.CustomUserDetails;

public interface UserRepository extends JpaRepository<CustomUserDetails, Integer> {
	public Optional<CustomUserDetails> findByEmail(String email);
}
