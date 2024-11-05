package com.kibernumacademy.mvc_crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kibernumacademy.mvc_crud_app.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
  // la necesidad de crear metododos personalizados.

} 