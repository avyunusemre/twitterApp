package com.techpro.twitter.controllers;

import com.techpro.twitter.entities.User;
import com.techpro.twitter.services.Impl.UserServiceImpl;
import com.techpro.twitter.services.exceptions.UserAlreadyExistException;
import com.techpro.twitter.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody User userToSave) throws UserAlreadyExistException {
        User newUser = userService.addNewUser(userToSave);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.valueOf(200));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.valueOf(200));
    }
}
