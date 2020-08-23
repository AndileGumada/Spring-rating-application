package com.andile.votingappbackend.repository;

import com.andile.votingappbackend.model.Comment;
import com.andile.votingappbackend.model.Post;
import com.andile.votingappbackend.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
