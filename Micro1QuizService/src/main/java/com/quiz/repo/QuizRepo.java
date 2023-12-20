package com.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.entites.Quiz;
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{

}
