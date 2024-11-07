package com.kibernumacademy.mvc_crud_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kibernumacademy.mvc_crud_app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/users")
public class UserController {
  
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public String index(Model model) {
      model.addAttribute("users", userService.getAllUser());
      return "users/index";
  }
  

}

// localhost:8080/users (GET)
// localhost:8080/users (POST)
// localhost:8080/users (UPDATED)
// localhost:8080/users (DELETE)
