package com.solutions.TaskManagementSystem.validation;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import com.solutions.TaskManagementSystem.entity.Task;

@Component
public class Validation {
	
	private boolean validateDate(Date date1,Date date2) {
		if(date1.before(date2)) {
			return true;
		}
		System.out.println("validateDate  false");
		return false;
	}
	private boolean validateTaskName(String name) {
        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$"; 
        Pattern p = Pattern.compile(regex);  
        if (name == null) { 
            return false; 
        } 
        Matcher m = p.matcher(name); 
        return m.matches();
	}
	private boolean validateTaskAssignedTo(String name) {
        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$"; 
        Pattern p = Pattern.compile(regex); 
        if (name == null) { 
            return false; 
        } 
        Matcher m = p.matcher(name); 
        return m.matches();
	}
	public boolean validateTask(Task task) {
		if(validateDate(task.getStart_date(),task.getEnd_date()) && validateTaskName(task.getTask_name()) && validateTaskAssignedTo(task.getAssigned_to())) {
			return true;
		}
		else {
			System.out.println("Task name :  "+validateTaskName(task.getTask_name()));
			System.out.println("Assigned to name :  "+validateTaskAssignedTo(task.getAssigned_to()));

		}
		return true;
	}
	
}
