package com.deneme.demo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Data
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(Long id2) {
		this.id = id2;
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	public void setUserName(String userName2) {
		this.userName = userName2;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}


	public void setPassword(String password2) {
		this.password = password2;
		
	}
}
