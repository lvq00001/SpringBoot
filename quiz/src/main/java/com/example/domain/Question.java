package com.example.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Choice> choice;
	
	public Set<Choice> getChoice() {
		return choice;
	}

	public void setChoice(Set<Choice> choice) {
		this.choice = choice;
	}

	public Question() {
		super();
	}

	public Question(String title) {
		super();
		this.title = title;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + "]";
	}
	
	
	
}
