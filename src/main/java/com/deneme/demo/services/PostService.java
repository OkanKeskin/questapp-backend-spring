package com.deneme.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.deneme.demo.entities.Post;
import com.deneme.demo.entities.User;
import com.deneme.demo.repos.PostRepository;
import com.deneme.demo.request.PostCreateRequest;
import com.deneme.demo.request.PostUpdateRequest;
import com.deneme.demo.responses.PostResponse;

@Service
public class PostService {
	private PostRepository postRepository;
	private UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		if(userId.isPresent()) {
			list =  postRepository.findByUserId(userId.get());
		}
		else {
			list =  postRepository.findAll();
		}
		return list.stream().map(p -> new PostResponse(p)).collect(Collectors.toList());
		
	}

	public Post getOnePostById(Long postId) {
		return  postRepository.findById(postId).orElse(null);
		//return new PostResponse(entity);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userService.getOneUser(newPostRequest.getUserId());
		if(user == null)
				return null;
		
		Post toSave = new Post();
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		System.out.println("Yeni bir Post Eklendi");
		return postRepository.save(toSave);
	}
	
	public Post updateOnePostById(Long postId, PostUpdateRequest updatePostRequest) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePostRequest.getText());
			toUpdate.setTitle(updatePostRequest.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
		
		
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}
}
