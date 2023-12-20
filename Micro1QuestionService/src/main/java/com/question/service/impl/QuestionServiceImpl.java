package com.question.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repo.QuestionRepo;
import com.question.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{
	
	private QuestionRepo questionRepo;
	@Autowired	
	public QuestionServiceImpl(QuestionRepo questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}

	@Override
	public Question create(Question question) {
		return questionRepo.save(question);
	}

	@Override
	public List<Question> get() {
		return questionRepo.findAll();
	}

	@Override
	public Question getOne(Long id) {
		return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getQuestionByQuiz(Long id) {
		return questionRepo.findByQuizId(id);
	}

}
