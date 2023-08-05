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

import com.deneme.demo.entities.Post;
import com.deneme.demo.request.PostCreateRequest;
import com.deneme.demo.request.PostUpdateRequest;
import com.deneme.demo.responses.PostResponse;
import com.deneme.demo.services.PostService;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) //CORS hatasını react projesine açtık
@RestController
@RequestMapping("/posts")
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	//Optional parametre gelede bilir gelmeyede bilir = /posts?userId={userId} || /posts
	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePostRequest) {
		return postService.updateOnePostById(postId,updatePostRequest);
		
	}
	 
	@DeleteMapping("/{postId}")
	public void deleteOnePostById(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);
	}
}
