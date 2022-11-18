package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Choice;
import com.example.repository.ChoiceRepository;

@Service
public class ChoiceService implements ChoiceRepository{

	@Autowired
	ChoiceRepository choiceRepository;

	@Override
	public List<Choice> findByQuestionId(long questionId) {
		return choiceRepository.findByQuestionId(questionId);
	}


	@Override
	public int findByChoice(String choice) {
		return choiceRepository.findByChoice(choice);
	}

	@Override
	public <S extends Choice> S save(S entity) {
		return choiceRepository.save(entity);
	}

	public Choice findCorrectChoice(long questionId) {
		List<Choice> choiceList = choiceRepository.findByQuestionId(questionId);
		for (Choice c : choiceList) {
			if (c.isCorrect()) return c;
		}
		System.out.println("Question is missing correct choice");
		return null;
	}

	@Override
	public Choice findById(long id) {
		return choiceRepository.findById(id);
	}

	@Override
	public Optional<Choice> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Choice> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Choice> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Choice> findAllById(Iterable<Long> ids) {
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
	public void delete(Choice entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Choice> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}
}
