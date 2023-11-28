package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.Post;
import com.techpro.twitter.entities.User;
import com.techpro.twitter.repositories.PostRepo;
import com.techpro.twitter.repositories.UserRepo;
import com.techpro.twitter.services.PostService;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import com.techpro.twitter.services.requests.PostRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private PostRepo postRepo;

    private UserRepo userRepo;

    public PostServiceImpl(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }


    @Override
    public Long sendPost(PostRequest postRequest) throws UserNotFoundException {
            Optional<User> optionalUser = userRepo.findById(postRequest.getUserId());
            if (optionalUser.isEmpty()) {
                throw new UserNotFoundException("User with id: " + postRequest.getUserId() + " couldn't found.");
            } else {
                Post postToSave = new Post();
                postToSave.setText(postRequest.getText());
                postToSave.setTitle(postRequest.getTitle());
                postToSave.setUser(optionalUser.get());
                return postRepo.save(postToSave).getId();
            }
    }

    @Override
    public Set<Post> getPostsForUser(Long userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id: " + userId + " couldn't found.");
        } else {
            return postRepo.findAllByUser_Id(userId);
        }
    }

}
