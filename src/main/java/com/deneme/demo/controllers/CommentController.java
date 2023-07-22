package com.deneme.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deneme.demo.entities.Comment;
import com.deneme.demo.request.CommentCreateRequest;
import com.deneme.demo.request.CommentUpdateRequest;
import com.deneme.demo.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	// - /comments - /comments?postId={} - /comments?userId={} - /comments?postId={}&userId={}
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> postId, @RequestParam Optional<Long> userId){
		return commentService.getAllCommentsWithParams(postId,userId);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneCommentById(@PathVariable Long commentId) {
		return commentService.getOneCommentById(commentId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest newCommentRequest) {
		return commentService.createOneComment(newCommentRequest);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneCommentById(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateCommentRequest) {
		return commentService.updateOneCommentById(commentId,updateCommentRequest);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteOneCommentById(@PathVariable Long commentId) {
		commentService.deleteOneCommentById(commentId);
	}
	
	
}
