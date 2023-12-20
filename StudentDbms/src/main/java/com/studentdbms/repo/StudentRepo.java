package com.studentdbms.repo;

import java.util.List;

import com.studentdbms.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
	public List<Student> findAll();
}
