package com.techpro.twitter.services;

import com.techpro.twitter.entities.User;
import com.techpro.twitter.services.exceptions.UserAlreadyExistException;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserService {

    User addNewUser(User userToSave) throws UserAlreadyExistException;

    List<User> getAllUsers();
}
