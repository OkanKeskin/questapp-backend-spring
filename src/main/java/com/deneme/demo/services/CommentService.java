package com.deneme.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.deneme.demo.entities.Comment;
import com.deneme.demo.entities.Post;
import com.deneme.demo.entities.User;
import com.deneme.demo.repos.CommentRepository;
import com.deneme.demo.request.CommentCreateRequest;
import com.deneme.demo.request.CommentUpdateRequest;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private PostService postService;
	private UserService userService;

	public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
		this.commentRepository = commentRepository;
		this.postService = postService;
		this.userService = userService;
	}

	public List<Comment> getAllCommentsWithParams(Optional<Long> postId, Optional<Long> userId) {
		if(postId.isPresent() && userId.isPresent())
			return commentRepository.findAllByPostIdAndUserId(postId,userId);
		else if(postId.isPresent())
			return commentRepository.findAllByPostId(postId);
		else if(userId.isPresent())
			return commentRepository.findAllByUserId(userId);
		else
			return commentRepository.findAll();
	}

	public Comment getOneCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest newCommentRequest) {
		Post post = postService.getOnePostById(newCommentRequest.getPostId());
		User user = userService.getOneUser(newCommentRequest.getUserId());
		if(user == null || post == null) {
			return null;
		}
		Comment newComment = new Comment();
		newComment.setPost(post);
		newComment.setUser(user);
		newComment.setText(newCommentRequest.getText());
		
		return commentRepository.save(newComment);
	}

	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest updateCommentRequest) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()){
			Comment updateComment = comment.get();
			updateComment.setText(updateCommentRequest.getText());
			commentRepository.save(updateComment);
			return updateComment;
		}
		return null;
	}

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
	}
	
}
