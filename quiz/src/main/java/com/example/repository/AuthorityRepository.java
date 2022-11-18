package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long>{
	
}
