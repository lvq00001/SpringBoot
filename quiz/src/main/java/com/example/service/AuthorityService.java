package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Authority;
import com.example.repository.AuthorityRepository;

@Service
public class AuthorityService {
	@Autowired
	AuthorityRepository authorityRepository;
	
	public void save(Authority auth) {
		authorityRepository.save(auth);
	}
}
