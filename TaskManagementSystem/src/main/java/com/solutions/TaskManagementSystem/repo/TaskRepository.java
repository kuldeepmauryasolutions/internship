package com.solutions.TaskManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.TaskManagementSystem.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
