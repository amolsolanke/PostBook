package com.dna.postbook.posts;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dna.postbook.users.IUsersService;
import com.dna.postbook.users.Users;

@Service
public class PostServiceImpl implements IPostService {

	@Autowired
	PostRepository postRepo;
	
	@Autowired
	IUsersService userService;
	
	@Override
	public Post createPost(Long userId, String content) {
		
		Users user = userService.checkUserExists(userId);
		
		Post post = new Post();
		post.setCreatedTime(new Date());
		post.setModifiedTime(new Date());
		post.setPostMsg(content);
		post.setUser(user);
		return postRepo.save(post);
		
	}

	@Override
	public List<Post> getNewsFeed(Long userId) {
		
		userService.checkUserExists(userId);
		return postRepo.getNewsFeed(userId);
	}

	
}
