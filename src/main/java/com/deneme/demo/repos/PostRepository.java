package com.deneme.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deneme.demo.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	//findBy kalıp UserId kısmını JPA Bize sağlıyor
	List<Post> findByUserId(Long userId);

}
