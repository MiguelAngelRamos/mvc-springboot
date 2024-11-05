package com.kibernumacademy.mvc_crud_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "users") // esta anotación nos sirve para indicar el nombre de la tabla en la base datos
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY) // Esta anotacion sirve para indicar que el campo id es auto-incremental
  private Long id;
  @Column(name="name", nullable = false)
  private String name;
  @Column(name="email", nullable = false, unique=true)
  @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email no valido")
  private String email;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
}
