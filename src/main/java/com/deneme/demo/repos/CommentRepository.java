package com.deneme.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deneme.demo.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findAllByPostId(Optional<Long> postId);

	List<Comment> findAllByUserId(Optional<Long> userId);

	List<Comment> findAllByPostIdAndUserId(Optional<Long> postId, Optional<Long> userId);

}
