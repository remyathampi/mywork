package com.study.rest.webservices.restfulwebservices.user;

public class Posts {
	
	private String postMessage;
	private Integer postId;
	
	public String getPostMessage() {
		return postMessage;
	}
	public Posts(int postId, String postMessage) {
		super();
		this.postId = postId;
		this.postMessage = postMessage;
	}
	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	
}
