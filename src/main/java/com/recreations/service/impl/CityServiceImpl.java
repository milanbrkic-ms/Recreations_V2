package com.recreations.service.impl;

import com.recreations.repository.CityDAO;
import com.recreations.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recreations.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City get(Integer cityId) {
        return cityRepository.findOne(cityId);
    }

    @Override
    public void add(City newCity) {
        cityRepository.save(newCity);
    }

    @Override
    public Integer remove(City city) {
        cityRepository.delete(city);
        return city.getPtt();
    }

    @Override
    public void update(City city) {
        cityRepository.saveAndFlush(city);
    }
}
