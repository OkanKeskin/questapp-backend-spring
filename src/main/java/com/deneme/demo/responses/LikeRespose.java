package com.deneme.demo.responses;

import com.deneme.demo.entities.Like;

import lombok.Data;

@Data
public class LikeRespose {
	private Long id;
	private Long postId;
	private Long userId;
	
	public LikeRespose(Like entity) {
		this.id = entity.getId();
		this.postId = entity.getPost().getId();
		this.userId = entity.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
