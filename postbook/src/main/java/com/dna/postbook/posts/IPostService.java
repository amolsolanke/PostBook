package com.dna.postbook.posts;

import java.util.List;

public interface IPostService {

	Post createPost(Long userId, String content);

	List<Post> getNewsFeed(Long userId);

}
