package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.domain.Question;
import com.example.repository.QuestionRepository;

@Service
public class QuestionService implements QuestionRepository{
	@Autowired
	QuestionRepository questionRepository;
	
	public Page<Question> findAll(int pageNum) {
		int pageSize = 5;
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id"));
	    return questionRepository.findAll(pageable);
	}
	
	public List<Question> findAll() {
		List<Question> list = new ArrayList<>();
		Iterable<Question> iterable = questionRepository.findAll();
		for (Question i : iterable) {
			list.add(i);
		}
		return list;
	}
	
	public Question findById(long id) {
		return questionRepository.findById(id);
	}
	
	@Override
	public <S extends Question> S save(S entity) {
		return questionRepository.save(entity);
	}
	
	public void delete(int id) {
		Question q = questionRepository.findById(id);
		questionRepository.delete(q);
	}

	@Override
	public Iterable<Question> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Question> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Question> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Question> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Question> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Question entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Question> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findByTitle(String title) {
		// TODO Auto-generated method stub
		return 0;
	}
 }
