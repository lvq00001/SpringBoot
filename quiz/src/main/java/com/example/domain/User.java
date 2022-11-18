package com.example.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Username must not null")
	private String username;
	
	@Size(min=6, message="Password must have at least 6 characters")
	private String userPassword;
	//private String authority;
	private boolean enabled = true;

	
	public User() {
		super();
	}


	public User(String username, String userPassword) {
		super();
		this.username = username;
		this.userPassword = userPassword;
		//this.authority = authority;
	}
	

//	public String getUserRole() {
//		return authority;
//	}
//	public void setUserRole(String authority) {
//		this.authority = authority;
//	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userPassword=" + userPassword + ", enabled=" + enabled + "]";
	}

	
	
}
