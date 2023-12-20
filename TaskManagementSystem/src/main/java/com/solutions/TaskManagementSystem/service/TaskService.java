package com.solutions.TaskManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.solutions.TaskManagementSystem.entity.*;

@Service
public interface TaskService {	
	Task createTask(Task task);
	Task updateTaskStatus(int id,Status status);
	boolean deleteTask(int id);
	Task getTask(int id);
	List<Task> getAllTask();
	Task updateTaskPriority(int id,Priority priority);
	Task updateTaskAssignedTo(int id,String assigned_to);
}
