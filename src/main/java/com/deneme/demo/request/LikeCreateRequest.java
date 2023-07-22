package com.deneme.demo.request;

import lombok.Data;

@Data
public class LikeCreateRequest {
	private Long postId;
	private Long userId;
	
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
