package com.deneme.demo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "likes")
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnor
	Post post;
	
	// Post objesini çektiğimde hemen user objesini bana getirmene gerek yok = FetchType.LAZY
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable=false)
	//Bir user silindiğinde tüm postlarını sil demek
	@OnDelete(action = OnDeleteAction.CASCADE)
	//Serizilationda sıkıntı çıkarılmasın diye/ Bu alanla işimiz yok
	//@JsonIgnore
	User user;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
