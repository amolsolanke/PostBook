package com.dna.postbook;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dna.postbook.posts.IPostService;
import com.dna.postbook.posts.Post;
import com.dna.postbook.users.IUsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostbookApplicationTests {

	@Autowired
	IUsersService userService;
	
	@Autowired
	IPostService postService;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void followTest() {
		Boolean result = userService.follow(1L, 2L);
		Assert.assertEquals(true, result.booleanValue());
		
	}

	@Test
	public void unfollowTest() {
		Boolean result = userService.unfollow(1L, 2L);
		Assert.assertEquals(true, result.booleanValue());
		
	}
	
	@Test
	public void createPostTest() {
		
		Post post = null; 
		for(int i=1; i <= 10; i++) {
			post = postService.createPost(1L, "Post From user 1, post number: " + i);
			Assert.assertNotNull(post);
		}
		
		for(int i=1; i <= 5; i++) {
			postService.createPost(2L, "Post From user 1, post number: " + i);
			Assert.assertNotNull(post);
		}
		
		for(int i=11; i <= 20; i++) {
			postService.createPost(1L, "Post From user 1, post number: " + i);
			Assert.assertNotNull(post);
		}
	}
	
	@Test
	public void getNewsFeedTest() {
		
		postService.getNewsFeed(1L);
		
	}
}
