package com.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.bean.Student;

@RestController
public class StudentController {
	//http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student(5,"Name","Email@g.com");
	}
	@GetMapping("/kuldeep")
	public String getKuldeep() {
		return "Hii I am Kuldeep";
	}
	
	//http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"Stu1","email1"));
		students.add(new Student(2,"Stu2","email2"));
		students.add(new Student(3,"Stu3","email3"));
		students.add(new Student(4,"Stu4","email4"));
		return students;
	}
	
	
	//handling path variable as a argument
	//http://localhost:8080/id/name/email
	@GetMapping("/{id}/{name}/{email}")
	//@PathVariable annotation is required
	public Student getStudent(@PathVariable int id,@PathVariable("name") String studName,@PathVariable String email) {
		return new Student(id,studName,email);
	}
	
	
	//create REST api to handle Query Paramenter ?
	//@RequestParam annotation is required
	//http://localhost:8080?id=1&name=Kuldeep&email=em@gm.com
	@GetMapping("/query")
	public Student getStudent1(@RequestParam(name="id") int id,@RequestParam(name="name")String name,@RequestParam(name="email")String email) {
		return new Student(id,name,email);
	}
}
