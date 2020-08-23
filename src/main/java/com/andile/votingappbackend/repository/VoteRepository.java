package com.andile.votingappbackend.repository;

import com.andile.votingappbackend.model.Post;
import com.andile.votingappbackend.model.User;
import com.andile.votingappbackend.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
