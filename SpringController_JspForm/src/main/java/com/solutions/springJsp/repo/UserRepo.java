package com.solutions.springJsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solutions.springJsp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
