package com.mingi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
	private String firstname;
	  
	private String lastname;
	
	private int age;
	
	private boolean active;
	 
	public Boolean getActive() {
		return null;
	}

	

	private String email;

	private LocalDateTime creationDate;

	public User(String firstname2, String lastname2, Integer integer, Boolean boolean1) {
		// TODO Auto-generated constructor stub
	}

	public void setStatus(String status) {
		// TODO Auto-generated method stub
		
	}  
	
}
