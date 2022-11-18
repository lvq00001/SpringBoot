package com.example.repository;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Question;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long>{
	Question findById(long id);
	int findByTitle(String title);
}
