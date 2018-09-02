package com.study.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int count = 3;
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Jack",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null)
			user.setId(++count);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public Posts retrievePost(int userId,int postId) {
		User user = this.findOne(userId);
		if(null!=user) {
			Map<Integer, Posts> postMap = user.getPostMap();
			Posts post =  (Posts)postMap.get(new Integer(postId));
			return post;
		}
		return null;
	}
	
	public List<Posts> retrievePosts(int userId){
		User user = this.findOne(userId);
		List <Posts> postList = new ArrayList<Posts>();
		if(null != user) {
			postList.addAll(user.getPostMap().values());					
		}
		
		return postList;
	}
	
	public Posts createPost(int userId, Posts postMessage) {
		User user = this.findOne(userId);
		if(null != user) {
			Integer id = User.getPostId();
			Map<Integer, Posts> postMap = user.getPostMap();
			if(postMessage.getPostId() == null) {
				postMessage.setPostId(id);
				postMap.put(id, postMessage);
			}else {
				postMap.put(postMessage.getPostId(), postMessage);
			}
		}
		return postMessage;
	}

	
}
