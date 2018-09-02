package com.recreations.controller;

import com.recreations.model.User;
import com.recreations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:2000")
public class UserController {

  @Autowired private UserService service;

  @GetMapping("/all")
  public @ResponseBody Object getAll() {
    return ResponseEntity.ok().body(service.getAll());
  }

  @GetMapping("/{id}")
  public @ResponseBody Object get(@PathVariable String id)  {
    return ResponseEntity.ok().body(service.get(id));
  }

  @PostMapping("/")
  public @ResponseBody Object addUser(@RequestBody User user) {
    return  ResponseEntity.ok().body(service.add(user));
  }
}
