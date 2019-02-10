package com.recreations.service.impl;

import com.recreations.model.City;
import com.recreations.repository.CityDAO;
import com.recreations.service.CityService;
import com.recreations.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

  @Autowired private CityDAO cityRepository;

  @Override
  public List<City> getAll() {
    return cityRepository.findAll();
  }

  @Override
  public City get(Integer cityId)  {
    return Optional.ofNullable(cityRepository.findOne(cityId)).orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public City add(City newCity) {
    return cityRepository.save(newCity);
  }

  @Override
  public City remove(Integer obj) {
    City deleted = get(obj);
    cityRepository.delete(obj);
    return deleted;
  }

  @Override
  public void update(City city) {
    cityRepository.saveAndFlush(city);
  }
}
