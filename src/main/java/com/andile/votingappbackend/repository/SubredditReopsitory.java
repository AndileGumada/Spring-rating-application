package com.andile.votingappbackend.repository;

import com.andile.votingappbackend.model.Subreddit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubredditReopsitory extends CrudRepository<Subreddit, Long> {
    Optional<Subreddit> findByName(String subredditName);
}
