package com.recreations.service.impl;

import com.recreations.model.User;
import com.recreations.repository.UserDAO;
import com.recreations.service.UserService;
import com.recreations.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserDAO repository;

  @Override
  public List<User> getAll() {
    return repository.findAll();
  }

  @Override
  public User get(String id)  {
    return Optional.ofNullable(repository.findOne(id)).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public User add(User newObject) {
    return repository.save(newObject);
  }

  @Override
  public User remove(String obj) {
    User u = get(obj);
    repository.delete(obj);
    return u;
  }

  @Override
  public void update(User obj) {
    repository.saveAndFlush(obj);
  }
}
