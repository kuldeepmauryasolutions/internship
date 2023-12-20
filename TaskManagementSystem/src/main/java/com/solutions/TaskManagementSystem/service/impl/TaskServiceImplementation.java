package com.solutions.TaskManagementSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.TaskManagementSystem.entity.Priority;
import com.solutions.TaskManagementSystem.entity.Status;
import com.solutions.TaskManagementSystem.entity.Task;
import com.solutions.TaskManagementSystem.repo.TaskRepository;
import com.solutions.TaskManagementSystem.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {
	
	private final TaskRepository taskRepository;
	@Autowired
	TaskServiceImplementation(TaskRepository taskRepository){
		this.taskRepository=taskRepository;
	}
	
	@Override
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public Task updateTaskStatus(int id, Status status) {
		Task taskToUpdate=taskRepository.findById(id).orElse(null);
		taskToUpdate.setStatus(status);
		return taskRepository.save(taskToUpdate);
	}
	
	@Override
	public boolean deleteTask(int id) {
		Task taskToDelete=taskRepository.findById(id).orElse(null);
		taskRepository.delete(taskToDelete);
		return taskToDelete!=null;
	}

	@Override
	public Task getTask(int id) {
		return taskRepository.findById(id).orElse(null);
	}

	@Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}

	@Override
	public Task updateTaskPriority(int id, Priority priority) {
		Task taskToUpdate=taskRepository.findById(id).orElse(null);
		taskToUpdate.setPriority(priority);
		return taskRepository.save(taskToUpdate);
	}

	@Override
	public Task updateTaskAssignedTo(int id, String assigned_to) {
		Task taskToUpdate=taskRepository.findById(id).orElse(null);
		taskToUpdate.setAssigned_to(assigned_to);
		return taskRepository.save(taskToUpdate);
	}
	
	

}
