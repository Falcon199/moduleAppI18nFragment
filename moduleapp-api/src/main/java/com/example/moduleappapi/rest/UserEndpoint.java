package com.example.moduleappapi.rest;

import com.example.moduleappcommon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

  @Autowired
  public UserRepository userRepository;

  @GetMapping("/users")
  public ResponseEntity getUsers() {
    return ResponseEntity.ok(userRepository.findAll());
  }

}