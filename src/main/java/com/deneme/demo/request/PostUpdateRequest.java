package com.deneme.demo.request;

import lombok.Data;

@Data
public class PostUpdateRequest {
	private String text;
	private String title;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
