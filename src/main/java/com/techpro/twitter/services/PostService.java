package com.techpro.twitter.services;

import com.techpro.twitter.entities.Post;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import com.techpro.twitter.services.requests.PostRequest;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

@Validated
public interface PostService {
    Long sendPost(PostRequest postRequest) throws UserNotFoundException;

    Set<Post> getPostsForUser(Long userId) throws UserNotFoundException;
}
