package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Choice;

@Repository
public interface ChoiceRepository extends CrudRepository<Choice, Long>{
	List<Choice> findByQuestionId(long questionId);
	Choice findById(long id);
	int findByChoice(String choice);
	
}
