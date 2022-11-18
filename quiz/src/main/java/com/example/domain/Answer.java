package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long answerId;
	
	private long questionId;
	
	private long choiceId;
	
	private boolean isCorrect;

	public Answer(long answerId, long questionId, long choiceId, boolean isCorrect) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.choiceId = choiceId;
		this.isCorrect = isCorrect;
	}

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(long choiceId) {
		this.choiceId = choiceId;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	
}
