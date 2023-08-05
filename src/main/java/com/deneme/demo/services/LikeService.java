package com.deneme.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.deneme.demo.entities.Like;
import com.deneme.demo.entities.Post;
import com.deneme.demo.entities.User;
import com.deneme.demo.repos.LikeRepository;
import com.deneme.demo.request.LikeCreateRequest;
import com.deneme.demo.responses.LikeRespose;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.postService = postService;
		this.userService = userService;
	}

	public List<LikeRespose> getAllLikeWithParam(Optional<Long> userId, Optional<Long> postId) {
		List<Like> list;
		if(userId.isPresent() && postId.isPresent())
			list = likeRepository.findByUserIdAndPostId(userId,postId);
		else if(userId.isPresent())
			list = likeRepository.findByUserId(userId);
		else if(postId.isPresent())
			list = likeRepository.findByPostId(postId);
		else
			list = likeRepository.findAll();
		return list.stream().map(like -> new LikeRespose(like)).collect(Collectors.toList());
	}

	public Like getOneLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	public Like createOneLike(LikeCreateRequest likeCreateRequest) {
		User user = userService.getOneUser(likeCreateRequest.getUserId());
		Post post = postService.getOnePostById(likeCreateRequest.getPostId());
		
		if(user == null || post == null)
			return null;
		Like createLike = new Like();
		createLike.setPost(post);
		createLike.setUser(user);
		return likeRepository.save(createLike);
	}

	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
	}
	
	
}
