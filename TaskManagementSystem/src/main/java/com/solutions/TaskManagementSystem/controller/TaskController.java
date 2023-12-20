package com.solutions.TaskManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.TaskManagementSystem.entity.Priority;
import com.solutions.TaskManagementSystem.entity.Status;
import com.solutions.TaskManagementSystem.entity.Task;
import com.solutions.TaskManagementSystem.exception.InvalidTaskException;
import com.solutions.TaskManagementSystem.service.TaskService;
import com.solutions.TaskManagementSystem.validation.Validation;

@EnableAutoConfiguration 
@RestController
@RequestMapping("/tms")
public class TaskController {
	private final TaskService taskService;	
	
	private final Validation validation;
	
	@Autowired
	public TaskController(TaskService taskService, Validation validation) {
		super();
		this.taskService = taskService;
		this.validation = validation;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/createTask")
	Task createTask(@RequestBody Task task)  {
		if(validation.validateTask(task)) {
		return taskService.createTask(task);
		}
		else throw new InvalidTaskException();
	}
	
	@PutMapping("/updateStatus/{id}")
	Task updateTaskStatus(@PathVariable int id,@RequestParam("status") Status status) {		
		return taskService.updateTaskStatus(id, status);
	}
	
	@DeleteMapping("/delete/{id}")
	boolean deleteTask(@PathVariable int id) {
		return taskService.deleteTask(id);	
	}
	
	@GetMapping("/getTask/{id}")
	Task getTask(@PathVariable int id) {
		return taskService.getTask(id);
	}
	
	@GetMapping("/getAllTask")
	List<Task> getAllTask(){
		System.out.println("Working Get all task");
		return taskService.getAllTask();
	}
	
	@PutMapping("/updatePriority/{id}")
	Task updateTaskPriority(@PathVariable int id,@RequestParam("priority") Priority priority) {
		return taskService.updateTaskPriority(id, priority);
	}
	
	@PutMapping("/updateAssignedto/{id}")
	Task updateTaskAssignedTo(@PathVariable int id,@RequestParam("assignedTo") String assigned_to) {
		return taskService.updateTaskAssignedTo(id, assigned_to);
	}
}
