package com.studentdbms.service;

import com.studentdbms.entity.Student;
import com.studentdbms.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public boolean saveStudent(Student student) {
        Student savedStudent =studentRepo.save(student);
        return savedStudent != null;
    }

    public boolean updateStudentNameById(int id, String name) {
        Student student = this.studentRepo.findById(id).orElse(null);
        if (student != null) {
            student.setName(name);
            this.studentRepo.save(student);
            return true;
        }
        return false;
    }

    public boolean deleteStudentById(int id) {
        Student student =studentRepo.findById(id).orElse(null);
        if (student != null) {
            studentRepo.delete(student);
            return true;
        }
        return false;
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public String getStudentNameById(int id) {
        return this.studentRepo.findById(id).map(Student::getName).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
