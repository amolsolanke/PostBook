package com.dna.postbook.users;

public interface IUsersService {

	Boolean follow(Long followerId, Long followeeId);

	Boolean unfollow(Long followerId, Long followeeId);

	Users checkUserExists(Long userId);

}
