package com.techpro.twitter.repositories;

import com.techpro.twitter.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PostRepo extends JpaRepository<Post, Long> {

    Set<Post> findAllByUser_Id(Long userId);
}
