package com.solutions.TaskManagementSystem.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.TaskManagementSystem.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByUsername(String username);

}
