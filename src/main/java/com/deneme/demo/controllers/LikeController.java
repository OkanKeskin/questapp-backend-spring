package com.deneme.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deneme.demo.entities.Like;
import com.deneme.demo.request.LikeCreateRequest;
import com.deneme.demo.responses.LikeRespose;
import com.deneme.demo.services.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {
	
	private LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@GetMapping
	public List<LikeRespose> getAllLikeWithParam(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId ){
		return likeService.getAllLikeWithParam(userId,postId);
	}
	
	@GetMapping("/{likeId}")
	public Like getOneLikeById(@PathVariable Long likeId) {
		return likeService.getOneLikeById(likeId);
	}
	
	@PostMapping
	public Like createOneLike(@RequestBody LikeCreateRequest likeCreateRequest){ 
		return likeService.createOneLike(likeCreateRequest);
	}
	
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable Long likeId) {
		likeService.deleteOneLikeById(likeId);
	}
	
	
	
	
	
	
	
}
