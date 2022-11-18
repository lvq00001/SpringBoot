package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	
}
