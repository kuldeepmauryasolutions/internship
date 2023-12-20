package com.security.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.SpringSecurity.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
