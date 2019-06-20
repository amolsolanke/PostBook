package com.dna.postbook.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private IPostService postService;
	
	@PostMapping("createPost/{userId}/{content}")
	public Post createPost(@PathVariable Long userId, @PathVariable String content) {
	
		return postService.createPost(userId, content);

	}
	
	@GetMapping("getNewsFeed/{userId}")
	public List<Post> getNewsFeed(@PathVariable Long userId) {
		
		return postService.getNewsFeed(userId);		
	}
	
}
