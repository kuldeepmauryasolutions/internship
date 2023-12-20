package com.quiz.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entites.Quiz;
import com.quiz.repo.QuizRepo;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	private QuizRepo quizRepo;
	private QuestionClient questionClient;
	
	@Autowired
	public QuizServiceImpl(QuizRepo quizRepo, QuestionClient questionClient) {
		super();
		this.quizRepo = quizRepo;
		this.questionClient = questionClient;
	}
	
	@Override
	public Quiz add(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	public Quiz get(long id) {
		Quiz quiz=quizRepo.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found."));
		quiz.setQuestions(questionClient.getQuestionByQuiz(quiz.getId()));
		return quiz;
	}

	@Override
	public List<Quiz> get(){
		List<Quiz> quizzes=quizRepo.findAll();
		
		List<Quiz> newQuizList= quizzes.stream().map(quiz->{
			quiz.setQuestions(questionClient.getQuestionByQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizList;
	}

	

}
