package edu.cibertec.pe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	@Column(unique=true)
	private String email;
	private String password;
	
	public User() {}
	public User(Long id) 
	{
		this.id=id;
	}
	
	
}
