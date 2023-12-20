package com.quiz.services;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import com.quiz.entites.Quiz;

public interface QuizService {

	Quiz add(Quiz quiz);
	Quiz get(long id);
	List<Quiz> get();
}
