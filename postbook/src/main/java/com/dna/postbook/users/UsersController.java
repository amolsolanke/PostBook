package com.dna.postbook.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

	@Autowired
	private IUsersService userService;
	
	@PostMapping("follow/{followerId}/{followeeId}")
	public ResponseEntity<String> follow(@PathVariable Long followerId, @PathVariable Long followeeId) {
		
		if( userService.follow(followerId, followeeId))
				return ResponseEntity.ok("{\"message\":\"Success!\"}");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error\"}");
		
		
	}
	
	@PostMapping("unfollow/{followerId}/{followeeId}")
	public ResponseEntity<String> unfollow(@PathVariable Long followerId, @PathVariable Long followeeId) {
		
		if(userService.unfollow(followerId, followeeId))
				return ResponseEntity.ok("{\"message\":\"Success!\"}");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error\"}");
		
		
	}
}
