package com.kibernumacademy.mvc_crud_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kibernumacademy.mvc_crud_app.model.User;
import com.kibernumacademy.mvc_crud_app.repository.IUserRepository;

@Service
public class UserService {
  
  private final IUserRepository userRepository;

  @Autowired
  public UserService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // Lista User
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

}
