package com.techpro.twitter.services.Impl;

import com.techpro.twitter.entities.User;
import com.techpro.twitter.repositories.UserRepo;
import com.techpro.twitter.services.UserService;
import com.techpro.twitter.services.exceptions.UserAlreadyExistException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addNewUser(User userToSave) throws UserAlreadyExistException {
        if (userRepo.existsByEmail(userToSave.getEmail())) {
            throw new UserAlreadyExistException("User with email : " + userToSave.getEmail() + " is already exist.");
        }

        if (userRepo.existsByUsername(userToSave.getUsername())) {
            throw new UserAlreadyExistException("User with username : " + userToSave.getUsername() + " is already exist.");
        }

        return userRepo.save(userToSave);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()) {
           return optionalUser.get();
        } else {
            throw new UserNotFoundException("User with id: " + id + " couldn't found.");
        }
    }
}
