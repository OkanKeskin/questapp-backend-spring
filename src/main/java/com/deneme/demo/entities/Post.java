package com.deneme.demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Post objesini çektiğimde hemen user objesini bana getirmene gerek yok = FetchType.LAZY
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable=false)
	//Bir user silindiğinde tüm postlarını sil demek
	@OnDelete(action = OnDeleteAction.CASCADE)
	//Serizilationda sıkıntı çıkarılmasın diye/ Bu alanla işimiz yok
	@JsonIgnore
	User user;
	
	private String title;
	
	@Lob
	@Column(columnDefinition = "text")
	private String text;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
