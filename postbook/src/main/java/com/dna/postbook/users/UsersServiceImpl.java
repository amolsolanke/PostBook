package com.dna.postbook.users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private UsersRepository userRepo;

	@Override
	public Boolean follow(Long followerId, Long followeeId) {

		checkUserExists(followerId);
		checkUserExists(followeeId);

		try {
			userRepo.follow(followerId, followeeId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean unfollow(Long followerId, Long followeeId) {

		checkUserExists(followerId);
		checkUserExists(followeeId);

		try {
			int deletedRecord = userRepo.unfollow(followerId, followeeId);
			if(deletedRecord == 1)
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public Users checkUserExists(Long userId) {

		Optional<Users> user = userRepo.findById(userId);
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + userId);

		return user.get();
	}
}
