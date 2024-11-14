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

  // Obtener un usuario por su id
  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("User not found"));
  }

  // Crear el usuario
  public User createUser(User user) {
    return userRepository.save(user);
  }

  // Actualizacion del usuario
  public User updateUser(Long id, User user) {
    User existingUser = getUserById(id); // Verificamos si el usuario existe
    existingUser.setName(user.getName());
    existingUser.setEmail(user.getEmail());
    return userRepository.save(existingUser);
  }

  // Eliminacion
  public void deleteUser(Long id) {
    if(!userRepository.existsById(id)) {
      throw new IllegalArgumentException("User not found");
    }
    userRepository.deleteById(id);
  }



}
