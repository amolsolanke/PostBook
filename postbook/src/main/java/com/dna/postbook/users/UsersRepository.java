package com.dna.postbook.users;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	@Modifying
	@Query(value = "insert into followees values (:followerId, :followeeId)", nativeQuery=true)
	int follow(@Param("followerId") Long followerId, @Param("followeeId") Long followeeId);

	@Modifying
	@Query(value = "delete from followees where follower_id =:followerId and followee_id =:followeeId", nativeQuery=true)
	int unfollow(@Param("followerId") Long followerId, @Param("followeeId") Long followeeId);
}
