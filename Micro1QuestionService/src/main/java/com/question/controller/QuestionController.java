package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	private QuestionService questionService;
	@Autowired
	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	@PostMapping(consumes = "*/*")
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
	}
	
	@GetMapping
	public List<Question> getAll(){
		return questionService.get();
	}
	
	@GetMapping("/{id}")
	public Question getOne(@PathVariable Long id) {
		return questionService.getOne(id);
	}
	
	@GetMapping("/quiz/{id}")
	public List<Question> getQuestionsByQuiz(@PathVariable Long id){
		return questionService.getQuestionByQuiz(id);
	}
}
