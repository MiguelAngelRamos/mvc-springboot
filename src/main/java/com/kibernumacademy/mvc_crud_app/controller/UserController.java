package com.kibernumacademy.mvc_crud_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kibernumacademy.mvc_crud_app.model.User;
import com.kibernumacademy.mvc_crud_app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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

  @GetMapping("/create")
  public String createForm(Model model) {
    model.addAttribute("user", new User());
    return "users/create";
  }

  @PostMapping
  public String createUser(@ModelAttribute("user") User user) {
    userService.createUser(user);
    return "redirect:/users";
  }

  @GetMapping("/edit/{id}") // localhost:8080/users/edit/1
  public String editForm(@PathVariable Long id, Model model) {
    model.addAttribute("user", userService.getUserById(id));
    return "users/edit";
  }

  @PostMapping("/update/{id}") 
  public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
    userService.updateUser(id, user);
    return "redirect:/users"; // a la pagina principal
  }

  @GetMapping("/delete/{id}")
  public String deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return "redirect/users";
  }


}





// localhost:8080/users (GET)
// localhost:8080/users (POST)
// localhost:8080/users (UPDATED)
// localhost:8080/users (DELETE)
