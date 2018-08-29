package com.recreations.service.impl;

import com.recreations.model.Training;
import com.recreations.repository.TrainingDAO;
import com.recreations.service.TrainingService;
import com.recreations.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {
  @Autowired private TrainingDAO repository;

  @Override
  public List<Training> getAll() {
    return repository.findAll();
  }

  @Override
  public Training get(Integer id)  {
    return Optional.ofNullable(repository.findOne(id)).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public Training add(Training newObject) {
    return repository.save(newObject);
  }

  @Override
  public Integer remove(Training obj) {
    repository.delete(obj);
    return obj.getTreningId();
  }

  @Override
  public void update(Training obj) {
    repository.saveAndFlush(obj);
  }
}
