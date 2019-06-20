package com.dna.postbook.posts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Query( value = "select p.* from post p inner join followees f  on p.user_id =f.follower_id or p.user_id = f.followee_id where p.user_id =:userId or f.follower_id =:userId order by p.created_time desc limit 20", nativeQuery=true )
	List<Post> getNewsFeed( @Param("userId") Long userId);

}
