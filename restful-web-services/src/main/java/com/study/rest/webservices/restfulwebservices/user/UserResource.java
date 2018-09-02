package com.study.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	//retrieveAllUsers
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//retrieveUser{id}
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id : "+id);
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//retrieveAllPosts{id}
	@GetMapping(path="/users/{userId}/posts")
	public List<Posts> retrieveAllPosts(@PathVariable int userId){
		List<Posts> postList = service.retrievePosts(userId);
		if(postList == null) {
			
		}
		return postList;
	}
	
	//retrievePost{id,id}
	@GetMapping(path="/users/{userId}/posts/{postId}")
	public Posts retrievePost(@PathVariable int userId,@PathVariable int postId) {
		return service.retrievePost(userId, postId);		
	}
	
	//createPost{id,postMessgage}
	@PostMapping(path="/users/{id}/posts")
	public ResponseEntity<Object> createPost(@RequestBody Posts post,@PathVariable int id){
		Posts savedPost = service.createPost(id,post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getPostId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
}

