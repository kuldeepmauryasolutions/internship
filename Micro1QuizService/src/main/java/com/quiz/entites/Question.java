package com.quiz.entites;


public class Question {

	private long id;
	private long quizId;
	private String question;
	public Question() {
		super();
	}
	public Question(long id, long quizId, String question) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.question = question;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuizId() {
		return quizId;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
}
