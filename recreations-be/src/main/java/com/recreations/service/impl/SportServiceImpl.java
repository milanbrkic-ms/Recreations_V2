package com.recreations.service.impl;

import com.recreations.model.Sport;
import com.recreations.repository.SportDAO;
import com.recreations.service.SportService;
import com.recreations.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImpl implements SportService {
  @Autowired private SportDAO repository;

  @Override
  public List<Sport> getAll() {
    return repository.findAll();
  }

  @Override
  public Sport get(Integer id)  {
    return Optional.ofNullable(repository.findOne(id)).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public Sport add(Sport newObject) {
    return repository.save(newObject);
  }

  @Override
  public Integer remove(Sport obj) {
    repository.delete(obj);
    return obj.getSportID();
  }

  @Override
  public void update(Sport obj) {
    repository.saveAndFlush(obj);
  }
}
