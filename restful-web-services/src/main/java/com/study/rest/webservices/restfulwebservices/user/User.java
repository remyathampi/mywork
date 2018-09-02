package com.study.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
	private Integer id;
	private String name;
	private Date birthDate;	
	private Map<Integer,Posts> postMap = new HashMap<>();
	private static int postId = 100;
	

	public static int getPostId() {
		return ++postId;
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		Integer Id =new Integer(getPostId()) ;
		postMap.put(Id, new Posts(Id,"TestMessage"));
	}
	
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public Integer getId() {
		return id;
	}	

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	} 
	
	public Map<Integer, Posts> getPostMap() {
		return postMap;
	}

	public void setPostMap(Map<Integer, Posts> postMap) {
		this.postMap = postMap;
	}

}
