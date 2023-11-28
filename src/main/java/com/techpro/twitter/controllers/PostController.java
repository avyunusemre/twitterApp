package com.techpro.twitter.controllers;

import com.techpro.twitter.entities.Post;
import com.techpro.twitter.services.Impl.PostServiceImpl;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import com.techpro.twitter.services.requests.PostRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping("/send")
    public ResponseEntity<Long> sendPostForUser(@RequestBody PostRequest postRequest) throws UserNotFoundException {
        return new ResponseEntity<>(postService.sendPost(postRequest), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Set<Post>> getAllPostsForUser(@PathVariable Long userId) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getPostsForUser(userId), HttpStatusCode.valueOf(200));
    }

}
