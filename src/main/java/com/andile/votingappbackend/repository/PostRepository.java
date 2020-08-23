package com.andile.votingappbackend.repository;

import com.andile.votingappbackend.model.Post;
import com.andile.votingappbackend.model.Subreddit;
import com.andile.votingappbackend.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
