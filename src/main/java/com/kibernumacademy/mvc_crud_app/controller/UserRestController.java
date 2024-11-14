package com.kibernumacademy.mvc_crud_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kibernumacademy.mvc_crud_app.model.User;
import com.kibernumacademy.mvc_crud_app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    
  private final UserService userService;
  public UserRestController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping()
  public ResponseEntity<List<User>> getAllUser() {
    List<User> users = userService.getAllUser();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user ) {
    User createdUser = userService.createUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    try {
      User user = userService.getUserById(id);
      return new ResponseEntity<>(user, HttpStatus.OK);
    } catch(IllegalArgumentException e ) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    try {
      User updateUser =  userService.updateUser(id, user);
      return new ResponseEntity<>(updateUser, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
