package com.solutions.TaskManagementSystem.entity;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String task_name;
	Date start_date;	//yyyy-mm-dd
	Date end_date;
	String assigned_to;
	String task_details;
	@Autowired
	Status status;
	@Autowired
	Priority priority;
	
	public Task() {
		super();
	}
//
//	public Task(String task_name, Date start_date, Date end_date, String assigned_to, String task_details,
//			Status status, Priority priority) {
//		super();
//		this.task_name = task_name;
//		this.start_date = start_date;
//		this.end_date = end_date;
//		this.assigned_to = assigned_to;
//		this.task_details = task_details;
//		this.status = status;
//		this.priority = priority;
//	}

	
	public Task(int id, String task_name, Date start_date, Date end_date, String assigned_to, String task_details,
			Status status, Priority priority) {
		super();
		this.id = id;
		this.task_name = task_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.assigned_to = assigned_to;
		this.task_details = task_details;
		this.status = status;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}

	public String getTask_details() {
		return task_details;
	}

	public void setTask_details(String task_details) {
		this.task_details = task_details;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	
}
